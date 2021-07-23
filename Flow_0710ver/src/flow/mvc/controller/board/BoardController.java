package flow.mvc.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import flow.mvc.service.BoardService;
import flow.mvc.vo.BoardVO;

// 하태근
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/blogtestform")
	public String blogform() {
		return "board/blogtestform";
	}
	
	// 게시판 진입 하태근
	@RequestMapping("/boardIn")
	public String boardList(BoardVO bvo,Model m) {
//		String category = bvo.getB_category();
//		System.out.println(category);
		m.addAttribute("list",boardService.inBoard(bvo));
		return "board/boardTestForm";
	}
	
	// 게시판 상세보기 하태근
	@RequestMapping(value="/boardDetail")
	public String boardDetail(int b_num,Model m) {
		System.out.println("게시판번호 :::: "+b_num);
		m.addAttribute("vo",boardService.boardDtail(b_num));
		return "board/boardDetailForm";
	}
	
	// 게시판 수정 하태근
	@RequestMapping("boardUpdateForm")
	public String boardUpdateForm(int b_num, Model m) {
		System.out.println(b_num);
		m.addAttribute("vo",boardService.boardDtail(b_num));
		return "board/boardUpdateForm";
	}
	
	// 게시판 수정완료 하태근
	@RequestMapping("boardUpdate")
	public String boardUpdate(BoardVO bvo) {
		boardService.boardUpdate(bvo);
		System.out.println(bvo.getB_num());
		System.out.println(bvo.getB_subject());
		return "redirect:blogtestform";
	}
	

	
	// 게시판등록 하태근
	@RequestMapping("boardInsertForm")
	public String insertBoard(int bl_num, Model m) {
		m.addAttribute("bl_num", bl_num);
		return "board/boardInsertForm";
	}
	
	// 게시판 등록 완료
	@RequestMapping("boardInsert")
	public String insertBoardSuccess(BoardVO bvo) {
		boardService.boardInsert(bvo);
		return "redirect:blogtestform";
	}
	
	
	// 게시판 삭제 하태근
	@RequestMapping("boardDelete")
	public String boardDelete(int b_num) {
		boardService.boardDelete(b_num);
		return "redirect:blogtestform";
	}
	
}
