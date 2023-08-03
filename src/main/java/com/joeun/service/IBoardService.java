package com.joeun.service;

import com.joeun.search.SearchVO;
import com.joeun.vo.BoardVO;

import java.util.List;

public interface IBoardService {

    //전체 리스트 조회
    List<BoardVO> getAllArticles(SearchVO vo);

    //특정 게시물 조회
    BoardVO getArticle(int boardNum);

    //전체 게시물수 조회(검색 페이징 포함)
    int countArticles(SearchVO vo);

    //게시물 등록
    void insert(BoardVO article);

    //특정게시물 수정
    void update(BoardVO article);

    //특정게시물 삭제
    void delete(int boardNum);
}
