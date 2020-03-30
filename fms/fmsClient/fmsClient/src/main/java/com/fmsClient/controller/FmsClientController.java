package com.fmsClient.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fmsClient.domain.Answers;
import com.fmsClient.domain.Questions;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FmsClientController {
	
	WebClient webClient=WebClient.create("http://localhost:8080/feedback");
	
	@GetMapping("/client/question")
	public Flux<Questions> getQuestionsRetrieve(){
		return webClient.get().uri("/question")
				.retrieve()
				.bodyToFlux(Questions.class)
				.log("Questions in retrieve");
	}
	
	@GetMapping("/client/question/{id}")
	public Flux<Questions> getQuestionsRetrieve(@PathVariable Long id){
		return webClient.get().uri("/question/{id}",id)
				.retrieve()
				.bodyToFlux(Questions.class)
				.log("Questions in retrieve");
	}
	
	@PostMapping("/client/question/add")
	public Mono<Questions> createQuestion(@RequestBody Questions question){
		Mono<Questions> questionMono=Mono.just(question);
		return webClient.post().uri("/question/add")
				.contentType(MediaType.APPLICATION_JSON)
				.body(questionMono,Questions.class)
				.retrieve()
				.bodyToMono(Questions.class)
				.log("created question is");
	}
	
	@DeleteMapping("/client/question/{id}")
	public Mono<Void> deleteQuestions(@PathVariable Long id){
		return webClient.delete().uri("/question/{id}",id)
				.retrieve()
				.bodyToMono(Void.class)
				.log("Questions in retrieve");
	}
	
	

	@GetMapping("/client/answer/{id}")
	public Flux<Answers> getAnswersRetrieve(@PathVariable Long id){
		return webClient.get().uri("/answer/{id}",id)
				.retrieve()
				.bodyToFlux(Answers.class)
				.log("Questions in retrieve");
	}
	
	@PostMapping("/client/answer/add")
	public Mono<Answers> saveAnswer(@RequestBody Answers answer){
		Mono<Answers> answerMono=Mono.just(answer);
		return webClient.post().uri("/answer/add")
				.contentType(MediaType.APPLICATION_JSON)
				.body(answerMono,Answers.class)
				.retrieve()
				.bodyToMono(Answers.class)
				.log("created question is");
	}
	
	@DeleteMapping("/client/answer/{id}")
	public Mono<Void> deleteAnswer(@PathVariable Long id){
		return webClient.delete().uri("/answer/{id}",id)
				.retrieve()
				.bodyToMono(Void.class)
				.log("Questions in retrieve");
	}



}
