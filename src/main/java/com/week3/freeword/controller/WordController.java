package com.week3.freeword.controller;

import com.week3.freeword.domain.FreeWord;
import com.week3.freeword.repository.FreeWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class WordController {

    private final FreeWordRepository freeWordRepository;
    @RequestMapping(value = "/read-word/{id}", method= RequestMethod.GET)
    public String getWord(@PathVariable Long id, Model model) {
        Optional<FreeWord>word = freeWordRepository.findById(id);
        if (!word.isPresent()){
            return "redeirect:/";
        }

        model.addAttribute("username",word.get().getUsername());
        model.addAttribute("title",word.get().getTitle());
        model.addAttribute("words",word.get().getWords());
        model.addAttribute("createdAt", word.get().getCreatedAt());
        return "read-word";

    }

}
//
//    @RequestMapping(value = "/hello", method= RequestMethod.GET)
//    public String getWord(@PathVariable Long id ,Model model) {
//        model.addAttribute("words", "abc");
//        return "hello";
//    }
//
