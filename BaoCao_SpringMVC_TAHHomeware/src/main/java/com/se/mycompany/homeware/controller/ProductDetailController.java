package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Product;
import com.se.mycompany.homeware.service.CategoryService;
import com.se.mycompany.homeware.service.ProductService;
import com.se.mycompany.homeware.service.ReviewService;
import com.se.mycompany.homeware.serviceImpl.CategoryServicesImpl;
import com.se.mycompany.homeware.serviceImpl.ProductServiceImpl;
import com.se.mycompany.homeware.serviceImpl.ReviewServicesImpl;
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
public class ProductDetailController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
        
        @Autowired
	ProductService productService = new ProductServiceImpl();
	ReviewService reviewService = new ReviewServicesImpl();
	DecimalFormat df = new DecimalFormat("#.000");
	@GetMapping("/product-detail")
	public String productDetails(@RequestParam("id") String id, Model theModel){
		Product detail_product = productService.get(Integer.parseInt(id));
		theModel.addAttribute("detail_product", detail_product);
		
//		List<Catalog> name_cate_of_product = cateService.getCateByProduct(Integer.parseInt(id));
//		theModel.addAttribute("name_cate_of_product", name_cate_of_product);
		
		int idCate = detail_product.getCatalog_id();
		
		List<Product> productListCate = productService.getProductById(idCate);
		
		theModel.addAttribute("productById", productListCate);
		
//		List<Review> reviewById = reviewService.getReviewById(Integer.parseInt(id));
//		theModel.addAttribute("reviewbyid", reviewById);
		
		List<Product> productList = productService.getAll();
		theModel.addAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(product.getId());
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(String.valueOf(product.getDiscount()))/100)))));
			productsList1.add(product1);
			
		}

		theModel.addAttribute("productlist1", productsList1);
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product-detail.jsp");
//		dispatcher.forward(req, resp);
                return "product-detail";
	}

}
