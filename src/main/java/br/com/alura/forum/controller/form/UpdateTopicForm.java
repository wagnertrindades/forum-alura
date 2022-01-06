package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.TopicRepository;

public class UpdateTopicForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;

	
	public String getTitulo() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Topic update(Long id, TopicRepository topicRepository) {
		Topic topic = topicRepository.getById(id);
		
		topic.setTitle(this.title);
		topic.setMessage(this.message);
		
		return topic;
	}

}
