package telran.numbers.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import telran.numbers.TictactoeGame;

class TictactoeTest {

	@Test
	void testTictactoeMove() {
		//TODO
		char matrix1[][] = {
				{'0', 'x', 'x'},
				{'x', '0', 'x'},
				{'0', '0'}
		};
		char matrix2[][] = {
				{'0', 'x', 'x'},
				{'x', '0', 'x'},
				{'x', '0'}
		};
		char matrix3[][] = {
				{'0', 'x', 'x'},
				{'x', 'x', '0'},
				{'0', '0'}
		};
		char matrix4[][] = {
				{'0', 'x'},
				{'x', '0'},
				{'0', '0'}
		};
		char matrix5[][] = {
				{'0', 'x', 'x'},
				{'x', 'x', '0'},
				{'0', '0'}
		};
		
		
		assertEquals(1, TictactoeGame.tictactoeMove(matrix1, 2, 2, '0'));
		assertEquals(1, TictactoeGame.tictactoeMove(matrix1, 2, 2, 'x'));
		assertEquals(1, TictactoeGame.tictactoeMove(matrix2, 2, 2, '0'));
		assertEquals(1, TictactoeGame.tictactoeMove(matrix3, 2, 0, 'x'));
//		assertEquals(0, TictactoeGame.tictactoeMove(matrix4, 1, 2, 'x'));
//		assertEquals(2, TictactoeGame.tictactoeMove(matrix5, 2, 2, 'x'));
	}

}
