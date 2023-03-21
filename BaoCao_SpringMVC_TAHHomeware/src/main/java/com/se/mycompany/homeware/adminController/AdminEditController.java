package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.Admin;
import com.se.mycompany.homeware.service.AdminService;
import com.se.mycompany.homeware.serviceImpl.AdminServicesImpl;
import java.io.IOException;

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
@RequestMapping("/admin/admin")
public class AdminEditController {
	private static final long serialVersionUID = 1L;
        
	@Autowired
	AdminService adminService = new AdminServicesImpl();
	@GetMapping("/edit")
	public String editAdmin(@RequestParam("id") int admin_id, Model theModel){
		Admin admin = adminService.get(admin_id);
                theModel.addAttribute("admin", admin);
                return "editadmin";
    }

	@PostMapping("/edit")
	public String postEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		int admin_id = Integer.parseInt(req.getParameter("id"));
		String admin_username = req.getParameter("username");
		String admin_password = req.getParameter("password");
		String admin_name = req.getParameter("name");	
		
		Admin admin = new Admin();
		admin.setId(admin_id);
		admin.setUsername(admin_username);
		admin.setPassword(admin_password);
		admin.setName(admin_name);
		adminService.edit(admin);
                return "redirect:/admin/admin/list";

	}  
}
