package com.question.QuestionService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.service.QuestionServeice;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionServeice questionService;
	
	public QuestionController(QuestionServeice questionService) {
		super();
		this.questionService = questionService;
	}

	@PostMapping
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}
	
	@GetMapping
	public List<Question> getAll(){
		return questionService.get();
			
	}
	@GetMapping("/{questionId}")
	public Question get(@PathVariable Long questionId){
		return questionService.getOne(questionId);
			
	}
	//get all quesion of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
		return questionService.getQuestionsOfQuiz(quizId);
	}
	
}
