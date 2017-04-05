//import java.util.Arrays;
/*
 *  rotates a 2d array by 90 degrees
 *  first roate method rotates 2d array within the same 2d array
 *  second rotate  method rotates 2d array using another temp 2d array
 */
public class rotateImage {
	public static void main(String[] args) {
		char[][] test =  {{'x', 'x', 'x','x'},
						{'o','o','o','o'},
						{'x', 'x', 'x','x'},
						{'o','o','o','o'}};
		int[][] test3 = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		
		int[][] test4 = {{1,2,3,4},
						 {5,6,7,8},
						 {9,1,2,3},
						 {4,5,6,7}};
		int[][] test5 ={{1,2,3,4,5},
						 {6,7,8,9,1},
						 {2,3,4,5,6},
						 {7,8,9,1,2},
						 {3,4,5,6,7}};
		// 3 by 3				 
		print(test3);
		rotate(test3);
		System.out.println();
	    print(test3);
	    System.out.println();
		
	    //4 by 4
		print(test4);
		rotate(test4);
		System.out.println();
	    print(test4);
	    System.out.println();
	
	    //5 by 5
		print(test5);
		rotate(test5);
		System.out.println();
	    print(test5);
	
		for (int i = 0; i < 10; i++)
			testOrder(i);
	}
	private static void testOrder(int n) {
		int[][] board = new int[n][n];
		int[][] expected = new int[n][n];
		
		int i = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				board[r][c] = i;
				expected[c][n-r-1] = i++;
			}
		}
		
		rotate(board);
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (board[r][c] != expected[r][c])
					throw new RuntimeException(board[r][c] + " != " + expected[r][c] + " at r="+r+",c="+c);
			}
		}
	}
	
	/*
	 * I noticed a pattern where if for size 3, i only need 2 swaps. 
	 * for size 4, i need 3 swaps. Size 4 has 2 square.
	 * the inner square of size 4 only needs 1 swap.
	 * This was the general case, each inner square need swaps of outer layer - 2.
	 */
	public static void rotate(int[][] r) { 
		int max = r.length;
		for(int i = 0; i < max/2; i++) {
			int layer = i;
			for(int j = 0; j < (max-1) - 2 * i; j++) { 
				int offset = j;
				//hold temp of first value in first row, and interates thru first row
				int temp = r[layer][offset + layer];
				//iterates through first column starting at last index and store it in first row
				r[layer][offset + layer] = r[max-offset- layer- 1][layer];
				//iterates through last row starting at last index and stores it in first column
				r[max-offset - layer-1][layer] = r[max- layer -1][max- layer - offset - 1];
				// inteates through  last column at first index and stores it in last row
				r[max- layer -1][max - layer -offset-1] = r[offset + layer][max- layer -1];
				r[offset + layer][max- layer -1] = temp;	
			}
		}
		
	}
	public static void rotate(char[][] r) { 
		// finds the row and col of original 2d array
		int row = r.length;
		int col = r[0].length;
		// creates new array with [col][row] to have room for rotated elements
		char[][] arr = new char[col][row];
		//itterates through new array 
		for(int i = 0; i < col;i++) { 
			for(int j = 0; j < row;j++) { 
				// this works cant explain typing it, look at a picture
				arr[i][j] = r[row - 1 - j][i];
			}
		}
		
		for(int i = 0; i < col;i++) { 
			for(int j = 0; j <row;j++) { 
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void print(int[][] r) { 
		for(int i = 0; i < r.length;i++) { 
			for(int j = 0; j < r[i].length;j++) { 
				System.out.print(r[i][j]);
			}
			System.out.println();
		}
	}
	
}

