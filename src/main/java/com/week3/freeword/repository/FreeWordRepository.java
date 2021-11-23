package com.week3.freeword.repository;

import com.week3.freeword.domain.FreeWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//TODO 4 JpaRepository에서 상속 받기
public interface FreeWordRepository extends JpaRepository<FreeWord,Long> {
    List<FreeWord> findAllByOrderByCreatedAtDesc();
}
