/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojos.WeddingHall;
import java.util.List;

/**
 *
 * @author User
 */
public interface WeddingHallRepository {
    List<WeddingHall> getWeddingHalls(String kw, int page, String priceSort, String weddingTime);
    WeddingHall getWeddingHallById(int weddingHallId);
    long countWeddingHall();
    boolean addOrUpdate(WeddingHall weddinghall);
}
