package com.joeun;

import com.joeun.dto.PostRequest;
import com.joeun.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save(){
        PostRequest params = new PostRequest();
        params.setTitle("6번 게시물 테스트");
        params.setContent("6번 게시물 내용");
        params.setWriter("트라이");
        params.setNoticeYn(false);
        Long id = postService.savePost(params);
        System.out.println("생성된 아이디: " + id);
    }

}
