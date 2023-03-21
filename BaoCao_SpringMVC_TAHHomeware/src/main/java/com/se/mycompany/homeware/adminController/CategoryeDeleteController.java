package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.service.CategoryService;
import com.se.mycompany.homeware.serviceImpl.CategoryServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Servlet implementation class CatagoryDeleteController
 */
@Controller
@RequestMapping("/admin/cate")
public class CategoryeDeleteController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    CategoryService cateService = new CategoryServicesImpl();

    @GetMapping("/delete")
    public String deleteCate(@RequestParam("id") String id) {
        cateService.delete(id);

        return "redirect:/admin/cate/list";
    }

}
