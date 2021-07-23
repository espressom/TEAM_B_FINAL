package flow.mvc.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flow.mvc.service.BoardService;
import flow.mvc.vo.BoardVO;

// ���±�
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/blogtestform")
	public String blogform() {
		return "board/blogtestform";
	}
	
	// �Խ��� ���� ���±�
	@RequestMapping("/boardIn")
	public String boardList(BoardVO bvo,Model m) {
//		String category = bvo.getB_category();
//		System.out.println(category);
		m.addAttribute("list",boardService.inBoard(bvo));
		return "board/boardTestForm";
	}
	
	// �Խ��� �󼼺��� ���±�
	@RequestMapping(value="/boardDetail")
	public String boardDetail(int b_num,Model m) {
		System.out.println("�Խ��ǹ�ȣ :::: "+b_num);
		m.addAttribute("vo",boardService.boardDtail(b_num));
		return "board/boardDetailForm";
	}
	
	// �Խ��� ���� ���±�
	@RequestMapping("boardUpdateForm")
	public String boardUpdateForm(int b_num, Model m) {
		System.out.println(b_num);
		m.addAttribute("vo",boardService.boardDtail(b_num));
		return "board/boardUpdateForm";
	}
	
	// �Խ��� �����Ϸ� ���±�
	@RequestMapping("boardUpdate")
	public String boardUpdate(BoardVO bvo) {
		boardService.boardUpdate(bvo);
		System.out.println(bvo.getB_num());
		System.out.println(bvo.getB_subject());
		return "redirect:blogtestform";
	}
	

	
	// �Խ��ǵ�� ���±�
	@RequestMapping("boardInsertForm")
	public String insertBoard(int bl_num, Model m) {
		m.addAttribute("bl_num", bl_num);
		return "board/boardInsertForm";
	}
	
	// �Խ��� ��� �Ϸ�
	@RequestMapping("boardInsert")
	public String insertBoardSuccess(BoardVO bvo) {
		boardService.boardInsert(bvo);
		return "redirect:blogtestform";
	}
	
	
	// �Խ��� ���� ���±�
	@RequestMapping("boardDelete")
	public String boardDelete(int b_num) {
		boardService.boardDelete(b_num);
		return "redirect:blogtestform";
	}
	
}
