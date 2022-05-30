package com.project1.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.example.config.JwtUtils;
import com.project1.example.domain.Answer;
import com.project1.example.domain.Question;
import com.project1.example.domain.Survey;
import com.project1.example.service.SurveyService;
import com.project1.example.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SurveyController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SurveyService surveyService;
	
	@GetMapping("/surveylist")
	public ResponseEntity<?> getSurveyList(HttpServletRequest request) {

		List<Survey> list = surveyService.getsurveylist();
		
			return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/survey")
	public ResponseEntity<?> writeSurvey(HttpServletRequest request, @Validated @RequestBody Survey survey ) {
		
		String token = new String();
		token = request.getHeader("Authorization");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			token = token.substring(7, token.length());
		}
		String username = jwtUtils.getUserEmailFromToken(token);
		
		survey.setWriter(username);
		surveyService.insertSurvey(survey);
		for(Question q : survey.getQuestions()) {
			surveyService.insertQuestions(q);
			if(q.getAnswers().size() != 0) {
				for(Answer a: q.getAnswers()) {
					surveyService.insertAnswers(a);
				}
			}
		}
		
		List<Survey> list = surveyService.getsurveylist();
			
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
}
