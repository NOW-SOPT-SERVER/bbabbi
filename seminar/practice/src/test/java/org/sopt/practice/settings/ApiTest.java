package org.sopt.practice.settings;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    private int port; // 포트번호 할당

    @BeforeEach // 모든 테스트를 시행하기 전에 이걸 하겠다는 내용의 어노테이션
    void setUp(){
        RestAssured.port = port;
    }
}
