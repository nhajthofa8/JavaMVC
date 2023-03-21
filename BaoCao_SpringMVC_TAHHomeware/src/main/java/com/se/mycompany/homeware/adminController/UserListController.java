package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.User;
import com.se.mycompany.homeware.service.UserService;
import com.se.mycompany.homeware.serviceImpl.UserServicesImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserListController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    UserService userService = new UserServicesImpl();

    @GetMapping("/list")
    public String listUsers(Model theModel) {
        List<User> users = userService.getAll();
        theModel.addAttribute("userList", users);
        return "user";
    }
}
