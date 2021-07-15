package flow.mvc.aop;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import flow.mvc.controller.member.MemberController;

/**
 * @author 허태준 / 2021. 7. 11. / 오후 9:06:16
 */
@Component
@Aspect
public class Advice {
	private static final Log LOG = LogFactory.getLog( Advice.class );

	  	
	// advice 수정

	private void printParam(ProceedingJoinPoint pjp) {
		Object[] param = pjp.getArgs();
		if (param.length != 0) {
			int length = param.length;
			for (int i = 0; i < length; i++) {
				LOG.info((i+1)+"번째 param: "+param[i]);
			}
		}
	}

	@Around(value = "execution(* flow.mvc.controller.*.*.*(..))")
	public Object logAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// MethodInvocation을 통해 메서드 정보, 타겟 오브젝트에 대한 정보 알 수있다
		String methodName = pjp.getSignature().getName();
		LOG.info("======================================");
		LOG.info("[LOG]  METHOD  :: " + methodName + " is calling.");
		printParam(pjp);
		Object rev = pjp.proceed();
		if (rev != null) {
			LOG.info("returnv :: " + rev);
		}
		printParam(pjp);
		LOG.info("[LOG]  METHOD  :: " + methodName + " was called.");
		LOG.info("======================================");
		return rev;
	}
}
