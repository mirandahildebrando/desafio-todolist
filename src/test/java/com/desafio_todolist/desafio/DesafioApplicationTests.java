package com.desafio_todolist.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import com.desafio_todolist.desafio.entity.Todo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
			.expectBody()
			.jsonPath("$.name").isArray()
			.jsonPath(".length()").isEqualTo(1)
			.jsonPath("$.name[0]").isEqualTo(todo.getName)
			.jsonPath("$.descricao[0]").isEqualTo(todo.getDescricao())
			.jsonPath("$.realizado[0]").isEqualTo(todo.isRealizado())
			.jsonPath("$.prioridade[0]").isEqualTo(todo.getPrioridade());

	}

	@Test
	void testCreateTodoFailure() {
		webTestClient.post()
			.uri("/todos")
			.bodyValue(new Todo())
			.exchange()
			.expectStatus().isBadRequest()
			.expectBody()
			.jsonPath("$.name").isArray()
			.jsonPath("$.descricao").isArray()
			.jsonPath("$.realizado").isArray()
			.jsonPath("$.prioridade").isArray();
	}

}
