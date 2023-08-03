package com.joeun;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joeun.dto.TestRequest;
import com.joeun.dto.TestResponse;
import com.joeun.mapper.TestMapper;

@SpringBootTest
public class TestMapperTest {

    @Autowired
    TestMapper testMApper;

    @Test
    void save(){
        TestRequest testRequest = new TestRequest();
        testRequest.setTitle("2번 테스트입니다");
        testMApper.save(testRequest);
    }

    @Test
    void findById(){
        TestResponse testResponse = testMApper.findById(1L);
        System.out.println(testResponse.getTitle());
    }

    @Test
    void update(){

        TestRequest testRequest = new TestRequest();
        TestResponse testResponse = testMApper.findById(1L);
        System.out.println("변경 전 : "+testResponse.getTitle());
        testRequest.setId(1L);
        testRequest.setTitle("수정ㄷ두번된 제목입니다");
        testMApper.update(testRequest);
        testResponse = testMApper.findById(1L);
        System.out.println("변경 후 : "+testResponse.getTitle());

    }

    @Test
    void delete(){
        testMApper.deleteById(2L);
    }

    @Test
    void findAll(){
        List<TestResponse> testResponseList = testMApper.findAll();
        for(TestResponse t:testResponseList){
            System.out.println("글번호"+t.getId()+"제목"+t.getTitle());
        }
    }
}
