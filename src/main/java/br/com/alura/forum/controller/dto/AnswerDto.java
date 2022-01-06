package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Answer;

public class AnswerDto {
	
	private Long id;
	private String message;
	private LocalDateTime creationDate;
	private String autorName;
	
	public AnswerDto(Answer answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.creationDate = answer.getCreationDate();
		this.autorName = answer.getAutor().getName();
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getAutorName() {
		return autorName;
	}
	
	public static List<AnswerDto> converter(List<Answer> answers) {
		return answers.stream().map(AnswerDto::new).collect(Collectors.toList());
	}
}
