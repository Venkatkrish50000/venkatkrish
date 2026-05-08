package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questiondao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        return new ResponseEntity<>(questiondao.findByCategory(category), HttpStatus.OK);
    }

    public List<Question> getQuestionsBydlevel(@PathVariable String dlevel) {
        return questiondao.findByDlevel(dlevel);


    }

    public String addQuestion(Question question) {
        questiondao.save(question);
        return "success";
    }
//public String delQuestion(Id id) {
//questiondao.delQuestion(id);

// return "Deleted Thank you";
//  }
}
