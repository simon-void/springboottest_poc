package de.beispiel.code

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.TestConstructor

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class SpringBootTestTest(
    private val restTemplate: TestRestTemplate,
) {
    @LocalServerPort
    private val port = 0

    @Test
    fun greetingShouldReturnDefaultMessage() {
        val content: String? = restTemplate.getForObject("http://localhost:$port/")
        Assertions.assertThat(content).isEqualTo("hello")
    }
}