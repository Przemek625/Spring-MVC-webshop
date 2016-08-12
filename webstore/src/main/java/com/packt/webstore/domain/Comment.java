package com.packt.webstore.domain;

/**
 * Created by Przemek on 2016-08-11.
 */
public class Comment {

    private int commentId;
    private int customerId;
    private String commentContent;
    private String commentDate;
    private String commentatorName;


    public Comment(){}

    public Comment(int commentId, int customerId, String commentContent, String commentDate) {
        this.commentId = commentId;
        this.customerId = customerId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName;
    }
}
