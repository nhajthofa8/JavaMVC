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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Servlet implementation class CatagoryEditController
 */
@Controller
@RequestMapping("/admin/cate")
public class CategoryEditController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    CategoryService cateService = new CategoryServicesImpl();

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("id") String id, Model theModel) {
        Catalog catelist = cateService.get(Integer.parseInt(id));
        theModel.addAttribute("catelist", catelist);
        return "editcate";
    }

    @PostMapping("/edit")
    public String editCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Catalog category = new Catalog();
        category.setName(req.getParameter("name"));
        category.setParent_id(req.getParameter("parent-id"));
        category.setId(Integer.parseInt(req.getParameter("id")));
        cateService.edit(category);

        return "redirect:/admin/cate/list";

    }
}
