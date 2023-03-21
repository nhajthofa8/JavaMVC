package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Review;
import com.se.mycompany.homeware.service.ReviewService;
import com.se.mycompany.homeware.serviceImpl.ReviewServicesImpl;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/client")
public class ReviewClientController {
	private static final long serialVersionUID = 1L;
	ReviewService reviewService = new ReviewServicesImpl();
	@GetMapping("/review")
	public String getReview(Model theModel){
                return "redirect:/view/client/product-detail?id=" +theModel.getAttribute("id");
	}
        
	@PostMapping("/review")
	public String postReview(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("thử: " + id);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String content = req.getParameter("content");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Date.valueOf(df.format(date));
		Review review = new Review();
		review.setName(name);
		review.setEmail(email);
		review.setProduct_id(id);
		review.setContent(content);
		review.setCreated(today);
		System.out.println("thử tostring: " + review);
		reviewService.insert(review);
                return "/view/client/product-detail?id=" + id;
	}
}
