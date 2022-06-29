package telran.numbers;

import java.util.Arrays;

public class TictactoeGame {
	/**
	 * 
	 * @param matrix square matrix (nRows == nColumns); where nRows >= 3
	 * @param nRow (number of row)
	 * @param nColumn (number of column)
	 * @param symb (being filled symbol either 'x' or '0')
	 * @return 0 - game isn't over; 1 - game is over with the winner's move; 2 - game is over with draw
	 */
	public static int tictactoeMove(char matrix[][], int nRow, int nColumn, char symb) {
		char[] newRow = insertNumber(matrix[nRow], nColumn, symb);
		char[][] newMat = removeRow(matrix, nRow);
		char[][] newMat1 = insertRow(newMat, newRow, nRow);
		
		for(int i = 0; i < newMat1.length; i++) {
			int count = 0;
			for(int j = 0; j < newMat1[i].length; j++) {
				if(newMat1[i][j] == symb) {
					count++;
					if (count == 3) {
						return 1;
					}
				}
			}
		}
		for(int i = 0; i < newMat1.length; i++) {
			int count = 0;
			for(int j = 0; j < newMat1[i].length; j++) {
				if(newMat1[j][i] == symb) {
					count++;
					if (count == 3) {
						return 1;
					}
				}
			}
		}
		for(int i = 0; i < newMat1.length; i++) {
			int count = 0;
			for(int j = 0; j < newMat1[i].length; j++) {
				if(newMat1[j][j] == symb) {
					count++;
					if (count == 3) {
						return 1;
					}
				}
			}
		}
		for(int i = 0; i < newMat1.length; i++) {
			int count = 0;
			for(int j = 0; j < newMat1[i].length; j++) {
				if(newMat1[i][newMat1[i].length - 1 - i] == symb) {
					count++;
					if (count == 3) {
						return 1;
					}
				}
			}
		}
		return 2;
	}	
	
	static char[] insertNumber(char ar[], int index, char symb) {
		char res[] = new char[ar.length + 1];
		System.arraycopy(ar, 0, res, 0, index);
		res[index] = symb;
		System.arraycopy(ar, index, res, index + 1, ar.length - index);
		return res;
	}
	static char[][] removeRow(char matrix[][], int index) {
		char res[][] = new char[matrix.length - 1][];
		System.arraycopy(matrix, 0, res, 0, index);
		System.arraycopy(matrix, index + 1, res, index, res.length - index);
		return res;
	}
	static char[][] insertRow(char matrix[][], char row[], int index) {
		char res[][] = new char[matrix.length + 1][];
		if (row.length != matrix[0].length) {
			row = Arrays.copyOf(row, matrix[0].length);
		}
		System.arraycopy(matrix, 0, res, 0, index);
		res[index] = row;
		System.arraycopy(matrix, index, res, index + 1, matrix.length - index);
		return res;
	}
}
