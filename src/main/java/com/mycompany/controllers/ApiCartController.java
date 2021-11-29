/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.cloudinary.Util;
import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Service;
import com.mycompany.pojos.User;
import com.mycompany.pojos.Wedding;
import com.mycompany.pojos.WeddingHall;
import com.mycompany.service.ServiceService;
import com.mycompany.service.WeddingHallService;
import com.mycompany.service.WeddingService;
import com.mycompany.utils.Utils;
import java.math.BigDecimal;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class ApiCartController {
    @Autowired
    private WeddingService weddingService;
    @Autowired
    private ServiceService serviceService;
    
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart c, HttpSession session){
        boolean weddinghall = false;
        boolean menu = false;
        boolean service = false;
        int check=0;
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<>();
        
        if(c.getWeddingHallName() != ""){
            for(int i=0; i<cart.size(); i++){
                if(cart.get(i).getWeddingHallName() != ""){
                    cart.set(i, c);
                    weddinghall = true;
                    check = -1;
                    break;
                }
            }

            if(weddinghall == false){
                cart.add(c);
            }
        }
        
        if(c.getMenuName() != ""){
            for(int i=0; i<cart.size(); i++){
                if(cart.get(i).getMenuName() != ""){
                    cart.set(i, c);
                    menu = true;
                    check = -1;
                    break;
                }
            }

            if(menu == false){
                cart.add(c);
            }
        }
        
        if(c.getServiceName() != ""){
            for(int i=0; i<cart.size(); i++){
                if(cart.get(i).getServiceId() == c.getServiceId()){
                    check = -2;
                    service = true;
                    break;
                }
            }

            if(service == false){
                cart.add(c);
            }
        }
        
        session.setAttribute("cart", cart);
        if(check != 0)
            return check;
        return Utils.countCart(cart);
    }
    
    @PostMapping("/api/cart/numberDesk")
    public long numberDesk(@RequestBody Map<String, String> params, HttpSession session){
        int numberDesk = Integer.parseInt(params.getOrDefault("numberDesk", "1"));
        session.setAttribute("numberDesk", numberDesk);
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
       
        return Utils.sumAmountWithNumberDesk(cart, numberDesk);
    }
    
    @DeleteMapping("/api/cart/weddinghall/{weddingHallId}")
    public int deleteWeddinghallItem(@PathVariable(value = "weddingHallId") int weddingHallId, HttpSession session) {
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        for(int i=0; i<cart.size(); i++){
            if(cart.get(i).getWeddingHallId() == weddingHallId)
               cart.remove(i);
        }
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
    
    @DeleteMapping("/api/cart/service/{serviceId}")
    public int deleteServiceItem(@PathVariable(value = "serviceId") int serviceId, HttpSession session) {
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        for(int i=0; i<cart.size(); i++){
            if(cart.get(i).getServiceId()== serviceId)
               cart.remove(i);
        }
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
    
    @DeleteMapping("/api/cart/menu/{menuId}")
    public int deleteMenuItem(@PathVariable(value = "menuId") int menuId, HttpSession session) {
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        for(int i=0; i<cart.size(); i++){
            if(cart.get(i).getMenuId()== menuId)
               cart.remove(i);
        }
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
    
    @PostMapping("/api/pay")
    public HttpStatus pay(@RequestBody Map<String, String> params,HttpSession session){
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        int weddinghallId = 0;
        int menuId = 0;
        int numberDesk = 1;
        BigDecimal totalPrice = new BigDecimal(0);
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
        {
            if(session.getAttribute("numberDesk") != null ){
                numberDesk = (int) session.getAttribute("numberDesk");
                totalPrice = new BigDecimal(Utils.sumAmountWithNumberDesk(cart, numberDesk));
            }
            if(session.getAttribute("numberDesk") == null)
                totalPrice = new BigDecimal(Utils.sumAmount(cart));
            List<Service> services = new ArrayList<>();
            try{
                String organizeDate = params.getOrDefault("organizeDate", "");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(organizeDate);  
                String description = params.getOrDefault("description", "");
                for(int i=0; i<cart.size(); i++){
                    if(cart.get(i).getWeddingHallName() != "")
                        weddinghallId = cart.get(i).getWeddingHallId();
                    if(cart.get(i).getMenuName()!= "")
                        menuId = cart.get(i).getMenuId();
                    if(cart.get(i).getServiceName() != "")
                        services.add(this.serviceService.getServiceById(cart.get(i).getServiceId()));
                }
                if(this.weddingService.addWedding(weddinghallId, menuId, services, numberDesk, date, description, totalPrice, u) == true){
                    session.removeAttribute("cart");
                    return HttpStatus.OK;
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return HttpStatus.BAD_REQUEST;
    }
}
