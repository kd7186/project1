package com.project1.example.domain;

import java.util.List;

public class Question {
	private int sId;
	private int qId;
	private String q;
	private List<Answer> answers;
	private List<String> resultAnswers;
	private List<Integer> resultCount;
	private String t;
	private int rownum;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public List<String> getResultAnswers() {
		return resultAnswers;
	}
	public void setResultAnswers(List<String> resultAnswers) {
		this.resultAnswers = resultAnswers;
	}
	public List<Integer> getResultCount() {
		return resultCount;
	}
	public void setResultCount(List<Integer> resultCount) {
		this.resultCount = resultCount;
	}
}
