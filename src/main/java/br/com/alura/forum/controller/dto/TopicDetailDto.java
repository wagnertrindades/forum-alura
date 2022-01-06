package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.forum.model.TopicStatus;
import br.com.alura.forum.model.Topic;

public class TopicDetailDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;
	private String autorName;
	private TopicStatus status;
	private List<AnswerDto> answers;
	
	public TopicDetailDto(Topic topico) {
		this.id = topico.getId();
		this.title = topico.getTitle();
		this.message = topico.getMessage();
		this.creationDate = topico.getCreationDate();
		this.autorName = topico.getAutor().getName();
		this.status = topico.getStatus();
		this.answers = AnswerDto.converter(topico.getAnswers());
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
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

	public TopicStatus getStatus() {
		return status;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}
}
