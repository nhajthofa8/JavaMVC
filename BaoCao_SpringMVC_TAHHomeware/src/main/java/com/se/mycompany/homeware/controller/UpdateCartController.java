package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Item;
import com.se.mycompany.homeware.model.Order;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/client")
public class UpdateCartController {

	private static final long serialVersionUID = 1L;
	DecimalFormat df = new DecimalFormat("#.000");
	
	@GetMapping("/cart-update")
	public String upDateCart(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
                return "cart";
	}
	@PostMapping("/cart-update")
	public String PostUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		order.setSumPrice(0);
		for(Item item: listItems)
		{
			item.setQty(Integer.parseInt(req.getParameter(String.valueOf(item.getProduct().getId()))));
			item.setPrice(Integer.parseInt(req.getParameter(String.valueOf(item.getProduct().getId())))*(Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(item.getProduct().getDiscount()/100)));
			order.setSumPrice(order.getSumPrice() + item.getPrice());
		}
		order.setItems(listItems);
		session.setAttribute("order", order);
		session.setAttribute("sumprice", df.format(order.getSumPrice()));
                return "redirect:/view/client/cart";
	}
}
