package flow.mvc.dao.board;



import java.util.List;

import flow.mvc.vo.BoardVO;

public interface BoardDaoInter {
	public List<BoardVO> inBoard(BoardVO bvo);
	public BoardVO boardDtail(int b_num);
	public void boardUpdate(BoardVO bvo);
	public void boardInsert(BoardVO bvo);
	public void boardDelete(int b_num);
}
