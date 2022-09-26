package cn.smbms.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);

	public void beforeMethod() {
		logger.info("使用XML配置定义切面，开始执行方法。。。");
	}
	public void afterMethod() {
		logger.info("使用XML配置定义切面，完成执行方法。。。");
	}
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("日志打印");
		return true;
	}


}
