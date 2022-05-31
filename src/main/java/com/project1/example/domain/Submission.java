package com.project1.example.domain;

import java.util.List;

public class Submission {

	private int subId;
	private int sId;
	private List<Response> questions ;
	private int count;
	
	public int getsubId() {
		return subId;
	}
	public void setsubId(int subId) {
		this.subId = subId;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public List<Response> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Response> questions) {
		this.questions = questions;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}