package com.example.adp;

public class RotationMatrix {

	public static void main(String[] args) {
		String inputArray[][] = { { "U", "S", "A" }, { "U", "S", "A" }, { "U", "S", "A" } };
		new RotationMatrix().rotateByNinetyToRight(inputArray);
		System.out.println("Rotated using in Memory Array, result is");
		new RotationMatrix().printArray(inputArray);
		System.out.print("\n");
		String inputArray1[][] = { { "U", "S", "A" }, { "U", "S", "A" }, { "U", "S", "A" } };
		String resultArray[][] = new RotationMatrix().rotateByNinetyToRight(3, inputArray1);
		System.out.println("Rotated using in External Array, result is");
		new RotationMatrix().printArray(resultArray);
	}

	/**
	 * Matrix rotation using external Array
	 * 
	 * Rotates based on column and row numbers, input column becomes output row.
	 * Input row becomes output Column from last.
	 * 
	 * @param inputArray
	 * @param N
	 *            -- size of matrix if inputArray is 3*3 then N is 3
	 * @return
	 */
	private String[][] rotateByNinetyToRight(int N, String[][] inputArray) {
		String[][] result = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// input row should become out column from right end , we are
				// subtracting i from N because it has to start from last.
				result[j][(N - 1) - i] = inputArray[i][j];
			}
		}
		return result;
	}

	/**
	 * rotation using in memory Array
	 * 
	 * @param m
	 */
	public void rotateByNinetyToRight(String[][] m) {
		swapRows(m);
		transpose(m);
	}

	private void transpose(String[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = i; j < m[0].length; j++) {
				String x = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = x;
			}
		}
	}

	private void swapRows(String[][] m) {
		for (int i = 0, k = m.length - 1; i < k; ++i, --k) {
			String[] x = m[i];
			m[i] = m[k];
			m[k] = x;
		}
	}

	/**
	 * Prints Given Array
	 * 
	 * @param inputArray
	 */
	private void printArray(String[][] inputArray) {
		for (String[] row : inputArray) {
			for (String data : row) {
				System.out.print(data);
			}
			System.out.print("\n");
		}
	}

}
