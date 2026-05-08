package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

   public List<Question>  findByCategory(String category);

   public List<Question>  findByDlevel(String dlevel);

   @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
   List<Question> findRandomQuestionByCategory(String category, int numQ);

   // public String addQuestion(Question question);

   // public String delQuestion(Id id);

}
