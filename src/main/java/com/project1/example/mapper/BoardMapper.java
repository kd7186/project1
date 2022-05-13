package com.project1.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project1.example.domain.Board;
import com.project1.example.domain.Pagination;
import com.project1.example.domain.Search;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList(Pagination pagination);
	
	public Board article(int bId);
	
	public void writeAction(Board board);
	
	public void countView(int bId);
	
	public int boardCount(Search search);
	
	public Board reply(Board board);
	
	public void replyAction(Board board);
	
	public void updateAction(Board board);
	
	public int deleteAction(int bId);
}
