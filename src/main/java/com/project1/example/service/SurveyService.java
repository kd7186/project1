package com.project1.example.service;

import java.util.List;

import com.project1.example.domain.Answer;
import com.project1.example.domain.Question;
import com.project1.example.domain.Response;
import com.project1.example.domain.ResultAnswer;
import com.project1.example.domain.Submission;
import com.project1.example.domain.Survey;

public interface SurveyService {
	
	public List<Survey> getsurveylist();

	public void insertSurvey(Survey survey);

	public void insertQuestions(Question q);

	public void insertAnswers(Answer a);

	public Survey getSurveyDetail(int sId);

	public List<Question> getQuestionDetail(int sId);

	public List<Answer> getAnswerDetail(int qId);

	public void insertSubmission(Submission submission);

	public void insertResponse(Response r);

	public void insertReAnswer(String a, int sId, int qId);

	public List<Question> getResultQuestion(int sId);

	public List<String> getResultAnswers(int sId, int qId);

	public List<Integer> getResultAnswersCount(int sId, int qId);

	public void deleteSurvey(int sId);

	public List<Integer> getqId(int sId);

	public void deleteAnswers(int q);

	public void deleteQuestions(int sId);

	public void deleteReAnswers(int sId);

	public void deleteSubmission(int sId);

	public List<Integer> getsubId(int sId);

	public void deleteResponse(int s_);
}
