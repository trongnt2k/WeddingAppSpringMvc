/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojos.Cart;
import com.mycompany.service.WeddingHallService;
import com.mycompany.utils.Utils;
import java.util.List;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@ControllerAdvice
@Controller
public class HomeController {
    //@Autowired
    //private WeddingHallService weddingHallService;
    
    @RequestMapping("/")
    public String weddinghall(Model model){//@RequestParam(value = "kw", required = false, defaultValue = "") String kw){
        //model.addAttribute("weddinghall", this.weddingHallService.getWeddingHalls(kw));
        
        return "index";
    }
    
    @ModelAttribute
    public void cartCounter(Model model, HttpSession session){
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        int count = 0;
        if(cart != null)
            for(int i=0; i<cart.size(); i++){
                count += cart.get(i).getCount();
            }
        
        model.addAttribute("counter", count);
    }
    
    @ModelAttribute
    public void currentUser(Model model, HttpSession session){
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
}
