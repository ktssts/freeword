package com.week3.freeword.controller;

import com.week3.freeword.domain.FreeWord;
import com.week3.freeword.repository.FreeWordRepository;
import com.week3.freeword.dto.FreeWordRequestDto;
import com.week3.freeword.service.FreeWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO #3 controller 완성하기 - api, 경로세팅
// 아래 2개 항상 있음

@RestController         //@ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있습니다.
@RequiredArgsConstructor   // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
public class FreeWordController {

    private final FreeWordService freeWordService;       // 현재 페이지에서 freeWordService 생성하기
    private final FreeWordRepository freeWordRepository; // 현재 페이지에서 freeWordRepository 생성하기

    //TODO 3-1 CRUD - C
    @PostMapping("/api/freewords")
    public FreeWord createFreeWords(@RequestBody FreeWordRequestDto requestDto){
        FreeWord freeWord = new FreeWord(requestDto);
        return freeWordRepository.save(freeWord);    // freeWordRepository -> 완성하로가기 #4
    }

    //TODO 3-2 CRUD - R
    @GetMapping("/api/freewords")
    public List<FreeWord> getFreewords(){      //getFreewords -> 경로에있는 키둬드 가져오기
//        return freeWordRepository.findAll(); //TODO 확인
        return freeWordRepository.findAllByOrderByCreatedAtDesc(); //TODO 문제해결 1.Timestamped.java 2.FreeWordRepository.java에 미리설정 해야함.

    }

    //TODO 3-3 CRUD - U
    @PutMapping("/api/freewords/{id}")
    public Long updateFreeWords(@PathVariable Long id, @RequestBody FreeWordRequestDto requestDto){
        freeWordService.update(id,requestDto);   // -> #5 service
        return id;
    }

    //TODO 3-4 CRUD - D
    @DeleteMapping("/api/freewords/{id}")
    public Long deleteFreeWords (@PathVariable Long id){
        freeWordRepository.deleteById(id); // #4 -> here #6
        return id;
    }

//    //TODO 방문경로설정 - 따로 @controller해아함  ?? 왜??
    @GetMapping("/api/words/{id}")
    public FreeWord sendingid(@PathVariable Long id) {
        FreeWord freeWord = freeWordRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시물을 찾을 수 없습니다.")
        );
        return freeWord;
    }

}
