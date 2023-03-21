package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Catalog;
import com.se.mycompany.homeware.model.Product;
import com.se.mycompany.homeware.service.CategoryService;
import com.se.mycompany.homeware.service.ProductService;
import com.se.mycompany.homeware.serviceImpl.CategoryServicesImpl;
import com.se.mycompany.homeware.serviceImpl.ProductServiceImpl;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view/client")
public class ProductListOfCategoryClientController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    CategoryService cateService = new CategoryServicesImpl();

    @Autowired
    ProductService productService = new ProductServiceImpl();
    DecimalFormat df = new DecimalFormat("#.000");

    @GetMapping("/product-id")
    public String GetProductId(@RequestParam("id") String id, Model theModel) {

        List<Catalog> cateList = cateService.getAll();
        theModel.addAttribute("catelist", cateList);
        List<Product> productList = productService.getProductById(Integer.parseInt(id));
        theModel.addAttribute("productlist", productList);
        //Giá giảm
        List<Product> productsList1 = new ArrayList<Product>();
        for (Product product : productList) {
            Product product1 = productService.get((product.getId()));
            product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(String.valueOf(product.getDiscount())) / 100)))));

            productsList1.add(product1);

        }

        theModel.addAttribute("productlist1", productsList1);

        // Product bán chạy
        List<Product> product_banchay = productService.getProductById(6);
        theModel.addAttribute("product_banchay", product_banchay);

        return "product";
    }

}
