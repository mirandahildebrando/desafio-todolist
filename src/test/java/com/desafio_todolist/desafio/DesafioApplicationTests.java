package com.desafio_todolist.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.desafio_todolist.desafio.entity.Todo;

@SpringBootTest
class DesafioApplicationTests {
 
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 1);

		webTestClient.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBodyList(Todo.class)
			.hasSize(1)
			.contains(todo);
	}

	@Test
	void testCreateTodoFailure() {
	}

}
