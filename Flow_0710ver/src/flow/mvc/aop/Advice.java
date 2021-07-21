package flow.mvc.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import flow.mvc.controller.member.MemberController;
import flow.mvc.dao.log.LogDaoInter;
import flow.mvc.vo.LogVO;

/**
 * @author 허태준 / 2021. 7. 11. / 오후 9:06:16
 */
@Component
@Aspect
public class Advice {

	private static final Log LOG = LogFactory.getLog(Advice.class);
	@Autowired
	private LogDaoInter logDaoInter;

	private void printParam(ProceedingJoinPoint pjp, LogVO lvo) {
		Object[] param = pjp.getArgs();
		StringBuilder sb = new StringBuilder("");
		if (param.length != 0) {
			int length = param.length;

			for (int i = 0; i < length; i++) {
				if (param[i] instanceof String) {
					sb.append(param[i]);
					sb.append("/");
				}
				LOG.info("| " + (i + 1) + "번째 param: " + param[i]);
			}
		}
		lvo.setParams(sb.toString());
	}

	@Around(value = "execution(* flow.mvc.controller.*.*.*(..))")
	public Object logAdvice(ProceedingJoinPoint pjp) throws Throwable {

		LogVO lvo = new LogVO();
		String methodName = pjp.getSignature().getName();
		lvo.setRequest(methodName);
		String[] classNames = pjp.getTarget().getClass().getCanonicalName().split("\\.");
		String className = classNames[classNames.length - 1];
		LOG.info("=================================================");
		LOG.info("| [LOG]  " + className + " :: " + methodName + " 호출");
		lvo = getLogInfo(lvo);
		if (lvo.getM_id() != null) {
			LOG.info("| [B Y]  " + lvo.getM_id());
		}
		printParam(pjp, lvo);
		Object rev = pjp.proceed();
		if (rev != null) {
			LOG.info("| returnv :: " + rev);
		}
		printParam(pjp, lvo);
		LOG.info("| [LOG]  " + className + " :: " + methodName + " 종료");
		lvo = getLogInfo(lvo);
		if (lvo.getM_id() != null) {
			LOG.info("| [B Y]  " + lvo.getM_id());
		}
		LOG.info("=================================================");
		if (lvo.getM_id() == null) {
			lvo.setM_id("");
		}
		logDaoInter.addlog(lvo);
		return rev;
	}

	private LogVO getLogInfo(LogVO lvo) {
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
				.getRequest();
		lvo.setM_ip(request.getRemoteAddr());
		lvo.setUagent(request.getHeader("User-Agent"));
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("sessionID");
		lvo.setM_id(m_id != null ? m_id : lvo.getM_id()); 
		return lvo;
	}
}
