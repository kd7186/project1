package com.project1.example.domain;

import java.util.List;

public class Survey {
	private String sTitle;
	private String sDescription;
	private	List<Question> questions;
	private int s_num;
	private String writer;
	private String datetime;
	private int hit;
	private int rownum;
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
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
	public String getWriter() {
		return writer;
	}
<<<<<<< HEAD
	public void setsWriter(String sWriter) {
		this.sWriter = sWriter;
=======
	public void setWriter(String writer) {
		this.writer = writer;
>>>>>>> 9bf10372e3161f9773e7a4fe3c69c0530787f956
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

}
}
