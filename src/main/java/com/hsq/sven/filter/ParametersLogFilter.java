package com.hsq.sven.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  

/**
 * Servlet Filter implementation class ParametersLogFilter
 */
public class ParametersLogFilter implements Filter {
	final static Logger logger = LoggerFactory.getLogger(ParametersLogFilter.class);

    /**
     * Default constructor. 
     */
    public ParametersLogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		
		
		StringBuilder sb=new StringBuilder();
		Set<String> keys=httpRequest.getParameterMap().keySet();
		for(String key:keys){
			sb.append(key).append("=").append(request.getParameter(key)).append("&");
		}
		logger.info("url="+httpRequest.getRequestURL()+" query string="+httpRequest.getQueryString());
		logger.info("all string="+sb);
		logger.info("headers:==========================================================================");
		Enumeration<String> headerNames=httpRequest.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String name=headerNames.nextElement();
			String value=httpRequest.getHeader(name);
			logger.info(name+"="+value);
		}
		logger.info("headers:================================end=======================================");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
