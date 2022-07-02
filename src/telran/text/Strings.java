package telran.text;

import java.util.Arrays;

import org.junit.platform.commons.util.StringUtils;

public class Strings {
	/**
	 * 
	 * @param str1 ascii string with no repeated symbols
	 * @param str2 ascii string with no repeated symbols
	 * @return array with two numbers
	 * 		first - number of the symbols of the str2 that exist in str1 at the same indexes
	 * 		second - number of the symbols of the str2 that exist in str1 at different indexes
	 */
	public static int[] deepNoRepeatedCompare(String str1, String str2) {
		int res[] = new int[2];
		int a = 0;
		int b = 0;
		
		// Implementation #1:
		
		int ar[] = new int[127];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = -1;
		}
		for (int i = 0; i < str1.length(); i++) {
			ar[str1.charAt(i)] = i;
		}
		
		int ar1[] = new int[127];
		for (int i = 0; i < ar1.length; i++) {
			ar1[i] = -1;
		}
		for (int i = 0; i < str2.length(); i++) {
			ar1[str2.charAt(i)] = i;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			if (ar1[str2.charAt(i)] == ar[str1.charAt(i)] && str2.charAt(i) == str1.charAt(i)) {
				a++;
			}
			for (int j = 0; j < str1.length(); j++) {
				if (ar1[str2.charAt(i)] != ar[str1.charAt(j)] && str2.charAt(i) == str1.charAt(j)) {
					b++;
				}
			}
		}
		
		// Implementation #2:
		
//		for (int i = 0; i < str2.length(); i++) {
//			if (str2.charAt(i) == str1.charAt(i) && str2.indexOf(str2.charAt(i)) == str1.indexOf(str1.charAt(i))) {
//				a++;
//			} 
//			for (int j = 0; j < str1.length(); j++) {
//				if (str2.charAt(i) == str1.charAt(j) && str2.indexOf(str2.charAt(i)) != str1.indexOf(str1.charAt(j))) {
//					b++;
//				}
//			}
//		}
		
		res[0] = a;
		res[1] = b;
		return res;
	}
	
	/**
	 * 
	 * @param str1 English letters (may have repeats)
	 * @param str2 English letters (may have repeats)
	 * @return true if:
	 * 		(1) str2 has the same as the str1 length
	 * 		(2) str2 comprises of all letters from str1
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean anagram = false;
		boolean length = false;
		boolean letters = false;
		if (str1.length() == str2.length()) {
			length = true;
			int[] ar1 = buildArrayOfCounts(str1);
			int[] ar2 = buildArrayOfCounts(str2);
			for (int i = 0; i < ar1.length; i++) {
				if (ar1[i] == ar2[i]) {
					letters = true;
				} else {
					return anagram;
				}
			}
		}
		
		if (length && letters) {
			anagram = true;
		}
		
		return anagram;
	}
	
	static int[] buildArrayOfCounts(String str) {
		int ar[] = new int[127];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = -1;
		}
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for(int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
				ar[str.charAt(i)] = count;
			}
		}
		return ar;
	}
	
}
