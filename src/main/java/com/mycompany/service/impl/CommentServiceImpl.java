/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.Comment;
import com.mycompany.pojos.User;
import com.mycompany.pojos.Wedding;
import com.mycompany.repository.CommentRepository;
import com.mycompany.repository.UserRepository;
import com.mycompany.repository.WeddingRepository;
import com.mycompany.service.CommentService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private WeddingRepository weddingRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(String content, int weddingId, User creator) {
        Wedding d = this.weddingRepository.getWeddingById(weddingId);
        Date date = Calendar.getInstance().getTime();
  
        Comment c = new Comment();
        c.setContent(content);
        c.setWedding(d);
        c.setUser(creator);
        c.setCreatedDate(date);
        
        return this.commentRepository.addComment(c);
    }

    @Override
    public List<Comment> getCommentsByWeddingId(int weddingId, int page) {
        return this.commentRepository.getCommentsByWeddingId(weddingId, page);
    }

    @Override
    public long countComment(int weddingId) {
        return this.commentRepository.countComment(weddingId);
    }
}
