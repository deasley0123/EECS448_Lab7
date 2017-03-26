
public class Matrix {
	
	//Class variables
	int size = 0;
	int[][] innards;
	
	//Constructor
	public Matrix(int n){ 	//accepts a square matrix size 'n'
		size = n;
		innards = new int[size][size];
	}
	
	//Sets individual rows of the matrix
	public void setRow(int row, int[] values){ 	//accepts a row number followed by an array of values
		innards[row] = values;
	}
	
	
}
