package com.project1.example.domain;

import java.util.List;

public class Response {
	private int rId;
	private int subId;
	private int qId;
	private String t;
	private List<String> answers;
	private int aCount;
	private int getNext;
	
	public int getGetNext() {
		return getNext;
	}
	public void setGetNext(int getNext) {
		this.getNext = getNext;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getsubId() {
		return subId;
	}
	public void setsubId(int subId) {
		this.subId = subId;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public int getaCount() {
		return aCount;
	}
	public void setaCount(int aCount) {
		this.aCount = aCount;
	}
}