/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/wedding-stats")
    public String weddingStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        
        String fromDate = params.getOrDefault("fromDate", "");
        String toDate = params.getOrDefault("toDate", "");
        
        model.addAttribute("weddingStats", this.statsService.weddingStats(fromDate, toDate));
        
        return "wedding-stats";
    }
    
    @GetMapping("/wedding-year-stats")
    public String weddingYearStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        
        String fromDate = params.getOrDefault("fromDate", "");
        String toDate = params.getOrDefault("toDate", "");
        
        model.addAttribute("weddingYearStats", this.statsService.weddingYearStats(fromDate, toDate));
        
        return "wedding-year-stats";
    }
    
    @GetMapping("/wedding-revenue-stats")
    public String weddingRevenueStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        
        String fromDate = params.getOrDefault("fromDate", "");
        String toDate = params.getOrDefault("toDate", "");
        
        model.addAttribute("weddingRevenueStats", this.statsService.weddingRevenueStats(fromDate, toDate));
        
        return "wedding-revenue-stats";
    }
    
    @GetMapping("/wedding-revenue-year-stats")
    public String weddingRevenueYearStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        
        String fromDate = params.getOrDefault("fromDate", "");
        String toDate = params.getOrDefault("toDate", "");
        
        model.addAttribute("weddingRevenueYearStats", this.statsService.weddingRevenueYearStats(fromDate, toDate));
        
        return "wedding-revenue-year-stats";
    }
    
}
