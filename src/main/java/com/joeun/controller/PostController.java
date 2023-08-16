package com.joeun.controller;

import com.joeun.dto.FileRequest;
import com.joeun.dto.FileResponse;
import com.joeun.dto.MessageDto;
import com.joeun.dto.PostRequest;
import com.joeun.dto.PostResponse;
import com.joeun.dto.SearchDto;
import com.joeun.service.FileService;
import com.joeun.service.FileUtils;
import com.joeun.service.PagingService;
import com.joeun.service.PostService;
import com.joeun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final FileService fileService;
    private final FileUtils fileUtils;
    private final PagingService pagingService;
    private final UserService userService;


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
    public String savePost(final PostRequest params, Model model) {
        Long id = postService.savePost(params);
        List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
        fileService.saveFiles(id, files);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }


    // 기존 게시글 수정
    @PostMapping("/update.do")
    public String updatePost(final PostRequest params, final SearchDto queryParams, Model model) {

        // 1. 게시글 정보 수정
        postService.updatePost(params);

        // 2. 파일 업로드 (to disk)
        List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

        // 3. 파일 정보 저장 (to database)
        fileService.saveFiles(params.getId(), uploadFiles);

        // 4. 삭제할 파일 정보 조회 (from database)
        List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());

        // 5. 파일 삭제 (from disk)
        fileUtils.deleteFiles(deleteFiles);

        // 6. 파일 삭제 (from database)
        fileService.deleteAllFileByIds(params.getRemoveFileIds());

        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/delete.do")
    public String deletePost(@RequestParam final Long id, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 리스트 페이지
    @GetMapping("/list.do")
    public String openPostList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size,
                               Model model) {
        int totalCount;
        int totalPages;
        totalCount = pagingService.countAllPost();
        totalPages = (int) Math.ceil((double) totalCount / size);

        if (page < 1) {
            page = 1;
        } else if (page > totalPages) {
            page = totalPages;
        }

        int offset = (page - 1) * size;

        List<PostResponse> posts = postService.findAllPost(offset, size);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("posts", posts);
        return "post_list";
    }

    // 게시글 상세 페이지
    @GetMapping("/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        PostResponse view = postService.findPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("viewCnt", view);
        postService.cntPlus(id);
        return "post_view";
    }


    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "messageRedirect";
    }

}




