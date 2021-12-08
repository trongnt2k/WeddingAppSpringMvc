/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Menu;
import com.mycompany.pojos.Service;
import com.mycompany.pojos.User;
import com.mycompany.pojos.Wedding;
import com.mycompany.pojos.WeddingHall;
import com.mycompany.repository.WeddingRepository;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class WeddingRepositoryImpl implements WeddingRepository{
    @Autowired
    LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Wedding> getWedding(int page, String startDate, String endDate, String priceSort) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Wedding> query = builder.createQuery(Wedding.class);
        Root root = query.from(Wedding.class);
        query = query.select(root);
        if(startDate != "" && endDate != ""){
            try {
                Date stdate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                Date endate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
                Predicate p = builder.between(root.get("organizeDate"), stdate, endate);
                query = query.where(p);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(startDate != "" && endDate == ""){
            try {
                Date stdate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                Predicate p1 = builder.greaterThanOrEqualTo(root.get("organizeDate"), stdate);
                query = query.where(p1);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(startDate == "" && endDate != ""){
            try {
                Date endate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
                Predicate p2 = builder.lessThanOrEqualTo(root.get("organizeDate"), endate);
                query = query.where(p2);
            } catch (ParseException ex) {
                Logger.getLogger(WeddingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(priceSort.equals("pri-incr") == true){
            query = query.orderBy(builder.asc(root.get("totalPrice")));
        }
        if(priceSort.equals("pri-decr") == true){
            query = query.orderBy(builder.desc(root.get("totalPrice")));
        }
        Query q = s.createQuery(query);
        
        int max=6;
        q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        
        return q.getResultList();
    }

    @Override
    public long countWedding() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("Select Count(*) From Wedding");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Wedding getWeddingById(int weddingId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Wedding.class, weddingId);
    }

    @Override
    public boolean addWedding(int weddinghallId, int menuId, List<Service> services, int numberDesk, Date organizeDate, String description, BigDecimal totalPrice, User user) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try{
            Wedding w = new Wedding();
            if(weddinghallId != 0)
                w.setWeddinghall(s.get(WeddingHall.class, weddinghallId));
            if(menuId != 0)
                w.setMenu(s.get(Menu.class, menuId));
            if(services != null){
                List <Service> svl = new ArrayList<>();
                for (int i=0; i<services.size(); i++)
                    svl.add(services.get(i));
                Set<Service> svs = new HashSet<>(svl);
                w.setService(svs);
            }
            w.setUser(user);
            w.setNumberDesk(numberDesk);
            w.setOrganizeDate(organizeDate);
            w.setDescription(description);
            w.setTotalPrice(totalPrice);
            w.setCreatedDate(new Date());
            
            s.save(w);
            
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
}
