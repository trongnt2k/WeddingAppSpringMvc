/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import com.mycompany.pojos.Cart;
import java.util.List;

/**
 *
 * @author User
 */
public class Utils {
    public static int countCart(List<Cart> cart){
        int c = 0;
        if(cart != null)
            for(int i=0; i<cart.size(); i++){
                c += cart.get(i).getCount();
            }
        
        return c;
    }
    
    public static Long sumAmount(List<Cart> cart) {
        Long s = 0l;
        
        if(cart != null)
            for(int i=0; i<cart.size(); i++){
                s += cart.get(i).getCount() * cart.get(i).getPrice().intValue();
            }
        
        return s;
    }
    
    public static Long sumAmountWithNumberDesk(List<Cart> cart, int numberDesk) {
        Long s = 0l;
        
        if(cart != null)
            for(int i=0; i<cart.size(); i++){
                if(cart.get(i).getMenuName() == "")
                    s += cart.get(i).getCount() * cart.get(i).getPrice().intValue();
                if(cart.get(i).getMenuName() != "")
                    s += cart.get(i).getCount() * cart.get(i).getPrice().intValue() * numberDesk;
            }
        
        return s;
    }
    
}
