package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Item;
import com.se.mycompany.homeware.model.Order;
import com.se.mycompany.homeware.model.Product;
import com.se.mycompany.homeware.service.ProductService;
import com.se.mycompany.homeware.serviceImpl.ProductServiceImpl;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Servlet implementation class AddtoCartController
 */

@Controller
@RequestMapping("/view/client")
public class AddtoCartController {
	private static final long serialVersionUID = 1L;
        @Autowired
	ProductService productService = new ProductServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");
	
        @GetMapping("/add-cart")
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n= 0;
		int qty = 1;
		String id;
		if(request.getParameter("product-id")!=null) {
			id = request.getParameter("product-id");
			Product product = productService.get(Integer.parseInt(id));;
			if(product != null) {
				if(request.getParameter("qty")!=null) {
					qty = Integer.parseInt(request.getParameter("qty"));
				}
				
				HttpSession session = request.getSession();
				if(session.getAttribute("order") == null) {
					Order order = new Order();
					List<Item> listItems = new ArrayList<Item>();
					Item item = new Item();
					item.setQty(qty);
					item.setProduct(product);
					item.setPrice(Double.parseDouble(product.getPrice()) - Double.parseDouble(product.getPrice())*(product.getDiscount()/100));
					order.setSumPrice(0);
					order.setSumPrice(order.getSumPrice() + item.getPrice());
					listItems.add(item);
					order.setItems(listItems);
					n = listItems.size();
					session.setAttribute("length_order",n);
					session.setAttribute("order", order);
					session.setAttribute("sumprice", df.format(order.getSumPrice()));
				} else {
					Order order = (Order) session.getAttribute("order");
					List<Item> listItems = order.getItems();
					boolean check = false;
					for(Item item : listItems) {
						if(item.getProduct().getId() == (product.getId())) {
							item.setQty(item.getQty() + qty);
							order.setSumPrice(order.getSumPrice() + Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(item.getProduct().getDiscount()/100));
							item.setPrice(item.getPrice() + (Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(item.getProduct().getDiscount()/100)));
							check = true;
						}
					}
					if(check == false) {
						Item item = new Item();
						item.setQty(qty);
						item.setProduct(product);
						item.setPrice(Double.parseDouble(product.getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(item.getProduct().getDiscount()/100));
						order.setSumPrice(order.getSumPrice() + Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(item.getProduct().getDiscount()/100));
						listItems.add(item);
					}
					n = listItems.size();
					session.setAttribute("length_order",n);
					session.setAttribute("order", order);
					session.setAttribute("sumprice", df.format(order.getSumPrice()));
				}
			}
//			response.sendRedirect(request.getContextPath() + "/view/client/product");
                        return "redirect:/view/client/product";
		} else {
//			response.sendRedirect(request.getContextPath() + "/");
                        return "redirect:/";
		}
		
	}

}
