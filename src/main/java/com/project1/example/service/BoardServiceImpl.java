package com.project1.example.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project1.example.domain.Board;
import com.project1.example.domain.Pagination;
import com.project1.example.domain.Search;
import com.project1.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardmapper;
	
	@Override
	public List<Board> selectBoardList() {
			return boardmapper.selectBoardList();
	}
	
	@Override
	public Board article(int bId) {
		return boardmapper.article(bId);
	}
	
	@Override
	public void writeAction(Board board) {
		boardmapper.writeAction(board);
	}
	
	@Override
	public void countView(int bId) {
		boardmapper.countView(bId);
	}
	
	@Override
	public int boardCount(Search search) {
		return boardmapper.boardCount(search);
	}
	
	@Override
	public Board reply(Board board) {
		return boardmapper.reply(board);
	}
	
	@Override
	public void replyAction(Board board) {
		boardmapper.replyAction(board);
	}
	
	@Override
	public void updateAction(Board board) {
		boardmapper.updateAction(board);
	}
	
	@Override
	public int deleteAction(int bId) {
		return boardmapper.deleteAction(bId);
	}
}


