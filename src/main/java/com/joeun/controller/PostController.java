package com.joeun.controller;

import com.joeun.dto.PostFileRequest;
import com.joeun.dto.PostRequest;
import com.joeun.dto.PostResponse;
import com.joeun.service.PostFileService;
import com.joeun.service.PostFileUtils;
import com.joeun.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostFileService postFileService;
    private final PostFileUtils fileUtils;

    // 게시글 작성 페이지
    @GetMapping("/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post_write";
    }

    // 신규 게시글 생성
    @PostMapping("/save.do")
    public String savePost(final PostRequest params,Model model) {
        Long id = postService.savePost(params);
        List<PostFileRequest> files = fileUtils.uploadFiles(params.getFiles());
        postFileService.saveFiles(id, files);
        return "redirect:/list.do";

    }
    // 게시글 리스트 페이지
    @GetMapping("/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post_list";
    }
    // 게시글 상세 페이지
    @GetMapping("/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post_view";
    }
    // 기존 게시글 수정
    @PostMapping("/update.do")
    public String updatePost(final PostRequest params) {
        postService.updatePost(params);
        return "redirect:/list.do";
    }
    // 게시글 삭제
    @PostMapping("/delete.do")
    public String deletePost(@RequestParam final Long id) {
        postService.deletePost(id);
        return "redirect:/list.do";
    }




}