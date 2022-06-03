package com.project1.example.response;

import java.util.List;

import com.project1.example.domain.Question;

public class StatisticsResponse {

	private int sId;
	private List<Question> questions;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	
}