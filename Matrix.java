
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
	
	public double determinator(){
		double arnold = 0.0;
		
		if (1 == size){
			arnold = innards[0][0];
		}
		else if(2 == size){
			arnold = innards[0][0] * innards[1][1] - innards[0][1] * innards[1][0];
		}
		else
		{
			for(int i = 0; i < size; i++){
				arnold += Math.pow(-1.0, (double)i) * innards[0][i] * subMatrix(0, 1).determinent();
			}
		}
		return arnold;
	}
}
