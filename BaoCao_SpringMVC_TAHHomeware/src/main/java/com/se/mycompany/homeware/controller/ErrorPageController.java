package com.se.mycompany.homeware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class ErrorPageController
 */
@Controller
@RequestMapping("")
public class ErrorPageController {

    private static final long serialVersionUID = 1L;

    @GetMapping("/404")
    public String errorPage() {
        return "404";
    }
}
