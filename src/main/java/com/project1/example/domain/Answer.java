package com.project1.example.domain;

public class Answer {
	private String answer;
	private int qId;
	private int aId;
	private int aCount;

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int a_num) {
		this.aId = aId;
	}
	public int getaCount() {
		return aCount;
	}
	public void setaCount(int aCount) {
		this.aCount = aCount;
	}
}