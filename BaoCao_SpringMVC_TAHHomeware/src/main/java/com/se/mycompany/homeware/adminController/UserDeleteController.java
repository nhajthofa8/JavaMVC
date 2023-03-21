package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.service.UserService;
import com.se.mycompany.homeware.serviceImpl.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/user")
public class UserDeleteController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    UserService userService = new UserServicesImpl();

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("user-id") int user_id, Model theModel) {
        userService.delete(user_id);
        theModel.addAttribute("userList", userService.getAll());
        return "user";
    }
}
