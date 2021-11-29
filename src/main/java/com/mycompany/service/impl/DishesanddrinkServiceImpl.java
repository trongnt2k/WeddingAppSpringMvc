/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.repository.DishesanddrinkRepository;
import com.mycompany.service.DishesanddrinkService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.pojos.Dishesanddrink;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DishesanddrinkServiceImpl implements DishesanddrinkService{
    @Autowired
    private DishesanddrinkRepository dishesanddrinkRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<com.mycompany.pojos.Dishesanddrink> getDishesanddrink(String kw) {
         return this.dishesanddrinkRepository.getDishesanddrink(kw);
    }

    @Override
    public boolean addOrUpdate(Dishesanddrink dishesanddrink) {
        try {
            Map r = this.cloudinary.uploader().upload(dishesanddrink.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            dishesanddrink.setDishesDrinkImages((String) r.get("secure_url"));
            
            return this.dishesanddrinkRepository.addOrUpdate(dishesanddrink);          
            } catch (IOException ex) {
                System.err.println("== ADD DISHESANDDRINK ==" + ex.getMessage());
            }
        
            return false;
        }
}
