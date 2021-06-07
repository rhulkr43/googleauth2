package com.googleauth2.googleauth2.Controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Home  {

	
	@RequestMapping("/")
	@ResponseBody
	public String index(Principal principal) {
		
		 return "index";
	}
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
	
		return principal;
	}
	@RequestMapping("/login")
	public String login() {
		System.out.println("login Page Redirec");
		return "login";
	}
	
	
	@RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(false);
        new SecurityContextLogoutHandler().logout(request,response,authentication);
        SecurityContextHolder.clearContext();
        request.logout();
        request.getSession().invalidate();
    }
	
}
