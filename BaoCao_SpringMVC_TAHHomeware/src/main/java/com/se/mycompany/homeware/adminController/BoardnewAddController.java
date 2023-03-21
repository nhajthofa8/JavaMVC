package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.Boardnew;
import com.se.mycompany.homeware.service.BoardnewService;
import com.se.mycompany.homeware.serviceImpl.BoardnewServicesImpl;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/new")
public class BoardnewAddController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Autowired
	BoardnewService boardnewService = new BoardnewServicesImpl();

	@GetMapping("/add")
	public String showFormAdd(){
                return "addboardnew";
	}

	@PostMapping("/add")
	public String addBoardnew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String new_title = req.getParameter("new-title");
		String new_content = req.getParameter("new-content");
		String new_image_link = req.getParameter("new-image_link");
		String new_author = req.getParameter("new-author");
		String new_created = req.getParameter("new-created");
		Boardnew boardnew = new Boardnew();
		boardnew.setTitle(new_title);
		boardnew.setContent(new_content);
		boardnew.setImage_link(new_image_link);
		boardnew.setAuthor(new_author);
		boardnew.setCreated(Date.valueOf(new_created));
		boardnewService.insert(boardnew);
                return "redirect:/admin/new/list";
	}

}
