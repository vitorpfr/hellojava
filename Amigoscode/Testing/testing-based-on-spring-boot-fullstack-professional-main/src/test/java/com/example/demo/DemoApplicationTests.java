package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTests {

	Calculator underTest = new Calculator();

	// @Test is a required annotation from JUnit: asserts that this method is a test method
	@Test
	void itShouldAddTwoNumbers() {
		// BDD test style approach: given-when-then
		// given
		int numberOne = 20;
		int numberTwo = 30;

		// when
		int result = underTest.add(numberOne, numberTwo);

		// then (using assertJ library)
		assertThat(result).isEqualTo(50);

		// other option: use JUnit default assertion class
		assertEquals(50, result);
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
