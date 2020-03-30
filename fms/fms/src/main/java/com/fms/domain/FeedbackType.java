package com.fms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackType {
	
	@Id
	private Long f_key;
	private String f_type;
	
	public FeedbackType() {
		super();
	}
	public FeedbackType(Long f_key, String f_type) {
		super();
		this.f_key = f_key;
		this.f_type = f_type;
	}
	public Long getF_key() {
		return f_key;
	}
	public void setF_key(Long f_key) {
		this.f_key = f_key;
	}
	public String getF_type() {
		return f_type;
	}
	public void setF_type(String f_type) {
		this.f_type = f_type;
	}
	
}
