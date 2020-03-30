package com.fms.service;

import com.fms.domain.Answers;
import com.fms.domain.Questions;
import com.fms.domain.QuestionsDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedbackService {
	Flux<Questions> getAllQuestions();
	Flux<Questions> getAllQuestionsById(Long id);
    Mono<Questions> saveQuestion(Questions question);
    Mono<Answers> saveAnswer(Answers answer);
    Mono<Void> deleteAnswerById(Long id);
    Flux<Answers> getAnswersById(Long id);
    //Mono<QuestionsDTO> getAnswersById(Long id);
    Mono<Void> deleteQuestionById(Long id);
}
