package com.fastcampus.programming.fastDmaker.exception;

import lombok.Getter;

@Getter
public class DMakerException extends RuntimeException {
    private DMakerErrorCode dMakerErrorCode;
    private String detailMessage;
    
    // 에러코드의 기본 메시지 출력 메서드
    public DMakerException(DMakerErrorCode errorCode) {
        super(errorCode.getMessage());
        this.dMakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }
    
    // 에러코드에 설정한 메세지를 출력하는 메서드
    public DMakerException(DMakerErrorCode errorCode, String detailMessage) {
        super(errorCode.getMessage());
        this.dMakerErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}
