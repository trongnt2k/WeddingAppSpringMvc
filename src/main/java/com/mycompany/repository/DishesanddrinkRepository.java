/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojos.Dishesanddrink;
import java.util.List;

/**
 *
 * @author User
 */
public interface DishesanddrinkRepository {
    List <Dishesanddrink> getDishesanddrink(String kw);
    boolean addOrUpdate(Dishesanddrink dishesanddrink);
}
