package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.service.TransactionService;
import com.se.mycompany.homeware.serviceImpl.TransactionServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/order")
public class OrderDeleteController {

    private static final long serialVersionUID = 1L;

    @Autowired
    TransactionService transactionService = new TransactionServicesImpl();

    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("id") String id) {
        transactionService.delete(id);
        return "redirect:/admin/order/list";
    }
}
