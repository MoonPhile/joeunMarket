package com.joeun.controller;

import com.joeun.service.BoardService;
import dao.BoardVO;
import dao.PageCreator;
import dao.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService service;

    //검색과 페이징이 포함된 게시물 전체리스트 조회
    @GetMapping("/list")
    public String list(SearchVO vo , Model model) {
        List<BoardVO> list = service.getAllArticles(vo);
        PageCreator pc = new PageCreator();
        pc.setPaging(vo);
        pc.setTotalArticles(service.countArticles(vo));
        model.addAttribute("all",list);
        model.addAttribute("pc",pc);
        return "list";
    }


    //게시물 등록페이지 이동
    @GetMapping("/write")
    public String write() {
        return "write";
    }


    //게시물 등록
    @PostMapping("/write")
    public String write2(BoardVO vo)
    {
        service.insert(vo);
        return "redirect:list";
    }


    //게시물 조회
    @GetMapping("/check")
    public String check(int boardNum,Model model) {
        BoardVO vo = service.getArticle(boardNum);
        model.addAttribute("vo", vo);
        return "content";
    }

    //게시물 삭제
    @GetMapping("/delete")
    public String delete(int boardNum)
    {
        service.delete(boardNum);
        return "redirect:list";
    }


    //게시물 수정페이지 이동
    @GetMapping("/modify")
    public String modify(int boardNum,Model model) {
        BoardVO vo = service.getArticle(boardNum);
        model.addAttribute("vo", vo);
        return "modify";
    }

    //게시물 수정
    @PostMapping("/modify")
    public String modify2(BoardVO article) {
        service.update(article);
        return "redirect:list";
    }

}
