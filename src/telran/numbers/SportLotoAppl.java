package telran.numbers;

import java.util.Arrays;

/**
 * 
 * @author 97252 
 * application should print out 7 random numbers in the range [1-49]
 */
public class SportLotoAppl {

	public static void main(String[] args) {
		int res[] = new int[0];
		for (int i = 0; i < 7; i++) {
			int number = getRandomNumber(1, 49);
			ArrayInt.addNumber(res, number);
		}
		System.out.println(Arrays.toString(res));
	}

	private static int getRandomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

}
