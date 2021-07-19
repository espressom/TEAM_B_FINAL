package flow.mvc.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author 허태준 / 2021. 7. 15. / 오후 4:07:07
 */
public class Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("=========================preHandle executed");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("sessionID");
          
        if ( obj == null ){
            // 로그인이 안되어 있는 상태일때 로그인 폼으로 다시 돌려보냄
        	PrintWriter printwriter = response.getWriter();
        	printwriter.print("<script>alert('로그인페이지로 이동'); location.href='/Flow_0710ver/loginForm';</script>");
        	printwriter.flush();
        	printwriter.close();
        	// preHandle의 return값은 요청이 컨트롤러로 가느냐 마느냐
            return false; 
        }
          
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	
}
