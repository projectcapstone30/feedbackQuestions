package com.fms.domain;

import reactor.core.publisher.Flux;

public class QuestionsDTO {
	
	private Long questionId;
	
	private String questionName;
	
	private Flux<AnswersDTO> answersDTO;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Flux<AnswersDTO> getAnswersDTO() {
		return answersDTO;
	}

	public void setAnswersDTO(Flux<AnswersDTO> answersDTO) {
		this.answersDTO = answersDTO;
	}

	public QuestionsDTO(Long questionId, String questionName,
			Flux<AnswersDTO> answersDTO) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.answersDTO = answersDTO;
	}

	public QuestionsDTO() {
		super();
	}
	
	

}
