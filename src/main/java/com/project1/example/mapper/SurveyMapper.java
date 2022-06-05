package com.project1.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project1.example.domain.Answer;
import com.project1.example.domain.Question;
import com.project1.example.domain.Response;
import com.project1.example.domain.Submission;
import com.project1.example.domain.Survey;

@Mapper
public interface SurveyMapper {
	public List<Survey> getsurveylist();

	public void insertSurvey(Survey survey);

	public void insertQuestions(Question q);

	public void insertAnswers(Answer a);

	public Survey getSurveyDetail(int sId);

	public List<Question> getQuestionDetail(int sId);

	public List<Answer> getAnswerDetail(int qId);

	public void insertSubmission(Submission submission);

	public void insertResponse(Response r);

	public void insertReAnswer(@Param("a")String a, @Param("sId")int sId, @Param("qId")int qId);

	public List<Question> getResultQuestion(int sId);

	public List<String> getResultAnswers(@Param("sId")int sId, @Param("qId")int qId);

	public List<Integer> getResultAnswersCount(@Param("sId")int sId, @Param("qId")int qId);

	public void deleteSurvey(int sId);

	public List<Integer> getqId(int sId);

	public void deleteAnswers(int q);

	public void deleteQuestions(int sId);

	public void deleteReAnswers(int sId);

	public void deleteSubmission(int sId);

	public List<Integer> getsubId(int sId);

	public void deleteResponse(int s_);
}