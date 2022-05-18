package com.project1.example.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private int fId;
	private int bId;
	private MultipartFile multipartFile;
	private String image;
	private String fileName;
	private String fileRealName;
	private String fileUrl;
	private int getNext;
	
	public int getGetNext() {
		return getNext;
	}
	public void setGetNext(int getNext) {
		this.getNext = getNext;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fildUrl) {
		this.fileUrl = fildUrl;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
