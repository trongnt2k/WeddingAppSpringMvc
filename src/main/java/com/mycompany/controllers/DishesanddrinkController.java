/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojos.Dishesanddrink;
import com.mycompany.service.DishesanddrinkService;
import com.mycompany.service.MenuService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author User
 */
@Controller
public class DishesanddrinkController {
    @Autowired
    private DishesanddrinkService dishesanddrinkService;
    @Autowired
    private MenuService menuService;
    
    @GetMapping("/admin/dishesanddrink")
    public String list(Model model){
        model.addAttribute("dishesanddrink", new Dishesanddrink());
        model.addAttribute("menu", this.menuService.getMenus());
        return "dishesanddrinkadmin";
    }
    
    @PostMapping("/admin/dishesanddrink")
    public String add(Model model, @ModelAttribute(value="dishesanddrink") @Valid Dishesanddrink dishesanddrink, BindingResult result){
        if(!result.hasErrors()){
            if (this.dishesanddrinkService.addOrUpdate(dishesanddrink) == true)
                return "redirect:/dishesanddrink";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        return "dishesanddrinkadmin";
    }
}
