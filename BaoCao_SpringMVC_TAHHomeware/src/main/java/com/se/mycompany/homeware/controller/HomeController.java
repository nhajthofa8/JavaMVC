package com.se.mycompany.homeware.controller;
import com.se.mycompany.homeware.daoImpl.BoardnewDaoImpl;
import com.se.mycompany.homeware.model.Boardnew;
import com.se.mycompany.homeware.model.Product;
import com.se.mycompany.homeware.service.BoardnewService;
import com.se.mycompany.homeware.service.ProductService;
import com.se.mycompany.homeware.serviceImpl.BoardnewServicesImpl;
import com.se.mycompany.homeware.serviceImpl.ProductServiceImpl;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping()
    public class HomeController{
        
	private static final long serialVersionUID = 1L;
        @Autowired
	ProductService productService = new ProductServiceImpl();
        @Autowired
	BoardnewService boardnewService = new BoardnewServicesImpl();
	DecimalFormat df = new DecimalFormat("###.000");
        @GetMapping()
	public String Home(Model theModel){
            System.err.println("OK");
		List<Boardnew> boardnewList = boardnewService.getAll();
		theModel.addAttribute("boardnewlist", boardnewList);
		// Product Rau củ quả
		List<Product> product_raucu= productService.getProductById(1);
		theModel.addAttribute("product_raucu", product_raucu);	
		
		// Product hạt
		List<Product> product_hat= productService.getProductById(2);
		theModel.addAttribute("product_hat", product_hat);	
		
		// Product trái cây
		List<Product> product_traicay= productService.getProductById(3);
		theModel.addAttribute("product_traicay", product_traicay);	
		
		// Product mật ong
		List<Product> product_matong= productService.getProductById(4);
		theModel.addAttribute("product_matong", product_matong);	
		
		// Product mới
		List<Product> product_new= productService.getProductById(5);
		theModel.addAttribute("product_new", product_new);	
				
		// Product bán chạy
		List<Product> product_banchay= productService.getProductById(6);
		theModel.addAttribute("product_banchay", product_banchay);	
		
		List<Product> productList = productService.getAll();
		theModel.addAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(product.getId());
//                        double giaGiam = Double.parseDouble(product.getPrice().replace(".000", "")) * (1 - (product.getDiscount()));
//                        System.err.println(giaGiam);
//			product1.setPrice(df.format(giaGiam+".000"));
                        product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(String.valueOf(product.getDiscount()))/100)))));
			productsList1.add(product1);
			
		}

		theModel.addAttribute("productlist1", productsList1);
		
		// Product giảm giá
		List<Product> product_sale= productService.getProductById(7);
		theModel.addAttribute("product_sale", product_sale);	
		
		return "index";
	}
}
