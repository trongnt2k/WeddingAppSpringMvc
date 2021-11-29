/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.service.CommentService;
import com.mycompany.service.WeddingService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
public class WeddingController {
    @Autowired
    private WeddingService weddingService;
    @Autowired
    private CommentService commentService; 
    
    @RequestMapping("/wedding")
    public String wedding(Model model, 
            @RequestParam(required = false) Map <String, String> params) throws ParseException{
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String startDate = params.getOrDefault("startDate", "");
        String endDate = params.getOrDefault("endDate", "");
        String priceSort = params.getOrDefault("price", "");
     
        model.addAttribute("wedding", this.weddingService.getWedding(page, startDate, endDate, priceSort));
        model.addAttribute("count", this.weddingService.countWedding());
        
        return "wedding";
    }
    
    @GetMapping("/wedding/{weddingId}")
    public String detail(Model model,
            @PathVariable(value = "weddingId") int weddingId,
            @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("wedding", this.weddingService.getWeddingById(weddingId));
        model.addAttribute("comments", this.commentService.getCommentsByWeddingId(weddingId, page));
        model.addAttribute("commentCounter", this.commentService.countComment(weddingId));
        
        return "wedding-detail";
    }
    
    @GetMapping("/wedding/weddingrent/{weddingId}")
    public String weddingRent(Model model,
            @PathVariable(value = "weddingId") int weddingId){
        model.addAttribute("wedding", this.weddingService.getWeddingById(weddingId));
        return "wedding-rent";
    }
}
