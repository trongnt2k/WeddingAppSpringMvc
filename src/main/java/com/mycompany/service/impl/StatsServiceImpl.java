/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.mycompany.repository.StatsRepository;
import com.mycompany.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;
    @Override
    public List<Object[]> weddingStats(String fromDate, String toDate) {
        return this.statsRepository.weddingStats(fromDate, toDate);
    }

    @Override
    public List<Object[]> weddingRevenueStats(String fromDate, String toDate) {
        return this.statsRepository.weddingRevenueStats(fromDate, toDate);
    }

    @Override
    public List<Object[]> weddingYearStats(String fromDate, String toDate) {
        return this.statsRepository.weddingYearStats(fromDate, toDate);
    }

    @Override
    public List<Object[]> weddingRevenueYearStats(String fromDate, String toDate) {
        return this.statsRepository.weddingRevenueYearStats(fromDate, toDate);
    }
    
}
