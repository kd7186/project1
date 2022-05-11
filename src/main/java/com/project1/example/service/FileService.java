package com.project1.example.service;

import java.util.List;

import com.project1.example.domain.FileVO;

public interface FileService {
	public int fileInsert(FileVO file);
	
	public List<FileVO> selectFileList(FileVO file);
}
