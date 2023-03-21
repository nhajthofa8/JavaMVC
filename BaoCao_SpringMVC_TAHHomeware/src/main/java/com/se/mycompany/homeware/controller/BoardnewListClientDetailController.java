package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Boardnew;
import com.se.mycompany.homeware.service.BoardnewService;
import com.se.mycompany.homeware.serviceImpl.BoardnewServicesImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view/client")
public class BoardnewListClientDetailController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    BoardnewService boardnewService = new BoardnewServicesImpl();

    @GetMapping("/news-list-detail")
    public String BoardnewListDetails(@RequestParam("id") String id, Model theModel) {
        Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
        theModel.addAttribute("boardnew", boardnew);

        List<Boardnew> boardnewList = boardnewService.getAll();
        theModel.addAttribute("boardnewlist", boardnewList);

        return "blog-single";
    }

}
