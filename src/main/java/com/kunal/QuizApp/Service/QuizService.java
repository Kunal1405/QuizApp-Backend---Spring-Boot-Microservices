package com.kunal.QuizApp.Service;

import com.kunal.QuizApp.Model.Questions;
import com.kunal.QuizApp.Model.Questionwrapper;
import com.kunal.QuizApp.Model.Quiz;
import com.kunal.QuizApp.Model.Response;
import com.kunal.QuizApp.Repo.QuestionsRepo;
import com.kunal.QuizApp.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionsRepo repo;
    public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
        List<Questions> questions=repo.findRandomQuestions(category,noQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Questionwrapper>> getQuizQuestions(int id) {
        Optional<Quiz>quiz=quizRepo.findById(id);
        List<Questions>questions=quiz.get().getQuestions();
        List<Questionwrapper> questionForUser=new ArrayList<>();
        for(Questions q : questions){
            Questionwrapper qw= new Questionwrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return  new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getResult(int id, List<Response> response) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Questions>questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response resp:response){
            if(resp.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.ACCEPTED);
    }
}
