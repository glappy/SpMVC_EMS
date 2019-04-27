package com.biz.email.model;

public class MailVO {
	private long id;
    private String from_email ;
    private String to_email;
    private String s_date;
    private String s_time;
    private String s_subject;
    private String s_content;
    private String s_file1;
    private String s_file2;

	public MailVO() {
		super();
	}
	public MailVO(long id, String from_email, String to_email, String s_date, String s_time, String s_subject,
			String s_content, String s_file1, String s_file2) {
		super();
		this.id = id;
		this.from_email = from_email;
		this.to_email = to_email;
		this.s_date = s_date;
		this.s_time = s_time;
		this.s_subject = s_subject;
		this.s_content = s_content;
		this.s_file1 = s_file1;
		this.s_file2 = s_file2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom_email() {
		return from_email;
	}
	public void setFrom_email(String from_email) {
		this.from_email = from_email;
	}
	public String getTo_email() {
		return to_email;
	}
	public void setTo_email(String to_email) {
		this.to_email = to_email;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getS_subject() {
		return s_subject;
	}
	public void setS_subject(String s_subject) {
		this.s_subject = s_subject;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public String getS_file1() {
		return s_file1;
	}
	public void setS_file1(String s_file1) {
		this.s_file1 = s_file1;
	}
	public String getS_file2() {
		return s_file2;
	}
	public void setS_file2(String s_file2) {
		this.s_file2 = s_file2;
	}
	@Override
	public String toString() {
		return "MailVO [id=" + id + ", from_email=" + from_email + ", to_email=" + to_email + ", s_date=" + s_date
				+ ", s_time=" + s_time + ", s_subject=" + s_subject + ", s_content=" + s_content + ", s_file1="
				+ s_file1 + ", s_file2=" + s_file2 + "]";
	}
}
