package com.question.QuestionService.service.imple;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.service.QuestionServeice;

@Service
public class QuestionServiceImple implements QuestionServeice {
	
	QuestionRepository questionReopsitory;

	public QuestionServiceImple(QuestionRepository questionReopsitory) {
		super();
		this.questionReopsitory = questionReopsitory;
	}

	@Override
	public Question create(Question question) {
		// TODO Auto-generated method stub
		return questionReopsitory.save(question);
	}

	@Override
	public List<Question> get() {
		// TODO Auto-generated method stub
		return questionReopsitory.findAll();
	}

	@Override
	public Question getOne(Long id) {
		// TODO Auto-generated method stub
		return questionReopsitory.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found !!"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return questionReopsitory.findByQuizId(quizId);
//					or
//		return questionReopsitory.findAllById(quizId);
	}
	

}
