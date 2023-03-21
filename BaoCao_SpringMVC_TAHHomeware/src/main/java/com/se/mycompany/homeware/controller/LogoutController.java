package com.se.mycompany.homeware.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class LogoutController
 */
@Controller
@RequestMapping("/view/client")
public class LogoutController {
	private static final long serialVersionUID = 1L;
       
	@GetMapping("/logout")
	protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession(false);
		 if (session != null) {
			 session.removeAttribute("username"); //remove session
		 }
//		  resp.sendRedirect(req.getContextPath() + "/"); 
                  return "redirect:/";
	}

}
