/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Comment;
import com.mycompany.repository.CommentRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
@Transactional
@Repository
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Comment addComment(Comment c) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(c);
            
            return c;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Comment> getCommentsByWeddingId(int weddingId, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root root = query.from(Comment.class);
        query = query.where(builder.equal(root.get("wedding"), weddingId));
        query = query.orderBy(builder.desc(root.get("id")));
        
        Query q = s.createQuery(query);
        
        int max=6;
        q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        
        return q.getResultList();
    }

    @Override
    public long countComment(int weddingId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("Select Count(*) From Comment Where wedding.id=:id");
        q.setParameter("id", weddingId);
        
        return Long.parseLong(q.getSingleResult().toString());
    }
    
}
