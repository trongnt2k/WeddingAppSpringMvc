/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojos.WeddingHall;
import java.util.List;

/**
 *
 * @author User
 */
public interface WeddingHallService {
    List <WeddingHall> getWeddingHalls(String kw, int page, String priceSort, String weddingTime);
    boolean addOrUpdate(WeddingHall weddinghall);
    long countWeddingHall();
    WeddingHall getWeddingHallById(int weddingHallId);
}
