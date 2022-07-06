package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringsStandardTests {

	@Test
	void stringArraysTest() {
		String strEnglish = "hello";
		String strHebrew = "שלום";
		char arCh[] = {'h', 'e', 'l', 'l', 'o'};
		byte arBytes[] = {'h', 'e', 'l', 'l', 'o'};
		assertArrayEquals(arCh, strEnglish.toCharArray());
		assertArrayEquals(arBytes, strEnglish.getBytes());
		assertEquals(5, strEnglish.getBytes().length);
		assertEquals(4, strHebrew.toCharArray().length);
		assertEquals(8, strHebrew.getBytes().length);
	}
	
	@Test
	void equalsStrings() {
		String str1 = "Hello";//Java creates new array of chars and str1 is reference to the array
		String str2 = "Hello";//Java recognises array of chars existence and puts reference to the the array
		String str3 = new String("Hello");//Java creates new array and fills it with existed array
		assertTrue(str1 == str2);
		assertFalse(str1 == str3);
		assertTrue(str1.equals(str3));
		assertEquals(str1, str3);
	}
	
	@Test
	void comparingStrings() {
		String str1 = "123456789";
		String str2 = "ab";
		String str3 = "Ab";
		String str4 = "aB";
		assertTrue(str1.compareTo(str2) < 0);
		assertEquals('1' - 'a', str1.compareTo(str2));
		assertTrue(str2.compareTo(str3) > 0);
		assertEquals(0, str2.compareToIgnoreCase(str4));
		assertEquals(0, str2.compareTo(str4.toLowerCase()));
		
	}
	
	@Test
	void indexOfTest() {
		String str = "Hello";
		assertEquals(2, str.indexOf('l'));
		assertEquals(3, str.lastIndexOf('l'));
		assertEquals(-1, str.indexOf('w'));
	}
	
	@Test
	void formatTest() {
		String strExpected = "a=5";
		int b = 10;
		assertEquals(strExpected, String.format("a=%d", b / 2));
	}
	@Test
	void replaceTest() {
		String str = "Hello";
//		str = str.concat(" Vasya");
		str = str.replace("ello", "allo");
		assertEquals("Hallo", str);
		StringBuilder strBuilder = new StringBuilder("Hello");
		strBuilder.replace(1, 5, "allo");
		assertEquals("Hallo", strBuilder.toString());
	}

}






