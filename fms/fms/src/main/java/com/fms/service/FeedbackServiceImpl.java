package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.domain.Answers;
import com.fms.domain.AnswersDTO;
import com.fms.domain.Questions;
import com.fms.domain.QuestionsDTO;
import com.fms.repository.AnswersRepository;
import com.fms.repository.QuestionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	QuestionRepository repo;
	@Autowired
	AnswersRepository answersRepository;

	@Override
	public Flux<Questions> getAllQuestions() {
	
		Flux<Questions> questions=repo.findAll();
		System.out.println(questions);
		return questions.log();
	}
	
	@Override
	public Flux<Questions> getAllQuestionsById(Long id) {
		
		Flux<Questions> questions_feedbackType=repo.findQuestionsById(id);
		System.out.println(questions_feedbackType);
		return questions_feedbackType.log();
	}
	@Override
public Mono<Questions> saveQuestion(Questions question){
		
		System.out.println(question.getQ_id());
		Mono<Questions> question1=repo.save(question);
		System.out.println(question1);
		return question1.log();
	}
	
	@Override
public Mono<Answers> saveAnswer(Answers answer){
		Mono<Answers> answer1= answersRepository.save(answer);
		System.out.println(answer1);
		return answer1.log();
	}

	@Override
	public Mono<Void> deleteAnswerById(Long id) {
		
		return answersRepository.deleteById(id);
	}

	@Override
	public Flux<Answers> getAnswersById(Long id) {
		Flux<Answers> answers= answersRepository.findAnswersById(id);
		return answers;
	}

	@Override
	public Mono<Void> deleteQuestionById(Long id) {
		
		return repo.deleteById(id);
	}

//	@Override
//	public Mono<QuestionsDTO> getAnswersById(Long id) {
//AnswersDTO answerDto=new AnswersDTO();
//		Flux<Answers> answers= answersRepository.findAnswersById(id);
//		Flux<AnswersDTO> answersFux=answers.map((a)->{
//			answerDto.setAnswerId(a.getId());
//			answerDto.setAnswerName(a.getName());
//			return answerDto;
//		});
//
//		Mono<Questions> question=repo.findById(id);
//		
//		QuestionsDTO questionsDTO=new QuestionsDTO();
//		Mono<QuestionsDTO> questionMono=question.map((q)->{
//		questionsDTO.setQuestionId(q.getQ_id());
//		questionsDTO.setQuestionName(q.getQ_name());
//		//answersFux.subscribe(x->System.out.println(x.getAnswerName()));
//		questionsDTO.setAnswersDTO(answersFux);
//		return questionsDTO;
//		});
//		questionMono.subscribe(x->x.getAnswersDTO().subscribe(a->System.out.println(a.getAnswerName())));
//		
//		//System.out.println(answers);
//		//return answers;
//		
//		return questionMono;
//	}

}
