
public class Matrix {
	
	/*
	 * Class variables
	 */
	int size = 0;
	int[][] innards;
	
	/*
	 * Constructor
	 */
	public Matrix(int n){ 	//accepts a square matrix size 'n'
		size = n;
		innards = new int[size][size];
	}
	
	/*
	 * Sets individual rows of the matrix
	 */
	public void setRow(int row, int[] values){ 	//accepts a row number followed by an array of values
		innards[row] = values;
	}
	
	/*
	 * Creates a matrix from the existing matrix. The result is smaller by one degree.
	 */
	private Matrix subMatrix(int startRow, int c){
		Matrix sub = new Matrix(size - 1);
		
		int row = 0;
		for(int i = 0; i < size; i++){
			
			if(i == startRow) continue;
			
			int col = 0;
			for(int j = 0; j < size; j++){
			
				if(j == c) continue;
				
				sub.innards[row][col] = innards[i][j];
				col++;
			}
			
			row++;
		}
		
		return sub;
	}
	
	/*
	 * Calculates the determinant of the matrix
	 */
	public double determinator(){
		
		//variable to be returned. "I'll be back"
		double arnold = 0.0;
		
		if (1 == size){  	//base case, return only value
			arnold = innards[0][0];
		}
		else if(2 == size){	//base case 2.0, calculate basic determinant
			arnold = innards[0][0] * innards[1][1] - innards[0][1] * innards[1][0];
		}
		else{ 	//calculate the determinant as we go
			for(int i = 0; i < size; i++){
				arnold += Math.pow(-1.0, (double)i) * innards[0][i] * subMatrix(0, 1).determinator();
			}
		}
		
		return arnold;
	}
	

}
