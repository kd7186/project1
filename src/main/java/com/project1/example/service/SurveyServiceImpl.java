package com.project1.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.example.domain.Answer;
import com.project1.example.domain.Question;
import com.project1.example.domain.Response;
import com.project1.example.domain.ResultAnswer;
import com.project1.example.domain.Submission;
import com.project1.example.domain.Survey;
import com.project1.example.mapper.SurveyMapper;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired SurveyMapper surveymapper;
	
	@Override
	public List<Survey> getsurveylist() {
		return surveymapper.getsurveylist();
	}

	@Override
	public void insertSurvey(Survey survey) {
		surveymapper.insertSurvey(survey);
		
	}

	@Override
	public void insertQuestions(Question q) {
		surveymapper.insertQuestions(q);
		
	}

	@Override
	public void insertAnswers(Answer a) {
		surveymapper.insertAnswers(a);
		
	}

	@Override
	public Survey getSurveyDetail(int sId) {
		// TODO Auto-generated method stub
		return surveymapper.getSurveyDetail(sId);
	}

	@Override
	public List<Question> getQuestionDetail(int sId) {
		// TODO Auto-generated method stub
		return surveymapper.getQuestionDetail(sId);
	}

	@Override
	public List<Answer> getAnswerDetail(int qId) {
		// TODO Auto-generated method stub
		return surveymapper.getAnswerDetail(qId);
	}

	@Override
	public void insertSubmission(Submission submission) {
		surveymapper.insertSubmission(submission);
		
	}

	@Override
	public void insertResponse(Response r) {
		surveymapper.insertResponse(r);
		
	}

	@Override
	public void insertReAnswer(@Param("a")String a, @Param("sId")int sId, @Param("qId")int qId) {
		surveymapper.insertReAnswer(a, sId, qId);
		
	}

	@Override
	public List<Question> getResultQuestion(int sId) {
		// TODO Auto-generated method stub
		return surveymapper.getResultQuestion(sId);
	}

	@Override
	public List<String> getResultAnswers(@Param("sId")int sId, @Param("qId")int qId) {
		// TODO Auto-generated method stub
		return surveymapper.getResultAnswers(sId, qId);
	}

	@Override
	public List<Integer> getResultAnswersCount(@Param("sId")int sId, @Param("qId")int qId) {
		// TODO Auto-generated method stub
		return surveymapper.getResultAnswersCount(sId, qId);
	}

	@Override
	public void deleteSurvey(int sId) {
		surveymapper.deleteSurvey(sId);
		
	}

	@Override
	public List<Integer> getqId(int sId) {
		// TODO Auto-generated method stub
		return surveymapper.getqId(sId);
	}

	@Override
	public void deleteAnswers(int q) {
		surveymapper.deleteAnswers(q);
		
	}

	@Override
	public void deleteQuestions(int sId) {
		surveymapper.deleteQuestions(sId);
		
	}

	@Override
	public void deleteReAnswers(int sId) {
		surveymapper.deleteReAnswers(sId);
		
	}

	@Override
	public void deleteSubmission(int sId) {
		surveymapper.deleteSubmission(sId);
		
	}

	@Override
	public List<Integer> getsubId(int sId) {
		// TODO Auto-generated method stub
		return surveymapper.getsubId(sId);
	}

	@Override
	public void deleteResponse(int s_) {
		surveymapper.deleteResponse(s_);
		
	}
}
