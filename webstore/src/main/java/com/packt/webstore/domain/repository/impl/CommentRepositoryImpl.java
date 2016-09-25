package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Comment;
import com.packt.webstore.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.security.RolesAllowed;
import java.sql.ResultSet;
import java.util.List;
/**
 * Created by Przemek on 2016-08-11.
 */
@Repository
public class CommentRepositoryImpl implements CommentRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllComments(int customerId) {
        /*language=SQL*/
        String SQL_GET_ALL_COMMENTS= "Select customers.NAME, comments.comment_content, comments.comment_date\n" +
                "from comments join customers on customers.ID=comments.customer_id\n" +
                "where comments.customer_id=?;";

        return jdbcTemplate.query(SQL_GET_ALL_COMMENTS, new Object[] {customerId},
                (ResultSet result, int i)-> {
                    Comment comment= new Comment();
                    comment.setCommentatorName(result.getString(1));
                    comment.setCommentContent(result.getString(2));
                    comment.setCommentDate(result.getDate(3).toString());
                    return comment;

                });
    }

    @Override
    @RolesAllowed("USER")
    public void deleteComment() {}

    @Override
    @RolesAllowed("USER")
    public void addComment(String commentContent, String commentDate, int customerId) {
          /*language=SQL*/
        String SQL_ADD_COMMENT="Insert into comments(comment_content, comment_date, customer_id) value (?,?, ?)";

        jdbcTemplate.
                update(SQL_ADD_COMMENT,
                        commentContent,
                        commentDate,
                        customerId);
    }
}
