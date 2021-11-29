/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Comment;
import com.mycompany.pojos.WeddingHall;
import com.mycompany.repository.WeddingHallRepository;
import java.util.List;
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
public class WeddingHallRepositoryImpl implements WeddingHallRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<WeddingHall> getWeddingHalls(String kw, int page, String priceSort, String weddingTime) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<WeddingHall> query = builder.createQuery(WeddingHall.class);
        Root root = query.from(WeddingHall.class);
        query = query.select(root);
        if(kw != null){
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        if(weddingTime != ""){
            Predicate p1 = builder.equal(root.get("timeWedding").as(String.class), weddingTime);
            query = query.where(p1);
        }
        if(priceSort.equals("pri-incr") == true){
            query = query.orderBy(builder.asc(root.get("weddingHallPrice")));
        }
        if(priceSort.equals("pri-decr") == true){
            query = query.orderBy(builder.desc(root.get("weddingHallPrice")));
        }
        Query q = s.createQuery(query);
        
        int max=6;
        q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(WeddingHall weddinghall) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            s.save(weddinghall);
            return true;
        } catch(Exception ex){
            System.err.println("== ADD WEDDINGHALL ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public long countWeddingHall() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("Select Count(*) From WeddingHall");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public WeddingHall getWeddingHallById(int weddingHallId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(WeddingHall.class, weddingHallId);
    }
    
}
