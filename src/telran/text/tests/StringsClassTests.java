package telran.text.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.text.Strings;

class StringsClassTests {

	@Test
	void deepCompareTest() {
		String str1 = "123,tT89";
		String str2 = "123,tT89";
		String str3 = "19";
		String str4 = "kugy";
		String str5 = "98Tt,321";
		int expected1[] = {8, 0};
		int expected2[] = {1, 1};
		int expected3[] = {0, 8};
		int expected4[] = {0, 0};
		assertArrayEquals(expected1, Strings.deepNoRepeatedCompare(str1, str2));
		assertArrayEquals(expected2, Strings.deepNoRepeatedCompare(str1, str3));
		assertArrayEquals(expected3, Strings.deepNoRepeatedCompare(str1, str5));
		assertArrayEquals(expected4, Strings.deepNoRepeatedCompare(str1, str4));
	}
	
	@Test
	void isAnagramTests() {
		String str1 = "Hello";
		String str2 = "Helll";
		String str3 = "eloHl";
		String str4 = "Hel";
		assertTrue(Strings.isAnagram(str1, str3));
		assertFalse(Strings.isAnagram(str1, str2));
		assertFalse(Strings.isAnagram(str1, str4));
		assertTrue(Strings.isAnagram(str1, str1));
	}
	
	@Test
	void joinTest() {
		String array[] = {"Hello", "Vasya"};
		String expected = "Hello Vasya";
		assertEquals(expected, Strings.join(array, " "));
	}
	
	private static final int N_RUNS = 10000;
	private static final int N_STRINGS = 100;
	
	@Test
	void joinPerformanceTest() {
		String array[] = getBigArray();
		for (int i = 0; i < N_RUNS; i++) {
			Strings.join(array, " ");
		}
	}

	private String[] getBigArray() {
		String res[] = new String[N_STRINGS];
		for (int i = 0; i < res.length; i++) {
			res[i] = "Hello";
		}
		return res;
	}
	
	@Test
	void matchesTest() {
		//TODO
		String str1 = "David";
		String str2 = "david";
		String str3 = "John F";
		String str4 = "John Fitzgerald";
		String str5 = "Anna Maria Magdalena";
		String str6 = "Anna Magdalena";
		String str7 = "John K";
		String str8 = "Anna Maria Roberta";
		String str9 = "Anna Magdalena Roberta";
		String str10 = "Anna Magdalena Maria";
		String str11 = "Maria Magdalena";
		assertEquals("match", Strings.matches(str1, str2));
		assertEquals("match", Strings.matches(str3, str4));
		assertEquals("no match", Strings.matches(str7, str4));
		assertEquals("match", Strings.matches(str5, str6));
		assertEquals("no match", Strings.matches(str5, str8));
		assertEquals("match", Strings.matches(str5, str11));
		assertEquals("no match", Strings.matches(str5, str9));
		assertEquals("no match", Strings.matches(str5, str10));
	}
	
	@Test
	void sortStringsAsNumbersTest() {
		//TODO
		String ar1[] = {"12", "2", "18", "108", "92"};
		String expected[] = {"2", "12", "18", "92", "108"};
		assertArrayEquals(expected, Strings.sortStringsAsNumbers(ar1));
	}
	
}



















