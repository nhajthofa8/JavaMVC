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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserAddController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    UserService userService = new UserServicesImpl();

    @GetMapping("/add")
    public String showFormAdd() {
        return "adduser";
    }

    @PostMapping("/add")
    public String addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
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
        userService.insert(user);
        return "redirect:/admin/user/list";
    }

}
