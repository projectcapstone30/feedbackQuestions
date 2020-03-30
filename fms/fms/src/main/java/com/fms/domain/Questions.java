package com.fms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
	
	@Id
	private Long q_id;
	private String q_name;
	private Long f_key;
	
	public Questions() {
		super();
	}
	public Questions(Long q_id, String q_name, Long f_key) {
		super();
		this.q_id = q_id;
		this.q_name = q_name;
		this.f_key = f_key;
	}
	
//	public Questions(int q_id, String q_name, FeedbackType feedbackType) {
//	super();
//	this.q_id = q_id;
//	this.q_name = q_name;
//	this.feedbackType = feedbackType;
//}
	public Long getQ_id() {
		return q_id;
	}
//	public FeedbackType getFeedbackType() {
//		return feedbackType;
//	}
//	public void setFeedbackType(FeedbackType feedbackType) {
//		this.feedbackType = feedbackType;
//	}
	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public Long getF_key() {
		return f_key;
	}
	public void setF_key(Long f_key) {
		this.f_key = f_key;
	}
	
	
//	private FeedbackType feedbackType;

}
