package com.example.quizapp.dao;

import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {

    //public ResponseEntity<String> createQuizByRandom(String category, int numQ, String title) {


   // }
}
