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
 * @author ������ / 2021. 7. 11. / ���� 9:06:16
 */
@Component
@Aspect
public class Advice {
	private static final Log LOG = LogFactory.getLog( Advice.class );

	  	
	// advice ����

	private void printParam(ProceedingJoinPoint pjp) {
		Object[] param = pjp.getArgs();
		if (param.length != 0) {
			int length = param.length;
			for (int i = 0; i < length; i++) {
				LOG.info((i+1)+"��° param: "+param[i]);
			}
		}
	}

	@Around(value = "execution(* flow.mvc.controller.*.*.*(..))")
	public Object logAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// MethodInvocation�� ���� �޼��� ����, Ÿ�� ������Ʈ�� ���� ���� �� ���ִ�
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
