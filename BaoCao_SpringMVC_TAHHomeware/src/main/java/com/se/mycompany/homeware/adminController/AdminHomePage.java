package com.se.mycompany.homeware.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomePage {

    private static final long serialVersionUID = 1L;

    public AdminHomePage() {
        super();
    }

    @GetMapping("/homepage")
    public String homePage() {
        return "index";
    }

}
