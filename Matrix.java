
public class Matrix {
	int size = 0;
	int[][] inards;
	
	public Matrix(int n){
		size = n;
		inards = new int[size][size];
	}
	
	public void setRow(int row, int[] values){
		for(int i = 0; i < values.length; i++){
			inards[row][i] = values[i];
		}
	}
	
}
