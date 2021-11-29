/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojos.WeddingHall;
import com.mycompany.service.WeddingHallService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
public class WeddingHallController {
    @Autowired
    private WeddingHallService weddingHallService;
    
    @RequestMapping("/weddinghall")
    public String weddinghall(Model model, 
            @RequestParam(required = false) Map <String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String priceSort = params.getOrDefault("price", "");
        String weddingTime = params.getOrDefault("time", "");
        
        model.addAttribute("weddinghall", this.weddingHallService.getWeddingHalls(params.get("kw"), page, priceSort, weddingTime));
        model.addAttribute("count", this.weddingHallService.countWeddingHall());
        
        return "weddinghall";
    }
    
    @GetMapping("/admin/weddinghall")
    public String list(Model model){
        model.addAttribute("weddinghall", new WeddingHall());
        return "weddinghalladmin";
    }
    
    @PostMapping("/admin/weddinghall")
    public String add(Model model, @ModelAttribute(value="weddinghall") @Valid WeddingHall weddinghall, BindingResult result){
        if(!result.hasErrors()){
            if (this.weddingHallService.addOrUpdate(weddinghall) == true)
                return "redirect:/weddinghall";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        return "weddinghalladmin";
    }
    
    @GetMapping("/weddinghall/{weddinghallId}")
    public String detail(Model model, @PathVariable(value = "weddinghallId") int weddinghallId){
        model.addAttribute("weddinghall", this.weddingHallService.getWeddingHallById(weddinghallId));
        
        return "weddinghall-detail";
    }
}
