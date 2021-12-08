/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface StatsRepository {
    List<Object[]> weddingStats(String fromDate, String toDate);
    List<Object[]> weddingYearStats(String fromDate, String toDate);
    List<Object[]> weddingRevenueStats(String fromDate, String toDate);
    List<Object[]> weddingRevenueYearStats(String fromDate, String toDate);
}
