package telran.numbers;

public class TictactoeGame {
	/**
	 * 
	 * @param matrix square matrix (nRows == nColumns; where nRows >= 3)
	 * @param nRow   (number of row)
	 * @param nCol   (number of column)
	 * @param symb   (being filled symbol either 'x' or '0')
	 * @return 0 - game isn't over; 1 - game is over with the winner's move; 2 -
	 *         game is over with draw
	 */
	public static int tictactoeMove(char matrix[][], int nRow, int nCol, char symb) {
		matrix[nRow][nCol] = symb;
		if (isFullRow(matrix, nRow, symb) || isFullColumn(matrix, nCol, symb))
			return 1;
		if (isLeftDiagonal(matrix, nRow, nCol, symb) || isRightDiagonal(matrix, nRow, nCol, symb))
			return 1;
		if (isDraw(matrix))
			return 2;
		return 0;
	}

	private static boolean isDraw(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != 'x' && matrix[i][j] != '0') {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isRightDiagonal(char[][] matrix, int row, int column, char symb) {
		if (isOnRightDiagonal(row, column, matrix.length - 1)) {
			for (int i = 0, j = matrix.length - 1; i < matrix.length; i++, j--) {
				if (matrix[i][j] != symb) {
					return false;
				}
			}
			return true;

		}
		return false;
	}

	private static boolean isOnRightDiagonal(int row, int column, int maxIndex) {
		return row + column == maxIndex;
	}

	private static boolean isLeftDiagonal(char[][] matrix, int row, int column, char symb) {
		if (isOnLeftDiagonal(row, column)) {
			for (int i = 0, j = 0; i < matrix.length; i++, j++) {
				if (matrix[i][j] != symb) {
					return false;
				}
			}
			return true;

		}
		return false;

	}

	private static boolean isOnLeftDiagonal(int row, int column) {
		return row == column;
	}

	private static boolean isFullColumn(char[][] matrix, int column, char symb) {
		boolean res = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][column] != symb) {
				res = false;
				break;
			}
		}
		return res;
	}

	private static boolean isFullRow(char[][] matrix, int row, char symb) {
		boolean res = true;
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[row][j] != symb) {
				res = false;
				break;
			}
		}
		return res;
	}

}