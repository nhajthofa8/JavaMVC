package com.se.mycompany.homeware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class CheckoutController
 */

@Controller
@RequestMapping("/view/client")
public class CheckoutController {
private static final long serialVersionUID = 1L;
	
        @GetMapping("/checkout")
	public String doGet(){
                return "checkout";
	}

}
