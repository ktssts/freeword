package com.week3.freeword.dto;

import lombok.Getter;


//TODO #2-1  DTO 만들기,  Getter만 있으면 됨. lombok기능. 질문?? lombok 어떤 기능 있음?  그리고 requestDto 본적 없음-> 3-1
@Getter
public class FreeWordRequestDto {
    private Long id;
    private String title;
    private String username;
    private String words;

}
