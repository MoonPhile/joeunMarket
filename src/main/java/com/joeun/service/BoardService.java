package com.joeun.service;

import java.util.List;

import com.joeun.search.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dao.IBoardMapper;
import com.joeun.vo.BoardVO;

@Service
public class BoardService implements IBoardService{

    @Autowired
    IBoardMapper mapper;



    @Override
    public BoardVO getArticle(int boardNum) {

        mapper.updateViewCnt(boardNum); //사용자가 게시물을 조회할때 조회수를 올려주는 로직입니다
        return mapper.getArticle(boardNum);
    }

    @Override
    public void insert(BoardVO article) {
        mapper.insert(article);

    }

    @Override
    public void update(BoardVO article) {
        mapper.update(article);

    }

    @Override
    public void delete(int boardNum) {
        mapper.delete(boardNum);

    }

    @Override
    public int countArticles(SearchVO vo) {
        return mapper.countArticles(vo);
    }

    @Override
    public List<BoardVO> getAllArticles(SearchVO vo) {

        return mapper.getAllArticles(vo);
    }


}