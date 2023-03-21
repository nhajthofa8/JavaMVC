package com.se.mycompany.homeware.adminController;

import com.se.mycompany.homeware.service.ReviewService;
import com.se.mycompany.homeware.serviceImpl.ReviewServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/review")
public class ReviewDeleteController {

    private static final long serialVersionUID = 1L;

    @Autowired
    ReviewService reviewService = new ReviewServicesImpl();

    @GetMapping("/delete")
    public String deleteReview(@RequestParam("id") String id) {
        reviewService.delete(Integer.parseInt(id));
        return "redirect:/admin/review/list";
    }

}
