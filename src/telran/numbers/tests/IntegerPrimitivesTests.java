package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.IntegerPrimitives;

class IntegerPrimitivesTests {

	@Test
	void getMaxByte() {
		assertEquals(Byte.MAX_VALUE, IntegerPrimitives.getMaxByte());
	}
	@Test
	void getMinByte() {
		assertEquals(Byte.MIN_VALUE, IntegerPrimitives.getMinByte());
	}
	@Test
	void getLengthByte() {
		assertEquals(1, IntegerPrimitives.getLengthByte());
	}
	@Test
	void getMaxChar() {
		assertEquals(Character.MAX_VALUE, IntegerPrimitives.getMaxChar());
	}
	@Test
	void getMinChar() {
		assertEquals(Character.MIN_VALUE, IntegerPrimitives.getMinChar());
	}
	@Test
	void getLengthChar() {
		assertEquals(2, IntegerPrimitives.getLengthChar());
	}
	@Test
	void getMaxShort() {
		assertEquals(Short.MAX_VALUE, IntegerPrimitives.getMaxShort());
	}
	@Test
	void getMinShort() {
		assertEquals(Short.MIN_VALUE, IntegerPrimitives.getMinShort());
	}
	@Test
	void getLengthShort() {
		assertEquals(2, IntegerPrimitives.getLengthShort());
	}
	@Test
	void getMaxInt() {
		assertEquals(Integer.MAX_VALUE, IntegerPrimitives.getMaxInt());
	}
	@Test
	void getMinInt() {
		assertEquals(Integer.MIN_VALUE, IntegerPrimitives.getMinInt());
	}
	@Test
	void getLengthInt() {
		assertEquals(4, IntegerPrimitives.getLengthInt());
	}
	@Test
	void getMaxLong() {
		assertEquals(Long.MAX_VALUE, IntegerPrimitives.getMaxLong());
	}
	@Test
	void getMinLong() {
		assertEquals(Long.MIN_VALUE, IntegerPrimitives.getMinLong());
	}
	@Test
	void getLengthLong() {
		assertEquals(8, IntegerPrimitives.getLengthLong());
	}
}
