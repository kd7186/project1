package com.project1.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project1.example.domain.Comment;

@Mapper
public interface CommentMapper {
	
	public List<Comment> selectCommentList(Comment comment);
	public void commentAction(Comment comment);
	public void commentReplyAction(Comment comment);
	public void commentUpdateAction(Comment comment);
	public void commentDelete(Comment comment);
}
