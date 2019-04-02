/*package com.hrapp.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class RedirectingAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String referer = request.getHeader("Referer");
		System.err.println("Referer data =>"+referer);
		if(referer != null){

			if (referer.endsWith("/")) {
				referer = referer.substring(0, referer.length() - 1);

				response.setHeader("Access-Control-Allow-Origin", referer);
			}
		}
		return  "/login/loginSuccess/";
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.err.println("\nonAuthenticationSuccess =>"+authentication.toString());
		System.err.println("\nresponse JSESSIONID =>"+response.getHeader("Set-Cookie"));
		//String cookies = response.getHeader("Set-Cookie");
		String cookies = "JSESSIONID=dhinakardummyjsonid;dummycookiesetted";
		if(cookies!=null){
		String [] v=cookies.split(";");
		System.out.println("v-->"+v[0]);
		String[] finaID = v[0].split("=");
		System.err.println("\nFINAL JSESSIONID ID =>"+finaID[1].toString());

		Cookie sidCookie = new Cookie("JSESSIONID",finaID[1].toString());
        sidCookie.setHttpOnly(true);
        response.addCookie(sidCookie);  
        }
		System.err.println("response =>"+response.toString().toString());
		super.onAuthenticationSuccess(request, response, authentication);
		}
	}
	*/