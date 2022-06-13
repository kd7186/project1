package com.project1.example.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project1.example.domain.Board;
import com.project1.example.domain.FileVO;
import com.project1.example.domain.Pagination;
import com.project1.example.domain.Search;
import com.project1.example.domain.Survey;
import com.project1.example.service.BoardService;
import com.project1.example.service.CommentService;
import com.project1.example.service.FileService;
import com.project1.example.config.JwtUtils;
import com.project1.example.domain.User;
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
	public ResponseEntity<?> getBoardList(HttpServletRequest request) {

		List<Board> list = boardservice.selectBoardList();
		
			return new ResponseEntity<>(list, HttpStatus.OK);
	}
	 
	@GetMapping("/article")
	public ResponseEntity<?> article(@Validated int bId,FileVO filevo) {
		Board board = boardservice.article(bId);
		List<FileVO> file = fileservice.selectFileList(filevo);
		boardservice.countView(board.getbId());
		
		Board article = new Board();
		article.setbId(board.getbId());
		article.setbTitle(board.getbTitle());
		article.setbContent(board.getbContent());
		article.setbWriter(board.getbWriter());
		article.setbDatetime(board.getbDatetime());
		article.setbBrdhit(board.getbBrdhit());
		article.setFiles(file);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	/* @GetMapping("/write")
	public ResponseEntity<?> write(Model model){
		return new ResponseEntity<>(HttpStatus.OK);
	} */
	
	@PostMapping("/writeaction")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> writeaction(HttpServletRequest request, Board board, MultipartFile[] file) throws Exception{
		String token = new String();
		token = request.getHeader("Authorization");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			token = token.substring(7, token.length());
		}
		String username = jwtUtils.getUserEmailFromToken(token);
		board.setbWriter(username);
		FileVO filevo = new FileVO();
		if(file == null) {
			boardservice.writeAction(board);
		} else {
			boardservice.writeAction(board);
			for(MultipartFile f:file) {
				String fileName = f.getOriginalFilename();
				String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
				File destinationFile;
				String destinationFileName;
				/* String fileUrl = "C:/Users/l6-morning/Documents/work12/project1/src/project1/public/img"; */
				String fileUrl = "C:/Users/ruist/OneDrive/¹®¼­/GitHub/project1/src/project1/public/img";
				do {
					destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
					destinationFile = new File(fileUrl+ destinationFileName);
				} while (destinationFile.exists());
				destinationFile.getParentFile().mkdirs();
				f.transferTo(destinationFile);
				filevo.setFileName(destinationFileName);
				filevo.setFileRealName(fileName);
				filevo.setFileUrl(fileUrl);
				fileservice.fileInsert(filevo);}}
	
		List<Board> list = boardservice.selectBoardList();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}

