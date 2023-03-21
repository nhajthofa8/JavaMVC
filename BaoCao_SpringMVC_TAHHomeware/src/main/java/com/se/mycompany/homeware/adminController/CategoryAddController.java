package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.Catalog;
import com.se.mycompany.homeware.service.CategoryService;
import com.se.mycompany.homeware.serviceImpl.CategoryServicesImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class CategoryAddController
 */

@Controller
@RequestMapping("/admin/cate")
public class CategoryAddController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    CategoryService cateService = new CategoryServicesImpl();

    @GetMapping("/add")
    public String listCategory() {
        return "addcate";
    }

    @PostMapping("/add")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String cate_name = req.getParameter("cate-name");
        String cate_parent_id = req.getParameter("parent-id");
        Catalog category = new Catalog();
        category.setName(cate_name);
        category.setParent_id(cate_parent_id);
        cateService.insert(category);
        resp.sendRedirect(req.getContextPath() + "/admin/cate/list");
    }

}
