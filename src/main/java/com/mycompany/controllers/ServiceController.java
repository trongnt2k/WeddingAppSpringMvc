/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojos.Service;
import com.mycompany.service.ServiceService;
import java.io.IOException;
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
public class ServiceController {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ServiceService serviceService;
    
    @RequestMapping("/service")
    public String service(Model model, 
            @RequestParam(required = false) Map <String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String priceSort = params.getOrDefault("price", "");
        
        model.addAttribute("count", this.serviceService.countService());
        model.addAttribute("service", this.serviceService.getServices(params.get("kw"), page, priceSort));
        
        return "service";
    }
    
    @GetMapping("/admin/service")
    public String list(Model model){
        model.addAttribute("service", new Service());
        return "serviceadmin";
    }
    
    @PostMapping("/admin/service")
    public String add(Model model, @ModelAttribute(value="service") @Valid Service service, BindingResult result){
        if(!result.hasErrors()){
            if (this.serviceService.addOrUpdate(service) == true)
                return "redirect:/service";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        return "serviceadmin";
    }
    
    @GetMapping("/service/{serviceId}")
    public String detail(Model model, @PathVariable(value = "serviceId") int serviceId){
        model.addAttribute("service", this.serviceService.getServiceById(serviceId));
        
        return "service-detail";
    }
}
