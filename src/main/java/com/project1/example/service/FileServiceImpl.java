package com.project1.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.example.domain.FileVO;
import com.project1.example.mapper.FileMapper;

@Service("FileServiceImpl")
public class FileServiceImpl implements FileService {

	@Autowired FileMapper filemapper;
	@Override
	public int fileInsert(FileVO file){
		return filemapper.fileInsert(file);
	}
	
	@Override
	public List<FileVO> selectFileList(FileVO file) {
		return filemapper.selectFileList(file);
	}
}


