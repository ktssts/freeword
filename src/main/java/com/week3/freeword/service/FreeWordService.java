package com.week3.freeword.service;

import com.week3.freeword.domain.FreeWord;
import com.week3.freeword.repository.FreeWordRepository;
import com.week3.freeword.dto.FreeWordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


//TODO #5 Service 완성하기

@Service     // 서버라고 알려준
@RequiredArgsConstructor  //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
public class FreeWordService {
    private final FreeWordRepository freeWordRepository;

    @Transactional
    public Long update(Long id, FreeWordRequestDto requestDto){
        FreeWord freeWord = freeWordRepository.findById(id).orElseThrow (
                        () -> new IllegalArgumentException("해당 id가 존재하지 않습니다."));
        freeWord.update(requestDto);
        return  freeWord.getId();
    }
}