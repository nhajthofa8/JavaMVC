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
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Servlet implementation class ProductEditController
 */

@Controller
@RequestMapping("/admin/product")
public class ProductEditController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Autowired
	ProductService productService = new ProductServiceImpl();

        @Autowired
        CategoryService cateService = new CategoryServicesImpl();
	@GetMapping("/edit")
	public String showFormEdit(@RequestParam("id") String id, Model theModel){
		
		List<Catalog> cateList = cateService.getAll();
		theModel.addAttribute("catelist", cateList);
		
		Product product = productService.get(Integer.parseInt(id));
		theModel.addAttribute("product", product);

                return "editproduct";
	}

	@PostMapping("/edit")
	public String editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		Product product = new Product();
		product.setId(Integer.parseInt(req.getParameter("product-sku")));
		product.setCatalog_id(Integer.parseInt(req.getParameter("product-cate")));
		product.setName(req.getParameter("product-name"));
		product.setPrice(req.getParameter("product-price"));
		product.setStatus(Integer.parseInt(req.getParameter("product-status")));
		product.setDescription(req.getParameter("product-desc"));
		product.setContent(req.getParameter("product-content"));
		product.setDiscount(Integer.parseInt(req.getParameter("product-discount")));
		product.setImage_link(req.getParameter("product-image"));
		product.setCreated(Date.valueOf(req.getParameter("product-day")));
		productService.edit(product);

                return "redirect:/admin/product/list";

	}
}