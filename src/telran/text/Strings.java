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
	
	public static String join(String[] array, String delimiter) {
		//String "+" operator based solution
		return stringPluseSolution(array, delimiter);
		//StringBuilder atted based solution
		//return stringBuilderSolution(array, delimiter);
	}

	private static String stringBuilderSolution(String[] array, String delimiter) {
		StringBuilder strBuilder = new StringBuilder(array[0]);
		for (int i = 1; i < array.length; i++) {
			strBuilder.append(delimiter).append(array[i]);
		}
		return strBuilder.toString();
	}
	
	private static String stringPluseSolution(String[] array, String delimiter) {
		String res = array[0]; //assumption there is at least one string
		for (int i = 1; i < array.length; i++) {
			res += delimiter + array[i];
		}
		return res;
	}
	
	/**
	 * 
	 * @param name1 - first name 
	 * @param name2 - second name
	 * @return either "match" or "no match" in accordance to the comments (see todo)
	 */
	public static String matches(String name1, String name2) {
		String nameAr1[] = name1.split(" ");
		String nameAr2[] = name2.split(" ");

		if (nameAr1.length == 1 && nameAr2.length == 1) {
			int compareRes = nameAr1[0].compareToIgnoreCase(nameAr2[0]);
			if (compareRes == 0) {
				return "match";
			} else {
				return "no match";
			}
		}

		if (nameAr1[0].toLowerCase().equals(nameAr2[0].toLowerCase()) && nameAr1[1].charAt(0) == nameAr2[1].charAt(0) && 
				(nameAr1[1].length() == 1 || nameAr2[1].length() == 1)) {
			return "match";
		}
		
		if (nameAr1.length == nameAr2.length) {
			for (int i = 0; i < nameAr1.length; i++) {
				int count = 0;
				if (nameAr1[i].toLowerCase().equals(nameAr2[i].toLowerCase())) {
					count++;
				}
				if (count == 3) {
					return "match"; 
				}
			}
		} else {
			if (nameAr1[nameAr1.length - 1].toLowerCase().equals(nameAr2[nameAr2.length - 1].toLowerCase())) {
				for (int i = 0; i < nameAr1.length - 1; i++) {
					for (int j = 0; j < nameAr2.length - 1; j++) {
						if (nameAr1[i].equals(nameAr2[j])) {
							return "match";
						}
					}
				}
			}
		}
		
		return "no match";
	}
	
	/**
	 * sorts array of strings
	 * @param strNumbers array of strings containing the integer numbers
	 * length of each string can not be more than three symbols
	 * String containing "123" should be greater than the string containing "23" as the number 123 is greater than 23
	 */
	public static String[] sortStringsAsNumbers(String[] strNumbers) {
		int strToInt[] = new int[strNumbers.length];
		for (int i = 0; i < strToInt.length; i++) {
			strToInt[i] = Integer.parseInt(strNumbers[i]);
		}
		int maxValue = findMax(strToInt);
		int helper[] = new int[maxValue + 1];
		for (int i = 0; i < strToInt.length; i++) {
			int count = 0;
			for(int j = 0; j < strToInt.length; j++) {
				if (strToInt[i] == strToInt[j]) {
					count++;
				}
				helper[strToInt[i]] = count;
			}
		}
		String res[] = new String[helper.length];
		for (int i = 0; i < helper.length; i++) {
			if (helper[i] != 0) {
				res[i] = String.valueOf(i);
			}
		}
		return res;
	}

	private static int findMax(int[] array) {
		int largest = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
		} 
		return largest;
	}

}










