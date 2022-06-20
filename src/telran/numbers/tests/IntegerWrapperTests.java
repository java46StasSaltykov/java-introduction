package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntegerWrapperTests {

	@Test
	void expressionSmallNumbers() {
		Integer expression = 200 / 100 + 80;
		Integer expected = 82;
		assertTrue(expected == expression);
	}
	@Test
	void expressionBigNumbers() {
		Integer expression = 5000 / 5 + 800;
		Integer expected = 1800;
		assertEquals(expected, expression);
	}

}
