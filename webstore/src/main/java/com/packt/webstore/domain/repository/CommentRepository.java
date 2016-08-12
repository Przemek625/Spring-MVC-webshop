package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Comment;

import java.sql.Date;
import java.util.List;

/**
 * Created by Przemek on 2016-08-11.
 */
public interface CommentRepository {

    List<Comment> getAllComments(int customerId);

    void deleteComment();

    void addComment(String commentContent, String commentDate, int customerId);
}
