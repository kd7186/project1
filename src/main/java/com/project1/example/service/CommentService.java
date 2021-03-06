package com.project1.example.service;

import java.util.List;


import com.project1.example.domain.Comment;
import com.project1.example.mapper.CommentMapper;



public interface CommentService {
	static CommentService service= null;
	static CommentMapper mapper = null;
	
	public List<Comment> selectCommentList(Comment comment);
	public void commentAction(Comment comment);
	public void commentReplyAction(Comment comment);
	public void commentUpdateAction(Comment comment);
	public void commentDelete(Comment comment);
}
