package com.joeun.controller;


import com.joeun.dto.PostFileResponse;
import com.joeun.service.PostFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostFileApiController {

    private final PostFileService postFileService;

    // 파일 리스트 조회
    @GetMapping("{postId}/files")
    public List<PostFileResponse> findAllFileByPostId(@PathVariable final Long postId) {
        return postFileService.findAllFileByPostId(postId);
    }

}