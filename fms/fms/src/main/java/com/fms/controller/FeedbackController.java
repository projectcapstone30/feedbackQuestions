package com.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.fms.domain.Answers;
import com.fms.domain.Questions;
import com.fms.domain.QuestionsDTO;
import com.fms.service.FeedbackServiceImpl;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;
	
	
	@GetMapping("/questions")
	public Flux<Questions> getAllQuestions(){
		return feedbackServiceImpl.getAllQuestions();
		
	}
	
	@GetMapping("/question/{id}")
	public Flux<ResponseEntity<Questions>> getAllQuestionsById(@PathVariable Long id){
		return feedbackServiceImpl.getAllQuestionsById(id).map((question)->ResponseEntity.ok(question));
		
	}
	
	
	@PostMapping("/question/add")
	public Mono<Questions> saveQuestion(@RequestBody Questions question){
		return feedbackServiceImpl.saveQuestion(question);
	}
	
	@PostMapping("answer/add")
	public Mono<Answers> saveAnswers(@RequestBody Answers answer){
		return feedbackServiceImpl.saveAnswer(answer);
	}
	
	@DeleteMapping("answer/{id}")
	public Mono<Void> deleteAnswer(@PathVariable Long id){
		return feedbackServiceImpl.deleteAnswerById(id);
	}
	
	@GetMapping("answer/{id}")
	public Flux<Answers> getAllAnswersById(@PathVariable Long id)
	{
		return feedbackServiceImpl.getAnswersById(id);
	}
	
	@DeleteMapping("question/{id}")
	public Mono<Void> deleteQuestion(@PathVariable Long id){
//		deleteAnswer(id);
		return feedbackServiceImpl.deleteQuestionById(id);
	}
	

//	@GetMapping("answers/{id}")
//	public Mono<QuestionsDTO> getAllAnswersById(@PathVariable Long id)
//	{
//		return feedbackServiceImpl.getAnswersById(id);
//	}

}
