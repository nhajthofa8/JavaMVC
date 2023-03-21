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
@RequestMapping("/view/client/product")
public class ProductSeachByNameController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Autowired
	CategoryService cateService = new CategoryServicesImpl();
        @Autowired
	ProductService productService=new ProductServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");
        @GetMapping("/search")
	public String SearchByName(@RequestParam("s") String name1 , Model theModel){
		String name= name1;
                System.err.println(name);
		List<Catalog> cateList = cateService.getAll();
		theModel.addAttribute("catelist", cateList);
		
		List<Product> productSeachByName = productService.searchByName(name);
		theModel.addAttribute("productlist", productSeachByName);
	
		List<Product> productAllList = productService.getAll();
		theModel.addAttribute("product_all", productAllList);
		
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productSeachByName)
		{
			Product product1 = productService.get(product.getId());
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (product.getDiscount()/100)))));
			productsList1.add(product1);
			
		}

		theModel.addAttribute("productlist1", productsList1);
		// Product bán chạy
		List<Product> product_banchay= productService.getProductById(6);
		theModel.addAttribute("product_banchay", product_banchay);	
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product-search.jsp");
//		dispatcher.forward(req, resp);
                return "product-search";

	}
}
