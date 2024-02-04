package com.quiz.QuizService.services.imple;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class QuizServiceImple implements QuizService {

	private QuizRepository quizRepository;

	private QuestionClient questionClient;

	public QuizServiceImple(QuizRepository quizRepository, QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = quizRepository.findAll();
		List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
	Quiz quiz	 = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
	quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));	
	return quiz;
	}

}
