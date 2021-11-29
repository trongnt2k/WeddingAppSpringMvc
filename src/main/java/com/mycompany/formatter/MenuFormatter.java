/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formatter;

import com.mycompany.pojos.Menu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author User
 */
public class MenuFormatter implements Formatter<Menu>{

    @Override
    public String print(Menu t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Menu parse(String menuId, Locale locale) throws ParseException {
        Menu m = new Menu();
        m.setId(Integer.parseInt(menuId));
        
        return m;
    }
    
}
