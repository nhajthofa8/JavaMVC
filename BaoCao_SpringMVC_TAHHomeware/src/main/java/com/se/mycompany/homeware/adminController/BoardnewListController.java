package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.Boardnew;
import com.se.mycompany.homeware.service.BoardnewService;
import com.se.mycompany.homeware.serviceImpl.BoardnewServicesImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class CategoryListController
 */
@Controller
@RequestMapping("/admin/new")
public class BoardnewListController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    BoardnewService newService = new BoardnewServicesImpl();

    @GetMapping("/list")
    public String listBoardnews(Model theModel) {
        List<Boardnew> boardnewList = newService.getAll();
        theModel.addAttribute("boardnewlist", boardnewList);
        return "show-new";
    }
}
