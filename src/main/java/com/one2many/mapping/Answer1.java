package com.one2many.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Answer1 {

	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	 @ManyToOne
	//@JoinColumn(name = "ques_id")
	private Question1 question;
	
	public Question1 getQuestion() {
		return question;
	}
	public void setQuestion(Question1 question) {
		this.question = question;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer1(int answerId, String answer, Question1 question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + ", question=" + question + "]";
	}
		
	
}
