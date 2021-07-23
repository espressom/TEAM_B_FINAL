package flow.mvc.dao.board;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flow.mvc.vo.BoardVO;

@Repository
public class BoardDao implements BoardDaoInter{
	
	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public List<BoardVO> inBoard(BoardVO bvo) {
		List<BoardVO> list = ss.selectList("board.boardlist", bvo);
		System.out.println("ÃÑ °Ô½Ã±Û ::::" + list.size());
		return list;
	}

	@Override
	public BoardVO boardDtail(int b_num) {
		return ss.selectOne("board.detail",b_num);
	}

	@Override
	public void boardUpdate(BoardVO bvo) {
		ss.update("board.update", bvo);
	}

	@Override
	public void boardInsert(BoardVO bvo) {
		ss.insert("board.insert", bvo);
	}

	@Override
	public void boardDelete(int b_num) {
		ss.delete("board.delete", b_num);
	}
	
}
