package com.project1.example.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project1.example.domain.Board;
import com.project1.example.domain.Pagination;
import com.project1.example.domain.Search;
import com.project1.example.service.BoardService;
import com.project1.example.service.CommentService;
import com.project1.example.service.FileService;
import com.project1.example.domain.Comment;
import com.project1.example.domain.FileVO;
import com.project1.example.config.JwtUtils;
import com.project1.example.domain.User;
import com.project1.example.domain.UserInfo;
import com.project1.example.response.JwtResponse;
import com.project1.example.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardService boardservice;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	FileService fileservice;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentService commentservice;
	
	@GetMapping("/board")
	public ResponseEntity<?> home(Model model,Authentication authentication,Search search,@PathVariable(required = false) Optional<Integer> optPage) {
		int page = optPage.isPresent() ? optPage.get() : 1;
		
		int count = 0;
		Pagination pagination = new Pagination();
		/*search = new Search();
		search.setFind(request.getParameter("find"));
		search.setSearch(request.getParameter("search"));*/
		count = boardservice.boardCount(search);
		pagination.setPage(page);
		pagination.setCount(count);
		pagination.setSearch(search);
		pagination.init();
		List<Board> boardlist = boardservice.selectBoardList(pagination);
		model.addAttribute("list", boardlist);
		model.addAttribute("pageNum",pagination.getPageNum());
		model.addAttribute("pagination",pagination);
		logger.debug("debug");
	    logger.info("info");
	    logger.error("error");
		return new ResponseEntity<>(boardlist, HttpStatus.OK);
	}
	
	@GetMapping("/article")
	public ResponseEntity<?> article(Board board, Model model) {
		Board article = boardservice.article(board.getbId());
		model.addAttribute("article", article);
		boardservice.countView(board.getbId());
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	/* @GetMapping("/write")
	public ResponseEntity<?> write(Model model){
		return new ResponseEntity<>(HttpStatus.OK);
	} */
	
	@RequestMapping(value="/writeaction", method=RequestMethod.POST)
	public ResponseEntity<?> writeaction(Board board, Authentication authentication) {
		MultipartFile multipartFile = board.getFile();
		User user = (User) authentication.getPrincipal();
		board.setbWriter(user.getName());
		FileVO file = new FileVO();
		/*
		if(f == null) {
		boardservice.writeAction(board);
		} else {
		boardservice.writeAction(board);
		String fileName = f.getOriginalFilename();
		String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:/Users/l6-morning/Documents/work12/lcomputerstudy/src/main/resources/static/img/";
		do {
			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
			destinationFile = new File(fileUrl+ destinationFileName);
		} while (destinationFile.exists());
		destinationFile.getParentFile().mkdirs();
		f.transferTo(destinationFile);
		file.setFileName(destinationFileName);
		file.setFileRealName(fileName);
		file.setFileUrl(fileUrl);
		fileservice.fileInsert(file);}*/
		
		return new ResponseEntity<>(board,HttpStatus.OK);
		}
}

