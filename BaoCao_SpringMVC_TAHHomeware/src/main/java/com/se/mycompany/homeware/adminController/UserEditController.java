package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.User;
import com.se.mycompany.homeware.service.UserService;
import com.se.mycompany.homeware.serviceImpl.UserServicesImpl;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/user")
public class UserEditController {

    private static final long serialVersionUID = 1L;
    @Autowired
    UserService userService = new UserServicesImpl();

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("user-id") int user_id, Model theModel) {
        User user = userService.get(user_id);
        theModel.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/edit")
    public String editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        int user_id = Integer.parseInt(req.getParameter("user-id"));
        String user_name = req.getParameter("user-name");
        String user_email = req.getParameter("user-email");
        String user_phone = req.getParameter("user-phone");
        String user_userName = req.getParameter("user-userName");
        String user_password = req.getParameter("user-password");
        Date user_created = Date.valueOf(req.getParameter("user-created"));

        User user = new User();
        user.setName(user_name);
        user.setEmail(user_email);
        user.setPhone(user_phone);
        user.setUsername(user_userName);
        user.setPassword(user_password);
        user.setCreated(user_created);
        user.setId(user_id);
        userService.edit(user);

        return "redirect:/admin/user/list";
    }

}
