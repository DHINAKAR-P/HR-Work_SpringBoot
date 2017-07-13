package com.hrapp.module.bootsecurity.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SimpleCORSFilter implements Filter {
	
	public SimpleCORSFilter () {
	    super();
	}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String refFromReq = request.getHeader("Referer");//  
        System.out.println("SimpleCORSFilter---->>>>"+refFromReq);
        if(refFromReq  != null){
        	if (refFromReq.endsWith("/")) {
        		refFromReq = refFromReq.substring(0, refFromReq.length() - 1);
				System.err.println("referer data after remove slash=>"+refFromReq);
				//response.setHeader("Access-Control-Allow-Origin", refFromReq);
			}
        }
        //System.err.println("Incoming the request or not");
        //dynamic http://localhost:8100
       // String refer = "http://localhost:4200";
        System.err.println("refFromReq----------->"+refFromReq);
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,Accept-Encoding,Accept-Language,X-Requested-With, Content-Type");
        
        if(request.getMethod().equalsIgnoreCase("options")){
            return;
       }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {System.out.println("SimpleCORSFilter--init--Method>>>> ");}
    public void destroy() {System.out.println("SimpleCORSFilter---Destroy-----Method>>>> ");}
	    
}