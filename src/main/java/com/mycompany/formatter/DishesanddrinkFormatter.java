/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formatter;

import com.mycompany.pojos.Dishesanddrink;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author User
 */
public class DishesanddrinkFormatter implements Formatter<Dishesanddrink>{

    @Override
    public String print(Dishesanddrink t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Dishesanddrink parse(String DishesanddrinkId, Locale locale) throws ParseException {
        Dishesanddrink d = new Dishesanddrink();
        d.setId(Integer.parseInt(DishesanddrinkId));
        
        return d;
    }
    
}
