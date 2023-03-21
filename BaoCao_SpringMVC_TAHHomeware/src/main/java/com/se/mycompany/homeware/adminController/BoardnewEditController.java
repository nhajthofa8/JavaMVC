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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/new")
public class BoardnewEditController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    BoardnewService boardnewService = new BoardnewServicesImpl();

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("id") String id, Model theModel) {
        Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
        theModel.addAttribute("boardnew", boardnew);
        return "editboardnew";
    }

    @PostMapping("/edit")
    public String editBoardnew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Boardnew boardnew = new Boardnew();
        boardnew.setId(Integer.parseInt(req.getParameter("new-id")));
        boardnew.setTitle(req.getParameter("new-title"));
        boardnew.setContent(req.getParameter("new-content"));
        boardnew.setImage_link(req.getParameter("new-image_link"));
        boardnew.setAuthor(req.getParameter("new-author"));
        boardnew.setCreated(Date.valueOf(req.getParameter("new-created")));
        boardnewService.edit(boardnew);

        return "redirect:/admin/new/list";

    }

}
