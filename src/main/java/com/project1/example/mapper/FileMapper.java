package com.project1.example.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.project1.example.domain.FileVO;


@Mapper
public interface FileMapper {
	public int fileInsert(FileVO file);
	
	public List<FileVO> selectFileList(FileVO file);
}
