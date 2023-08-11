package com.joeun.service;

import com.joeun.dto.PostFileRequest;
import com.joeun.dto.PostFileResponse;
import com.joeun.mapper.PostFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFileService {

    private final PostFileMapper postFileMapper;

    /**
     * 파일 정보 저장 (to Database)
     * @param postId - 게시글 번호 (FK)
     * @param files - 파일 정보 리스트
     */
    @Transactional
    public void saveFiles(final Long postId, final List<PostFileRequest> files){
        if(CollectionUtils.isEmpty(files)){
            return;
        }
        for(PostFileRequest file : files){
            file.setPostId(postId);

        }
        postFileMapper.saveAll(files);
    }
    /**
     * 파일 리스트 조회
     * @param postId - 게시글 번호 (FK)
     * @return 파일 리스트
     */
    public List<PostFileResponse> findAllFileByPostId(final Long postId) {
        return postFileMapper.findAllByPostId(postId);
    }

    /**
     * 파일 리스트 조회
     * @param ids - PK 리스트
     * @return 파일 리스트
     */
    public List<PostFileResponse> findAllFileByIds(final List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return postFileMapper.findAllByIds(ids);
    }

    /**
     * 파일 삭제 (from Database)
     * @param ids - PK 리스트
     */
    @Transactional
    public void deleteAllFileByIds(final List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        postFileMapper.deleteAllByIds(ids);
    }


}
