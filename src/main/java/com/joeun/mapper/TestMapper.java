package com.joeun.mapper;

import com.joeun.dto.TestRequest;
import com.joeun.dto.TestResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    /**
     *
     * @param testRequest - 테스트 게시글 정보
     */
    void save(TestRequest testRequest);

    /**
     *
     * @param id - pk
     * @return - 게시글 정보
     */
    TestResponse findById(Long id);

    /**
     *
     * @param testRequest - 수정시킬 내용
     */
    void update(TestRequest testRequest);

    /**
     *
     * @param id - 삭제 시킬 아이디
     */
    void deleteById(Long id);

    /**
     *
     * @return - 전체 게시글 가져오기 ㅇㅋ?
     */
    List<TestResponse> findAll();
}
