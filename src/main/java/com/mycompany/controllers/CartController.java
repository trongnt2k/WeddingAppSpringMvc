/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.pojos.Cart;
import com.mycompany.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author User
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        List<Cart> service = new ArrayList<>();
        if(cart != null){
            for(int i=0; i<cart.size(); i++)
            {
                if(cart.get(i).getWeddingHallName() != "")
                    model.addAttribute("weddinghall", cart.get(i));
                if(cart.get(i).getMenuName() != "")
                    model.addAttribute("menu", cart.get(i));
                if(cart.get(i).getServiceName() != "")
                    service.add(cart.get(i));
            }
            model.addAttribute("service", service);
        }
        else
            model.addAttribute("carts", null);
            model.addAttribute("amount", Utils.sumAmount(cart));
            
        return "cart";
    }
}
