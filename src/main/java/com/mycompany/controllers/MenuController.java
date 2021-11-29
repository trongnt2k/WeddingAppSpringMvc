/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojos.Dishesanddrink;
import com.mycompany.pojos.Menu;
import com.mycompany.service.DishesanddrinkService;
import com.mycompany.service.MenuService;
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
public class MenuController {
    @Autowired
    public MenuService menuService;
    @Autowired
    private DishesanddrinkService dishesanddrinkService;
     
    @RequestMapping("/menu")
    public String menu(Model model, 
            @RequestParam(required = false) Map <String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("count", this.menuService.countMenu());
        model.addAttribute("menu", this.menuService.getMenus(params.get("kw"), page));
        
        return "menu";
    }
    @GetMapping("/admin/menu")
    public String list(Model model){
        model.addAttribute("menu", new Menu());
        model.addAttribute("dishesanddrink", this.dishesanddrinkService.getDishesanddrink(""));
        return "menuadmin";
    }
    
    @PostMapping("/admin/menu")
    public String add(Model model, @ModelAttribute(value="menu") @Valid Menu menu, BindingResult result){
        if(!result.hasErrors()){
            if (this.menuService.addOrUpdate(menu) == true)
                return "redirect:/menu";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        return "menuadmin";
    }
    
    @GetMapping("/menu/{menuId}")
    public String detail(Model model, @PathVariable(value = "menuId") int menuId){
        model.addAttribute("menu", this.menuService.getMenuById(menuId));
        
        return "menu-detail";
    }
}
