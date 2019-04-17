package com.biz.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EVO {
	private long id;
	private String from_email;
	private String to_email;
	private String s_subject;
	private String s_content;
}
