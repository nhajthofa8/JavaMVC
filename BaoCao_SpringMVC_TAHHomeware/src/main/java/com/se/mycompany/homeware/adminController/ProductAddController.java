package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.Catalog;
import com.se.mycompany.homeware.model.Product;
import com.se.mycompany.homeware.service.CategoryService;
import com.se.mycompany.homeware.service.ProductService;
import com.se.mycompany.homeware.serviceImpl.CategoryServicesImpl;
import com.se.mycompany.homeware.serviceImpl.ProductServiceImpl;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductAddController {

    private static final long serialVersionUID = 1L;

    @Autowired
    ProductService productService = new ProductServiceImpl();

    @Autowired
    CategoryService categoryService = new CategoryServicesImpl();

    @GetMapping("/add")
    public String showFormAdd(Model theModel) {
        List<Catalog> cateList = categoryService.getAll();
        theModel.addAttribute("catelist", cateList);
        return "addproduct";
    }

    @PostMapping("/add")
    public String addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String product_cate = req.getParameter("product-cate");
        String product_name = req.getParameter("product-name");
        String product_price = req.getParameter("product-price");
        String product_status = req.getParameter("product-status");
        String product_desc = req.getParameter("product-desc");
        String product_content = req.getParameter("product-content");
        String product_discount = req.getParameter("product-discount");
        String product_image = req.getParameter("product-image");
        String product_day = req.getParameter("product-day");

        Product product = new Product();
        product.setCatalog_id(Integer.parseInt(product_cate));
        product.setName(product_name);
        product.setPrice(product_price);
        product.setStatus(Integer.parseInt(product_status));
        product.setDescription(product_desc);
        product.setContent(product_content);
        product.setDiscount(Integer.parseInt(product_discount));
        product.setImage_link(product_image);
        product.setCreated(Date.valueOf(product_day));
        System.err.println(product);
        productService.insert(product);
        return "redirect:/admin/product/list";

    }
}
