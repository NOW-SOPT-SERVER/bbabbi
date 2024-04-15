package org.sopt.lab2.controller;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.sopt.lab2.domain.Part;
import org.sopt.lab2.repository.MemberRepository;
import org.sopt.lab2.service.MemberService;
import org.sopt.lab2.service.dto.MemberCreateDto;
import org.sopt.lab2.settings.ApiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class MemberControllerTest extends ApiTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested
    @DisplayName("멤버 생성 test")
    public class CreateMember {
        @Test
        @DisplayName("요청 성공 테스트")
        public void createMemberSuccess() throws Exception{
            // given
            final var request = new MemberCreateDto(
                    "Chaeyoung Moon",
                    Part.SERVER,
                    24
            );

            // when
            final var response = RestAssured
                    .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .when()
                    .post("/api/v1/member")
                    .then().log().all().extract();
            //then
            Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        }
    }
}