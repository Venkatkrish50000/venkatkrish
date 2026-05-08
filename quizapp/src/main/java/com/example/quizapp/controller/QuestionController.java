package com.example.quizapp.controller;


import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionservice;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionservice.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionservice.getQuestionsByCategory(category);
    }

    @GetMapping("dlevel/{dlevel}")
    public List<Question> getQuestionsBydlevel(@PathVariable String dlevel) {
        return questionservice.getQuestionsBydlevel(dlevel);
    }
//Main test
    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question) {
        return questionservice.addQuestion(question);
    }

    // @DeleteMapping("delQuestion")
    //public String delQuestion(Id id){

    //return questionservice.delQuestion(id); jljkj
    //  }

}
