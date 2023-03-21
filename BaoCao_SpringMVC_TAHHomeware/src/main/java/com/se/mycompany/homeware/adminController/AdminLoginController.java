package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.dao.AdminLoginDao;
import com.se.mycompany.homeware.model.Admin;
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

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    private static final long serialVersionUID = 1L;
    @Autowired
    AdminLoginDao adminLoginDao = new AdminLoginDao();

    public AdminLoginController() {
        super();
    }

    @GetMapping("/login")
    public String showFormLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("admin-username");
        String password = request.getParameter("admin-password");
        Admin admin = new Admin();
        admin.setName(request.getParameter("name"));

        if (adminLoginDao.checkAdminLogin(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin-username", username);
            session.setAttribute("admin-password", password);
            return "redirect:/admin/homepage";
        } else {
            request.setAttribute("errorMessage", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
            return "login";
        }

    }

}
