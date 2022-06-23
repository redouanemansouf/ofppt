package com.m2m.onousc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter (filterName = "loginFilter", urlPatterns = { "/pages/*"}) 
public class loginFilter implements Filter{  


	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	    	HttpServletRequest req = (HttpServletRequest) request; 
	        HttpSession session = req.getSession(false);   
	        boolean loginURLs = req.getRequestURI().endsWith("login.xhtml") || req.getRequestURI().equals("/onousc/");
	        //Redirect the user to home page if he is already connected
			if(loginURLs && (session!= null && session.getAttribute("userSession") != null)){  
	        	HttpServletResponse res = (HttpServletResponse) response;
	            res.sendRedirect("/mxcampus/pages/espaces.xhtml");        	
	        }
			//Intercept every Request from user to determine if he has valid session or not 
	        boolean urlsToExclude = req.getRequestURI().endsWith("reservationForm.xhtml") 
	        		            ||  req.getRequestURI().endsWith("pwdOublie.xhtml")
				        		|| req.getRequestURI().endsWith("pwdOublie.xhtml")
				        		|| req.getRequestURI().contains("resource")
				        		|| req.getRequestURI().contains("reservationRepas.xhtml")
				        		|| req.getRequestURI().contains("/venteLocal/venteMifare.xhtml")
				        		|| req.getRequestURI().contains("/venteLocal/vente.xhtml")
				        		|| loginURLs;
	         
			if(urlsToExclude || (session!= null && session.getAttribute("userSession") != null)) {
//				if(!urlsToExclude){ 
					chain.doFilter(request, response);   
//				}
	        } else {  
	        	//Redirect the user to the login page if he has not a valid session   
	            HttpServletResponse res = (HttpServletResponse) response;
	            res.sendRedirect("/mxcampus/public/login.xhtml");     	
	            return;
	        } 
 
	    }

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {

	    }

	    @Override
	    public void destroy() {
	    }
	    
}
