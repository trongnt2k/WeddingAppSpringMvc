/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Dishesanddrink;
import com.mycompany.repository.DishesanddrinkRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Transactional
@Repository
public class DishesanddrinkRepositoryImpl implements DishesanddrinkRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Dishesanddrink> getDishesanddrink(String kw) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Dishesanddrink.class);
        Root root = query.from(Dishesanddrink.class);
        query = query.select(root);
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("name").as(String.class), String.format(kw, "%%%s%%"));
            query = query.where(p);
        }
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Dishesanddrink dishesanddrink) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            s.save(dishesanddrink);
            return true;
        } catch(Exception ex){
            System.err.println("== ADD DISHESANDDRINK ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }
}
