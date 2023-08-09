package com.joeun.service;

import com.joeun.dto.PostFileRequest;
import com.joeun.mapper.PostFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFileService {

    private final PostFileMapper postFileMapper;

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


}
