package com.joeun.controller;
import com.joeun.dto.ReviewDto;
import com.joeun.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //컨트롤러 선언
public class ReviewController {

    @Autowired
    private ReviewService reviewService; //서비스와 연결

    @RequestMapping("/openReviewList.do")//localhost:8080/openReviewList //노테이션 값으로 주소 지정
    public ModelAndView openReviewList() throws Exception {
        //templates 폴더에 아래있는 /reviewList.html 의미.
        // Thymeleaf와 같은 템플릿엔진을 사용할 경우 스프링 부트의 자동 설정 기능으로 '.html'과 같은 접미사 생략 가능
        ModelAndView mv = new ModelAndView("/reviewList");
        //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectReviewList 메서드 호출
        List<ReviewDto> list = reviewService.selectReviewList();
        mv.addObject("list", list);

        return mv;

    }
    @RequestMapping("/openReviewWrite.do")//게시글 작성 화면 호출
    public String openReviewWrite() throws Exception{
        return "/reviewWrite";
    }

    @RequestMapping("/insertReview.do")		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insertReview(@ModelAttribute ReviewDto review) throws Exception{
        reviewService.insertReview(review);
        return "redirect:/openReviewList.do";	//게시글 리스트로 이동
    }

}
