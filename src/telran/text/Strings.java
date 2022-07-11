package telran.text;

import static telran.text.RegularExpressions.*;

public class Strings {
	private static final int MAX_NUMBER = 999;

	/**
	 * 
	 * @param str1 ascii string with no repeated symbols
	 * @param str2 ascii string with no repeated symbols
	 * @return array with two numbers first - number of the symbols of the str2 that
	 *         exist in str1 at the same indexes second - number of the symbols of
	 *         the str2 that exist in str1 at different indexes
	 */
	public static int[] deepNoRepeatedCompare(String str1, String str2) {
		// TODO
		// Hints for two different implementations
		// first: additional helper array such that array['a']
		// is an index of the symbol 'a' in str1 or -1
		// example, str1 - "ctab" then array['a'] = 2;
		// ************************************************
		// second: implementation based on the method indexOf
		int res[] = new int[2];
		/*******************************************/
		// first implementation O[N]
		// helperImpl(str1, str2, res);
		/********************************************/
		// second implementation based on indexOf O[N^2]
		indexOfImpl(str1, str2, res);

		return res;
	}

	private static void indexOfImpl(String str1, String str2, int[] res) {
		char str2Ar[] = str2.toCharArray();
		for (int i = 0; i < str2Ar.length; i++) {
			int index = str1.indexOf(str2Ar[i]);
			if (index >= 0) {
				res[index == i ? 0 : 1]++;
			}
		}
	}

	private static void helperImpl(String str1, String str2, int[] res) {
		int helper[] = new int[127];

		fillInitHelper(helper);
		fillHelperString1(str1, helper);
		fillResult(helper, res, str2);
	}

	private static void fillInitHelper(int[] helper) {
		for (int i = 0; i < helper.length; i++) {
			helper[i] = -1;
		}

	}

	private static void fillResult(int[] helper, int[] res, String str2) {
		char str2Ar[] = str2.toCharArray();
		for (int i = 0; i < str2Ar.length; i++) {
			int index = helper[str2Ar[i]];
			if (index >= 0) {
				res[index == i ? 0 : 1]++;

			}
		}
	}

	private static void fillHelperString1(String str1, int[] helper) {
		char str1Ar[] = str1.toCharArray();// abcde helper['d']==3
		for (int i = 0; i < str1Ar.length; i++) {
			helper[str1Ar[i]] = i;
		}
	}

	/**
	 * 
	 * @param str1 English letters (may have repeats)
	 * @param str2 English letters (may have repeats)
	 * @return true if : (1) str2 has the same as str1 length (2) str2 comprises of
	 *         all letters from str1
	 */
	public static boolean isAnagram(String str1, String str2) {

		// additional helper array such that array['a'] is the number of 'a' occurrences
		// in str1
		// str1 = "hello", array['l'] = 2; array['w'] = 0;

		if (str1.length() != str2.length()) {
			return false;
		}
		int[] helper = new int[127];
		fillHelperOccurrences(str1, helper);
		return isAnagram(str2, helper);

	}

	private static boolean isAnagram(String str, int[] helper) {
		char[] strAr = str.toCharArray();
		for (int i = 0; i < strAr.length; i++) {
			int count = helper[strAr[i]]--; // d = ++c vs. d = c++
			if (count == 0) {
				return false;
			}
		}
		return true;
	}

	private static void fillHelperOccurrences(String str, int[] helper) {
		char[] strAr = str.toCharArray();

		for (int i = 0; i < strAr.length; i++) {
			helper[strAr[i]]++;
		}

	}

	static public String join(String[] array, String delimiter) {
		// STring "+" operator based solution
		return stringPluseSolution(array, delimiter);
		// StringBuilder attend based solution
		// return stringBuilderSolution(array, delimiter);
	}

	static private String stringBuilderSolution(String[] array, String delimiter) {
		StringBuilder strBuilder = new StringBuilder(array[0]);
		for (int i = 1; i < array.length; i++) {
			strBuilder.append(delimiter).append(array[i]);
		}
		return strBuilder.toString();
	}

	static private String stringPluseSolution(String[] array, String delimiter) {
		String res = array[0]; // assumption: there is at least one string
		for (int i = 1; i < array.length; i++) {
			res += delimiter + array[i];
		}
		return res;
	}

	/**
	 * 
	 * @param name1 - first name
	 * @param name2 - second name
	 * @return either "match" or "no match" in accordance to the comments (see TODO)
	 */
	static public String matches(String name1, String name2) {
		// TODO
//      String matches(String name1, String name2)
//      Names match under the following conditions, after breaking each one into "name parts" on whitespace :
//      - Two name parts match if they are the same (case insensitive) or one is a single letter initial and the other is longer but starts with the same letter.
//      - A name part in  the name1 may be missing from the name2
//      - Name parts in one name must not contradict name parts in the other
//      - Name parts that match must be in the same order in both names

		String partsName1[] = name1.split(" ");
		String partsName2[] = name2.split(" ");
		int indPartsName2 = 0;
		String match = "match";
		String noMatch = "no match";
		boolean flMatch = false;
		for (int i = 0; i < partsName1.length; i++) {
			flMatch = partMatch(partsName1[i], partsName2[indPartsName2]);
			if (flMatch) {
				indPartsName2++;
				if (indPartsName2 == partsName2.length) {

					return match;
				}
			}
		}
		return noMatch;
	}

	private static boolean partMatch(String part1, String part2) {
		part1 = part1.toLowerCase();
		part2 = part2.toLowerCase();
		boolean res = false;
		if (part1.compareTo(part2) == 0) {
			res = true;
		} else if (isSameInitial(part1, part2)) {
			res = true;
		}
		return res;
	}

	private static boolean isSameInitial(String part1, String part2) {
		String partI = part1.length() == 1 ? part1 : part2;
		String partF = part1 == partI ? part2 : part1;
		return partI.length() == 1 && partF.startsWith(partI);
	}

	/**
	 * sorts array of strings
	 * 
	 * @param strNumbers array of strings containing the positive integer numbers
	 *                   length of each string can not be more than three symbols
	 *                   String containing "123" should be greater than string
	 *                   containing "23" as the number 123 greater than number 23
	 */
	static public void sortStringsAsNumbers(String[] strNumbers) {

		// Algorithm complexity should be O[N]
		// Implementation hint: additional helper array such that ar[10] - count of
		// occurrences
		// of number 10 in the given array
		// find out how to get number from a string and how to convert number to string
		int helper[] = new int[MAX_NUMBER + 1];
		fillHelper(strNumbers, helper);
		sorting(strNumbers, helper);
	}

	private static void sorting(String[] strNumbers, int[] helper) {
		int indAr = 0;

		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				strNumbers[indAr++] = Integer.toString(i);
			}
		}

	}

	private static void fillHelper(String[] strNumbers, int[] helper) {
		for (int i = 0; i < strNumbers.length; i++) {
			int index = Integer.valueOf(strNumbers[i]);
			helper[index]++;
		}
	}

	public static boolean isIPv4(String ipV4str) {

		return ipV4str.matches(ipV4Regex());
	}

	public static boolean isJavaVariable(String javaVariable) {

		return javaVariable.matches(javaVariableRegex());
	}

	public static boolean isArithmeticExpression(String expression) {
		if (!checkParentheses(expression)) {
			return false;
		}
		// expression = removeSpacesAndParentheses(expression);
		expression = removeSpaces(expression);

		return expression.matches(arithmeticExpression());
	}

	/**
	 * 
	 * @param expression returns string with no parentheses and no spaces
	 */
	private static String removeSpacesAndParentheses(String expression) {

		return expression.replaceAll("[\\s()]+", "");

	}

	private static String removeSpaces(String expression) {

		return expression.replaceAll("\\s+", "");

	}

	/**
	 * 
	 * @param expression
	 * @return true if for each '(' there is ')' examples: (ab)(dg(g)) - true
	 *         (ab))((cd) - false
	 */
	private static boolean checkParentheses(String expression) {
		char[] strArray = expression.toCharArray();
		int count = 0;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i] == '(') {
				count++;
			} else if (strArray[i] == ')') {
				count--;
				if (count < 0) {
					return false;
				}
			}
		}
		return count == 0;
	}
}
