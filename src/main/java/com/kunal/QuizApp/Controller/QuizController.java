package com.kunal.QuizApp.Controller;

import com.kunal.QuizApp.Model.Questions;
import com.kunal.QuizApp.Model.Questionwrapper;
import com.kunal.QuizApp.Model.Response;
import com.kunal.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noQ,@RequestParam String title){
        return quizService.createQuiz(category,noQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<Questionwrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable int id,@RequestBody List<Response> response){
        return quizService.getResult(id,response);
    }
}
