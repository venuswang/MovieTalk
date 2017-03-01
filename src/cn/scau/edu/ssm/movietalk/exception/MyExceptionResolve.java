package cn.scau.edu.ssm.movietalk.exception;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 定义自己的异常解析器
 * @author Administrator
 *
 */
public class MyExceptionResolve implements HandlerExceptionResolver {
	private static Logger logger = Logger.getLogger(MyExceptionResolve.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object object, Exception exception) {
		//填写日志
		if(exception != null) {
			logger.error("error start ----------------" + new Date() + "--------------------\n");
			logger.error(exception.getMessage());
	
			logger.error("\n error operating ----------------" + new Date() + "--------------------\n");
			logger.error(exception.toString());
			logger.error("error end ----------------" + new Date() + "--------------------");
		}
		
		MyException myException = null;
		ModelAndView mav = new ModelAndView();
		if(exception instanceof MaxUploadSizeExceededException)
		{
			String errors = "文件应不大于 "+ ((MaxUploadSizeExceededException)exception).getMaxUploadSize()+" byte.";
			mav.addObject("errors", errors);
			mav.setViewName("login/register");
			return mav;
		} else if(exception instanceof MyException) {
			myException = (MyException)exception;
		} else {
			myException = new MyException("错误编号20001:未知错误...");
		}
		String message = myException.getMessage();
		mav.addObject("message", message);
		mav.setViewName("501_page");
		return mav;
	}

}
