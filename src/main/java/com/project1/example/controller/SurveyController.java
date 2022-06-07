package com.project1.example.controller;


import java.util.List;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.example.domain.Answer;
import com.project1.example.domain.Board;
import com.project1.example.domain.Pagination;
import com.project1.example.domain.Question;
import com.project1.example.domain.Response;
import com.project1.example.domain.Search;
import com.project1.example.domain.Submission;
import com.project1.example.domain.Survey;
import com.project1.example.service.BoardService;
import com.project1.example.service.CommentService;
import com.project1.example.service.FileService;
import com.project1.example.service.SurveyService;
import com.project1.example.config.JwtUtils;
import com.project1.example.domain.User;
import com.project1.example.response.StatisticsResponse;
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
	
	@Autowired
	ServletContext context;
	
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
		
		survey.setsWriter(username);
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

	@GetMapping("/survey")
	public ResponseEntity<?> getSurveyDetail(@Validated int sId) {
		
		Survey survey = surveyService.getSurveyDetail(sId);
		List<Question> questions = surveyService.getQuestionDetail(sId);
		for(Question q : questions) {
			int qId = q.getqId();
			List<Answer> answers = surveyService.getAnswerDetail(qId);
			q.setAnswers(answers);
		}
		
		Survey surveyDetail = new Survey();
		surveyDetail.setsId(survey.getsId());
		surveyDetail.setsTitle(survey.getsTitle());
		surveyDetail.setsDescription(survey.getsDescription());
		surveyDetail.setsWriter(survey.getsWriter());
		surveyDetail.setsDatetime(survey.getsDatetime());
		surveyDetail.setQuestions(questions);

		return new ResponseEntity<>(surveyDetail, HttpStatus.OK);
	}
	
	@PostMapping("/survey-answers")
	public ResponseEntity<?> submitSurveyAnswers(@Validated @RequestBody Submission submission ) {
		

		surveyService.insertSubmission(submission);
		for(Response r : submission.getQuestions()) {
			surveyService.insertResponse(r);
			for(String a: r.getAnswers()) {
				if(a != null)
					surveyService.insertReAnswer(a, submission.getsId(), r.getqId());
			}
		}
		
			
		return new ResponseEntity<>("ok", HttpStatus.OK);
		
	}
	
	@GetMapping("/survey-answers")
	public ResponseEntity<?> getSurveyAnswers(@Validated int sId ) {
		

		StatisticsResponse result = new StatisticsResponse();
		result.setsId(sId);
		List<Question> q_ = surveyService.getResultQuestion(sId);
		for(Question q : q_) {
			List<String> a = surveyService.getResultAnswers(sId, q.getqId());
			List<Integer> aCount = surveyService.getResultAnswersCount(sId, q.getqId());
			q.setResultAnswers(a);
			q.setResultCount(aCount);
		}
		result.setQuestions(q_);
			
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/survey")
	public ResponseEntity<?> deleteSurvey(HttpServletRequest request, @Validated int sId ) {
		String token = new String();
		token = request.getHeader("Authorization");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			token = token.substring(7, token.length());
		}
		String username = jwtUtils.getUserEmailFromToken(token);
		
		Survey s = surveyService.getSurveyDetail(sId);
		if(s.getsWriter().equals(username) || request.isUserInRole("ROLE_ADMIN")) {

			surveyService.deleteSurvey(sId);
			
			List<Survey> list = surveyService.getsurveylist();
			
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		}
		
		else return new ResponseEntity<>("fail", HttpStatus.FORBIDDEN);
	
	}
}
