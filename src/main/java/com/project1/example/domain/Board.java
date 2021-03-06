package com.project1.example.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bDatetime;
	private int bBrdhit;
	private int getNext;
	private int rownum;
	private int bGroup;
	private int bOrder;
	private int bDepth;
	MultipartFile file;
	private String fileName;
	private List<FileVO> files;
	
	public List<FileVO> getFiles() {
		return files;
	}
	public void setFiles(List<FileVO> files) {
		this.files = files;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getGetNext() {
		return getNext;
	}
	public void setGetNext(int getNext) {
		this.getNext = getNext;
	}
	public int getbBrdhit() {
		return bBrdhit;
	}
	public void setbBrdhit(int bBrdhit) {
		this.bBrdhit = bBrdhit;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbDatetime() {
		return bDatetime;
	}
	public void setbDatetime(String bDatetime) {
		this.bDatetime = bDatetime;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbOrder() {
		return bOrder;
	}
	public void setbOrder(int bOrder) {
		this.bOrder = bOrder;
	}
	public int getbDepth() {
		return bDepth;
	}
	public void setbDepth(int bDepth) {
		this.bDepth = bDepth;
	}
}
