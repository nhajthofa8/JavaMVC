package com.se.mycompany.homeware.controller;

import com.se.mycompany.homeware.model.Item;
import com.se.mycompany.homeware.model.Order;
import com.se.mycompany.homeware.model.Ordered;
import com.se.mycompany.homeware.model.Transactions;
import com.se.mycompany.homeware.service.OrderedService;
import com.se.mycompany.homeware.service.TransactionService;
import com.se.mycompany.homeware.serviceImpl.OrderedServiceImpl;
import com.se.mycompany.homeware.serviceImpl.TransactionServicesImpl;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class TransactionController
 */
@Controller
@RequestMapping("/view/client")
public class TransactionController {

    private static final long serialVersionUID = 1L;

    @Autowired
    TransactionService transactionService = new TransactionServicesImpl();
    @Autowired
    OrderedService orderedService = new OrderedServiceImpl();

    @GetMapping("/transaction")
    public String getTransaction() {
        return "checkout";
    }

    @PostMapping("/transaction")
    public String postTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String tr_usersession = req.getParameter("transaction_usersession");
        String tr_username = req.getParameter("transaction_name");
        String tr_usermail = req.getParameter("transaction_email");
        String tr_userphone = req.getParameter("transaction_phone");
        String tr_useraddress = req.getParameter("transaction_address");
        String tr_usermess = req.getParameter("transaction_mess");
        String tr_amount = req.getParameter("transaction_amount");
        String tr_payment = req.getParameter("transaction_payment");
        Date tr_created = Date.valueOf(req.getParameter("transaction_created"));

        Transactions transaction = new Transactions();
        transaction.setUser_session(tr_usersession);
        transaction.setUser_name(tr_username);
        transaction.setUser_mail(tr_usermail);
        transaction.setUser_phone(tr_userphone);
        transaction.setAddress(tr_useraddress);
        transaction.setMessage(tr_usermess);
        transaction.setAmount(tr_amount);
        transaction.setPayment(tr_payment);
        transaction.setCreated(tr_created);

        transactionService.insert(transaction);

        int maxid = 0;
        List<Transactions> transactions = transactionService.getAll();
        if (transactions.size() == 0) {
            maxid = 0;
        } else {
            for (Transactions transactions2 : transactions) {
                if (transactions2.getId() >= maxid) {
                    maxid = transactions2.getId();
                }
            }
        }
        HttpSession session = req.getSession(true);
        Order order = (Order) session.getAttribute("order");
        List<Item> listItems = order.getItems();
        for (Item item : listItems) {
            Ordered ordered = new Ordered();
            ordered.setProduct_id((item.getProduct().getId()));
            ordered.setQty(item.getQty());
            ordered.setTransaction_id(maxid);
            orderedService.insert(ordered);
        }
        if (session != null) {
            session.removeAttribute("order"); //remove session
            session.removeAttribute("sumprice"); //remove session
            session.removeAttribute("length_order"); //remove session
        }
        return "redirect:/view/client/checkout";

    }

}
