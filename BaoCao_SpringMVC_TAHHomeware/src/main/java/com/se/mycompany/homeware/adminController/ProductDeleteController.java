package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.service.ProductService;
import com.se.mycompany.homeware.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Servlet implementation class CatagoryDeleteController
 */
@Controller
@RequestMapping("/admin/product")
public class ProductDeleteController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    ProductService productService = new ProductServiceImpl();

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        productService.delete(id);
        return "redirect:/admin/product/list";
    }

}
