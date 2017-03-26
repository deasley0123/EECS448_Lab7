
public class Matrix {
	int size = 0;
	int[][] innards;
	
	public Matrix(int n){
		size = n;
		innards = new int[size][size];
	}
	
	public void setRow(int row, int[] values){
		for(int i = 0; i < size; i++){
			innards[row][i] = values[i];
		}
	}
	
}
