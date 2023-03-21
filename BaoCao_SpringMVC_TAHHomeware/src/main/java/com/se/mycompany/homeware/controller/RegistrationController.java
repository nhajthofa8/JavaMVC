package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.daoImpl.RegisterDao;
import com.se.mycompany.homeware.model.User;
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

/**
 * Servlet implementation class RegistrationController
 */
@Controller
@RequestMapping("/view/client")
public class RegistrationController {

    private static final long serialVersionUID = 1L;
    @Autowired
    RegisterDao register = new RegisterDao();

    public RegistrationController() {
        super();
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        Date created = Date.valueOf(request.getParameter("created"));

        User user = new User(username, password, email, phone, name, created);
        System.err.println(user);

        
        if (register.RegisterUser(user)) // On success, you can display a message to user on Home page
        {
            request.setAttribute("Message", "Bạn đã tạo tài khoàn thành công. Mời bạn đăng nhập <a href='/do-an-java/view/client/login'>tại đây!</a>");
            return "register";
        } else {
            request.setAttribute("errMessage", "Tạo tài khoản thất bại. Hãy thử lại !!!");
            return "register";
        }
    }
}
