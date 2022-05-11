package com.project1.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> article(Model model, Authentication authentication,Board board) {
		Board article = boardservice.article(board);
		model.addAttribute("article", article);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
}

