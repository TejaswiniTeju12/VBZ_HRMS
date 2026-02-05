package com.vbz.hrms.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vbz.hrms.dto.PaySlipResponseDTO;
import com.vbz.hrms.service.PayslipServiceImpl;
import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/payslip")
public class PaySlipController {

    private final PayslipServiceImpl service;

    public PaySlipController(PayslipServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/my")
    public PaySlipResponseDTO myPayslip(
            @RequestParam Integer month,
            @RequestParam Integer year,
            HttpSession session) {

        Long userId = (Long) session.getAttribute("LOGGED_IN_USER_ID");
       
        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        return service.getPayslip(userId, month, year);
   
    }

}
  