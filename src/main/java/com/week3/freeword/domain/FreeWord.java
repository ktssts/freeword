package com.week3.freeword.domain;

import com.week3.freeword.dto.FreeWordRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//TODO 아래 3개 무조건 있어야함
@Getter
@NoArgsConstructor
@Entity
public class FreeWord extends Timestamped{  // Timestamped 추가시

    //TODO #1-1 맨버 변수 세팅  -  초기 세팅후 추후에 수정하기
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String words;

    //TODO #1-2 1-2 다 쓰면 FreeWordRequestDto error -> 2-1 RequestDto 쓰기
    public FreeWord(FreeWordRequestDto requestDto){
        this.username=requestDto.getUsername();
        this.title=requestDto.getTitle();
        this.words=requestDto.getWords();
    }

    //TODO #5-4  update 매소드
    public void update(FreeWordRequestDto requestDto){
        this.username = getUsername();
        this.title=requestDto.getTitle();
        this.words=requestDto.getWords();
    }

}
