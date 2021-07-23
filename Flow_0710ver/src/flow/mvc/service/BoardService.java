package flow.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flow.mvc.dao.board.BoardDao;
import flow.mvc.dao.board.BoardDaoInter;
import flow.mvc.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private BoardDaoInter boardDaoInter;
	
	
	public List<BoardVO> inBoard(BoardVO bvo) {
		return boardDaoInter.inBoard(bvo);
	}
	
	public BoardVO boardDtail(int b_num) {
		return boardDaoInter.boardDtail(b_num);
	}
	
	public void boardUpdate(BoardVO bvo) {
		boardDaoInter.boardUpdate(bvo);
	}
	
	public void boardInsert(BoardVO bvo) {
		boardDaoInter.boardInsert(bvo);
	}
	
	public void boardDelete(int b_num) {
		boardDaoInter.boardDelete(b_num);
	}
	
}
