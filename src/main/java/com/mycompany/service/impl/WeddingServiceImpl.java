/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.User;
import com.mycompany.pojos.Wedding;
import com.mycompany.repository.WeddingRepository;
import com.mycompany.service.WeddingService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class WeddingServiceImpl implements WeddingService{
    @Autowired
    private WeddingRepository weddingRepository;

    @Override
    public List<Wedding> getWedding(int page, String startDate, String endDate, String priceSort) {
        return this.weddingRepository.getWedding(page, startDate, endDate, priceSort);
    }

    @Override
    public long countWedding() {
        return this.weddingRepository.countWedding();
    }

    @Override
    public Wedding getWeddingById(int i) {
        return this.weddingRepository.getWeddingById(i);
    }

    @Override
    public boolean addWedding(int weddinghallId, int menuId, List<com.mycompany.pojos.Service> services, int numberDesk, Date organizeDate, String description, BigDecimal totalPrice, User user) {
        return this.weddingRepository.addWedding(weddinghallId, menuId, services, numberDesk, organizeDate, description, totalPrice, user);
    }
    
}
