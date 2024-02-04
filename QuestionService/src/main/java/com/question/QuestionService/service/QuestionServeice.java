package com.question.QuestionService.service;

import java.util.List;

import com.question.QuestionService.entities.Question;

public interface QuestionServeice {
	Question create(Question question);
	List<Question> get();
	Question getOne(Long id);
	List<Question> getQuestionsOfQuiz(Long quizId);
}
