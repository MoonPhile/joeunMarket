package com.joeun.mapper;

import com.joeun.dto.SearchDto;
import com.joeun.dto.PostRequest;
import com.joeun.dto.PostResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findById(Long id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAll(@Param("offset") int offset, @Param("size") int size);

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);



    public boolean cntPlus(Long id);




}