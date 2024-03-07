package com.fastcampus.programming.fastDmaker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 실제 어플리케이션의 환경처럼 유사환경을 만들어 터스트 할 수 있게함
class DMakerServiceTest {
    @Autowired
    private DMakerService dMakerService;

    @Test
    public void testSomething() {
        String result = "hello" + "world!";

        // junit 시리즈에서 나오는 검증 방법, 가장 많이 사용된다.
        // 결과로 테스트가 통과했는지 성공, 실패여부를 알려준다.
        assertEquals("hello world!", result);
    }
}