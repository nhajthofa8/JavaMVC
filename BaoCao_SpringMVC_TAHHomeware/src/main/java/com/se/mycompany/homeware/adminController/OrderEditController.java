package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.model.Transactions;
import com.se.mycompany.homeware.service.TransactionService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.se.mycompany.homeware.serviceImpl.TransactionServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/order")
public class OrderEditController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    TransactionService transactionService = new TransactionServicesImpl();

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("id") String id, Model theModel) {

        Transactions transaction = transactionService.get(Integer.parseInt(id));
        theModel.addAttribute("order", transaction);
        return "editorder";
    }

    @PostMapping("/edit")
    public String editOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Transactions transactions = new Transactions();
        transactions.setId(Integer.parseInt(req.getParameter("order-id")));
        transactions.setUser_name(req.getParameter("order-name"));
        transactions.setUser_mail(req.getParameter("order-mail"));
        transactions.setUser_phone(req.getParameter("order-phone"));
        transactions.setAddress(req.getParameter("order-address"));
        transactions.setMessage(req.getParameter("order-mess"));
        transactions.setAmount(req.getParameter("order-amount"));
        transactions.setPayment(req.getParameter("order-payment"));
        transactions.setStatus(req.getParameter("order-status"));
        transactionService.edit(transactions);
        return "redirect:/admin/order/list";

    }
}
