/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Wedding;
import com.mycompany.repository.StatsRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> weddingStats(String fromDate, String toDate) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root root = query.from(Wedding.class);
        
        query.multiselect(builder.function("MONTH", Integer.class, root.get("organizeDate")),
                builder.function("YEAR", Integer.class, root.get("organizeDate")),
                builder.count(root.get("id")));
        if(fromDate != "" && toDate != ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p = builder.between(root.get("organizeDate"), frdate, todate);
                query = query.where(p);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate != "" && toDate == ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Predicate p1 = builder.greaterThanOrEqualTo(root.get("organizeDate"), frdate);
                query = query.where(p1);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate == "" && toDate != ""){
            try {
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p2 = builder.lessThanOrEqualTo(root.get("organizeDate"), todate);
                query = query.where(p2);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        query.groupBy(builder.function("MONTH", Integer.class, root.get("organizeDate")),
                builder.function("YEAR", Integer.class, root.get("organizeDate")));
        query.orderBy(builder.desc(root.get("organizeDate")));
        Query q = s.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Object[]> weddingRevenueStats(String fromDate, String toDate) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root root = query.from(Wedding.class);
        
        query.multiselect(builder.function("MONTH", Integer.class, root.get("createdDate")),
                builder.function("YEAR", Integer.class, root.get("createdDate")),
                builder.sum(root.get("totalPrice")));
        if(fromDate != "" && toDate != ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p = builder.between(root.get("createdDate"), frdate, todate);
                query = query.where(p);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate != "" && toDate == ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Predicate p1 = builder.greaterThanOrEqualTo(root.get("createdDate"), frdate);
                query = query.where(p1);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate == "" && toDate != ""){
            try {
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p2 = builder.lessThanOrEqualTo(root.get("createdDate"), todate);
                query = query.where(p2);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        query.groupBy(builder.function("MONTH", Integer.class, root.get("createdDate")),
                builder.function("YEAR", Integer.class, root.get("createdDate")));
        query.orderBy(builder.desc(root.get("createdDate")));
        Query q = s.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Object[]> weddingYearStats(String fromDate, String toDate) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root root = query.from(Wedding.class);
        
        query.multiselect(builder.function("YEAR", Integer.class, root.get("organizeDate")),
                builder.count(root.get("id")));
        if(fromDate != "" && toDate != ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p = builder.between(root.get("organizeDate"), frdate, todate);
                query = query.where(p);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate != "" && toDate == ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Predicate p1 = builder.greaterThanOrEqualTo(root.get("organizeDate"), frdate);
                query = query.where(p1);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate == "" && toDate != ""){
            try {
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p2 = builder.lessThanOrEqualTo(root.get("organizeDate"), todate);
                query = query.where(p2);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        query.groupBy(builder.function("YEAR", Integer.class, root.get("organizeDate")));
        query.orderBy(builder.desc(root.get("organizeDate")));
        Query q = s.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Object[]> weddingRevenueYearStats(String fromDate, String toDate) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root root = query.from(Wedding.class);
        
        query.multiselect(builder.function("YEAR", Integer.class, root.get("createdDate")),
                builder.sum(root.get("totalPrice")));
        if(fromDate != "" && toDate != ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p = builder.between(root.get("createdDate"), frdate, todate);
                query = query.where(p);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate != "" && toDate == ""){
            try {
                Date frdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
                Predicate p1 = builder.greaterThanOrEqualTo(root.get("createdDate"), frdate);
                query = query.where(p1);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(fromDate == "" && toDate != ""){
            try {
                Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
                Predicate p2 = builder.lessThanOrEqualTo(root.get("createdDate"), todate);
                query = query.where(p2);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        query.groupBy(builder.function("YEAR", Integer.class, root.get("createdDate")));
        query.orderBy(builder.desc(root.get("createdDate")));
        Query q = s.createQuery(query);
        
        return q.getResultList();
    }
    
}
