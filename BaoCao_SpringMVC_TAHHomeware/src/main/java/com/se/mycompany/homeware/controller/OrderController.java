package com.se.mycompany.homeware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/client")
public class OrderController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
        @GetMapping("/order")
	public String getOrder() {
                return "order";
	}

}
