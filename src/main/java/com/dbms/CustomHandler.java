package com.dbms;


import java.io.IOException;
import java.util.Set;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
public class CustomHandler implements
		AuthenticationSuccessHandler {
 
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		HttpSession session = request.getSession();
		
		/*Set some session variables*/
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        session.setAttribute("uname", authUser.getUsername());  
        session.setAttribute("authorities", authentication.getAuthorities()); 
        
        /*Set target URL to redirect*/
		String targetUrl = determineTargetUrl(authentication,session); 
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}
 
	protected String determineTargetUrl(Authentication authentication, HttpSession session) {
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (authorities.contains("ROLE_ADMIN")) {
    		String username=authentication.getName();
        	session.setAttribute("admin", username);
        	String role="ROLE_ADMIN";
        	session.setAttribute("role", role);
        	return "/admin";
        } else if (authorities.contains("ROLE_USER")) {
        	String username=authentication.getName();
        	session.setAttribute("user", username);
        	String role="ROLE_USER";
        	session.setAttribute("role", role);
        	return "/user";
        } else if (authorities.contains("ROLE_EMPLOYEE")) {
        	String username=authentication.getName();
        	session.setAttribute("empl", username);
        	String role="ROLE_EMPLOYEE";
        	session.setAttribute("role", role);
        	return "/empl";
        }else {
            throw new IllegalStateException();
        }
    }
 
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
}