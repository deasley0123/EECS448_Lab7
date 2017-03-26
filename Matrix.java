
public class Matrix {
	
	/*
	 * Class variables
	 */
	int size = 0;
	double[][] innards;
	
	/*
	 * Constructor
	 */
	public Matrix(int n){ 	//accepts a square matrix size 'n'
		size = n;
		innards = new double[size][size];
	}
	
	/*
	 * Convert string to an array of doubles
	 */
	private double[] strToDoubArr(String str){
		
		//variable to be returned
		double[] arr = new double[size];
		
		//break up input string along the spaces and parse into integers
		String[] bits = str.split(" ");
		int i = 0;
		for(String bit : bits){
			arr[i++] = Double.parseDouble(bit);
		}
		
		return arr;
	}
	
	/*
	 * Convert array of integers to string
	 */
	private String doubArrToStr(double[] arr){
		
		//variable to be returned
		String temp = new String();
		
		for(int i = 0; i < arr.length; i ++){
			temp += arr[i];
			if(i < arr.length -1){
				temp += " ";	
			}
		}
		
		return temp;
	}
	
	/*
	 * Sets individual rows of the matrix
	 */
	public void setRow(int row, String rowValues){ 	//accepts a row number followed by an array of values
		innards[row] = strToDoubArr(rowValues);
	}
	
	/*
	 * Gets individual rows of the matrix
	 */
	public String getRow(int row){
		
		return doubArrToStr(innards[row]);
	}
	
	/*
	 * Creates a matrix from the existing matrix. The result is smaller by one degree.
	 */
	private Matrix subMatrix(int r, int c){
		Matrix sub = new Matrix(size - 1);
		
		int row = 0;
		for(int i = 0; i < size; i++){
			
			if(i == r) continue;
			
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
				arnold += Math.pow(-1.0, (double)i) * innards[0][i] * subMatrix(0, i).determinator();
			}
		}
		
		return arnold;
	}
	
	/*
	 * Invert the matrix
	 */
	public Matrix inversinator(){
		
		//variable to be returned
		Matrix inverted = new Matrix(this.size);
		
		double det = determinator();
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				inverted.innards[i][j] = (Math.pow(-1.0, (double)(i + j)) * subMatrix(j, i).determinator() / det);
			}
		}
		
		return inverted;
	}

}
