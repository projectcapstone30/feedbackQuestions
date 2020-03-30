package com.fmsClient.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
	
	
	private Long q_id;
	private String q_name;
	private Long f_key;

}
