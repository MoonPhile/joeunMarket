package com.joeun.mapper;

import com.joeun.dto.PostFileRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostFileMapper {
    void saveAll (List<PostFileRequest> files);
    /**
     * 파일 리스트 조회
     * @param postId - 게시글 번호 (FK)
     * @return 파일 리스트
     */
//    List<PostFileResponse> findAllByPostId(Long postId);
//
//    /**
//     * 파일 리스트 조회
//     * @param ids - PK 리스트
//     * @return 파일 리스트
//     */
//    List<PostFileResponse> findAllByIds(List<Long> ids);
//
//    /**
//     * 파일 삭제
//     * @param ids - PK 리스트
//     */
//    void deleteAllByIds(List<Long> ids);
}
