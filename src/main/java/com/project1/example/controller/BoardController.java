package com.project1.example.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project1.example.domain.Board;
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
	
	/* @GetMapping("/board")
	public ResponseEntity<?> home(Model model,Authentication authentication,Search search,@PathVariable(required = false) Optional<Integer> optPage) {
		int page = optPage.isPresent() ? optPage.get() : 1;
		
		int count = 0;
		Pagination pagination = new Pagination();
		/*search = new Search();
		search.setFind(request.getParameter("find"));
		search.setSearch(request.getParameter("search"));
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
	} */
	
	@GetMapping("/board")
	public ResponseEntity<?> getBoardList(HttpServletRequest request) {

		List<Board> list = boardservice.selectBoardList();
		
			return new ResponseEntity<>(list, HttpStatus.OK);
	}
	 
	@GetMapping("/article")
	public ResponseEntity<?> article(@Validated int bId) {
		Board board = boardservice.article(bId);
		boardservice.countView(board.getbId());
		
		Board article = new Board();
		article.setbId(board.getbId());
		article.setbTitle(board.getbTitle());
		article.setbContent(board.getbContent());
		article.setbWriter(board.getbWriter());
		article.setbDatetime(board.getbDatetime());
		article.setbBrdhit(board.getbBrdhit());
		
		
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	/* @GetMapping("/write")
	public ResponseEntity<?> write(Model model){
		return new ResponseEntity<>(HttpStatus.OK);
	} */
	
	@PostMapping("/writeaction")
	public ResponseEntity<?> writeaction(Board board, Authentication authentication) {
		List<MultipartFile> multipartFile = board.getFile();
		/* String filename = multipartFile.getOriginalFilename();
		/*MultipartFile multipartFile = board.getFile();
		User user = (User) authentication.getPrincipal();
		board.setbWriter(user.getName());*/
		//FileVO file = new FileVO();
		/*
		if(f == null) { */
		//boardservice.writeAction(board);
		/* } else {
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

