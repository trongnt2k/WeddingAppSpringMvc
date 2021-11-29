/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Service;
import com.mycompany.pojos.User;
import com.mycompany.pojos.Wedding;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface WeddingRepository {
    List<Wedding> getWedding(int page, String startDate, String endDate, String priceSort);
    long countWedding();
    Wedding getWeddingById(int weddingId);
    boolean addWedding(int weddinghallId, int menuId, List<Service> services, int numberDesk, Date organizeDate, String description, BigDecimal totalPrice, User user);
}
