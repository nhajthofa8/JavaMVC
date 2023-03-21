package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.daoImpl.LoginDao;
import com.se.mycompany.homeware.model.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class LoginController
 */
@Controller
@RequestMapping("/view/client")
public class LoginController {

    private static final long serialVersionUID = 1L;
    @Autowired
    LoginDao loginDao = new LoginDao();

    public LoginController() {
        super();
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.err.println("1");
        User u = loginDao.checkLogin(username, password);
        if (u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            System.err.println("OK");
            return "redirect:/";
        } else {
            request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
            return "login";
        }

    }

}
