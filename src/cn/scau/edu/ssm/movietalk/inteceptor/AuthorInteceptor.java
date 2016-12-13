package cn.scau.edu.ssm.movietalk.inteceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorInteceptor implements HandlerInterceptor {
	private static Logger logger = Logger.getLogger(AuthorInteceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex)
			throws Exception {
		//填写日志
		if(ex != null) {
			logger.error("error start ----------------" + new Date() + "--------------------\n");
			logger.error(ex.getMessage());
			System.out.println();
			logger.error(ex.toString());
			System.out.println();
			logger.error("error end ----------------" + new Date() + "--------------------\n");
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView mav) throws Exception {
		//加入公共模块数据
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		//用户权限验证
		String url = request.getRequestURI();
		return true;
	}

}
