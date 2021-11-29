/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojos.Comment;
import java.util.List;

/**
 *
 * @author User
 */
public interface CommentRepository {
    Comment addComment(Comment c);
    List<Comment> getCommentsByWeddingId(int weddingId, int page);
    long countComment(int weddingId);
}
