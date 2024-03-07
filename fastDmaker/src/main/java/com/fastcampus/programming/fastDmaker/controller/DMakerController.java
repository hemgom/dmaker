package com.fastcampus.programming.fastDmaker.controller;

import com.fastcampus.programming.fastDmaker.dto.*;
import com.fastcampus.programming.fastDmaker.exception.DMakerException;
import com.fastcampus.programming.fastDmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController // Bean의 타입을 `RestController`로 설정
                // "이 컨트롤러는 사용자요청을 받아 jason 값으로 응답을 내려주겠다"를 명시한다!
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;
    /*
    컨트롤러가 서비스를 가져와 써야하기 때문에 final을 사용해서 서비스 객체를 선언하고
    @RequiredArgsConstructor를 사용하여 생성자에 서비스를 반드시 가지고 있도록 한다.

    DMakerController(Bean) <- DMakerService(Bean)   DeveloperRepository(Bean)
    ====================Spring Applocation Contex============================
     */

    // 모든 developer의 간략 정보
    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        // GET /developers HTTP/1.1 >> 요청 들어옴!
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getAllEmployedDevelopers();
    }
    // 특정 developer의 세부 정보
    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            // 요청 값을 받아옴
            @Valid @RequestBody CreateDeveloper.Request request
            ) {
        log.info("request : {}", request);

        //요청 값을 넘겨줌
        return dMakerService.createDeveloper(request);
    }

    // PutMapping -> 모든 정보를 수정, PatchMapping -> 특정 정보를 수정
    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ) {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.editDeveloper(memberId, request);
    }

    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deleteDeveloper(
            @PathVariable String memberId
    ) {
        return dMakerService.deleteDeveloper(memberId);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DMakerException.class)
    public DMakerErrorResponse handleException (
            DMakerException e,
            HttpServletRequest request) {
        log.error("errorCode: {}, url: {}, message: {}",
                e.getDMakerErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return DMakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }
}
