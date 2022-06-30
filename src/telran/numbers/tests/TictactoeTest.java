package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.TictactoeGame;

class TictactoeTest {

	@Test
	void testTictactoeMove() {
	char matrixWinnerColumnX[][] = {
			{'x', '0', 'x'},
			{'x', '0', '0'},
			{ 0 ,  0,   0 }
	};
	char matrixWinnerLeftDiagonalO[][] = {
			{'0', 'x', 'x'},
			{'x', '0', '0'},
			{'x' ,'x',  0 }
	};
	char matrixWinnerRightDiagonalX[][] = {
			{'0', '0', 'x'},
			{'x',  0,  '0'},
			{'x' ,'x',  0 }
	};
	char matrixWinnerRowO[][] = {
			{'x', '0', 'x'},
			{'0',  0,  '0'},
			{'x' ,'x',  0  }
	};
	char matrixDraw[][] = {
			{'0', '0', 'x'},
			{'x', 'x', '0'},
			{'0' ,'x',  0 }
	};
	char emptyMatrix[][] = new char[3][3];
	assertEquals(1, TictactoeGame.tictactoeMove(matrixWinnerColumnX, 2, 0, 'x'));
	assertEquals(1, TictactoeGame.tictactoeMove(matrixWinnerLeftDiagonalO, 2, 2, '0'));
	assertEquals(1, TictactoeGame.tictactoeMove(matrixWinnerRightDiagonalX, 1, 1, 'x'));
	assertEquals(1, TictactoeGame.tictactoeMove(matrixWinnerRowO, 1, 1, '0'));
	assertEquals(2, TictactoeGame.tictactoeMove(matrixDraw, 2, 2, 'x'));
	assertEquals(0, TictactoeGame.tictactoeMove(emptyMatrix, 1, 2, 'x'));
	
	}

}