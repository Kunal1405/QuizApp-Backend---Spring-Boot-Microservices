package com.kunal.QuizApp.Controller;

import com.kunal.QuizApp.Model.Questions;
import com.kunal.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<List<Questions>>getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("allquestions/{category}")
    public ResponseEntity<List<Questions>> getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }
    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
    @PostMapping("updateQuestion/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id,@RequestBody Questions response){
        return questionService.updateQuestion(id,response);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

}
