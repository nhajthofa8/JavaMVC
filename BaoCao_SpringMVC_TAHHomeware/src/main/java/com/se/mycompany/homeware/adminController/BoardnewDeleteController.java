package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.service.BoardnewService;
import com.se.mycompany.homeware.serviceImpl.BoardnewServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/new")
public class BoardnewDeleteController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    BoardnewService boardnewService = new BoardnewServicesImpl();

    @GetMapping("/delete")
    public String deleteBoardnew(@RequestParam("id") String id) {
        boardnewService.delete(Integer.parseInt(id));
        return "redirect:/admin/new/list";
    }

}
