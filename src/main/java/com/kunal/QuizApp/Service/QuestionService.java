package com.kunal.QuizApp.Service;

import com.kunal.QuizApp.Model.Questions;
import com.kunal.QuizApp.Repo.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepo repo;
    public ResponseEntity<List<Questions>> getAllQuestion() {
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Questions>> getByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try{
            repo.save(question);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed",HttpStatus.NOT_ACCEPTABLE);

        }
    }

    public ResponseEntity<String> updateQuestion(int id, Questions response) {
        Optional<Questions> existingQuestion = repo.findById(id);

        if (existingQuestion.isPresent()) {
            Questions questionToUpdate = existingQuestion.get();
            questionToUpdate.setQuestion(response.getQuestion());
            questionToUpdate.setOption1(response.getOption1());
            questionToUpdate.setOption2(response.getOption2());
            questionToUpdate.setOption3(response.getOption3());
            questionToUpdate.setOption4(response.getOption4());
            questionToUpdate.setRightAnswer(response.getRightAnswer());
            questionToUpdate.setDifficultyLevel(response.getDifficultyLevel());
            questionToUpdate.setCategory(response.getCategory());

            repo.save(questionToUpdate);
            return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            repo.deleteById(id);
            return new ResponseEntity<>("Successfully Deleted",HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Failed",HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
