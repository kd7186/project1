package com.project1.example.domain;

import java.util.List;

public class Survey {
	private String sTitle;
	private String sDescription;
	private	List<Question> questions;
	private int sId;
	private String sWriter;
	private String sDatetime;
	private int rownum;
	private int getNext;
	
	public int getGetNext() {
		return getNext;
	}
	public void setGetNext(int getNext) {
		this.getNext = getNext;
	}
	public String getsTitle() {
		return sTitle;
	}
	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsWriter() {
		return sWriter;
	}
	public void setsWriter(String sWriter) {
		this.sWriter = sWriter;
	}
	public String getsDatetime() {
		return sDatetime;
	}
	public void setsDatetime(String sDatetime) {
		this.sDatetime = sDatetime;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

}

