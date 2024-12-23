package com.jbedu.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbedu.board.dao.BoardDao;
import com.jbedu.board.util.Constant;

@Controller
public class BoardController {
	
	private JdbcTemplate template;
	
	@Autowired //컨테이너 만들어져 있는 bean(객체)가 자동으로 DI 됨
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping(value = "/write_form")
	public String write_form() {
		return "write_form";
	}
	
	@RequestMapping(value = "/delete_form")
	public String delete_form() {
		return "delete_form";
	}
	
	@RequestMapping(value = "/writeOk")
	public String writeOk(HttpServletRequest request, Model model) {
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = new BoardDao();
		boardDao.boardWrite(bname, btitle, bcontent);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = new BoardDao();
		model.addAttribute("bDtos", boardDao.boardList());
		
		return "boardList";
	}
	
	@RequestMapping(value = "/deleteOk")
	public String deleteOk(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum");		
		
		BoardDao boardDao = new BoardDao();
		boardDao.boardDelete(bnum);
		
		return "redirect:boardList";
	}
	
	
	
}