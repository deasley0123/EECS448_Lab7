import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class matrixCalc {
	
	public static int main(String[] args) {
		//Confirm command-line parameters
		if(args.length < 3)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
			return 1;
		}
		
		// Initialize file streams
		BufferedReader buffIn;
		BufferedWriter buffOut;
		
		try {
			buffIn = new BufferedReader(new FileReader(args[1]));
			buffOut = new BufferedWriter(new FileWriter(args[2]));
		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}

		//Process commands
		int n;
		try {
			
			while((n = Integer.parseInt(buffIn.readLine())) != 0){
				
				//variables in use
				Matrix mySon = new Matrix(n);
				String currRow = new String();
				
				//Read in matrix values and write them out
				buffOut.write("M =");
				for(int i = 0; i < n; i++){
					currRow	 = buffIn.readLine();
					mySon.setRow(i, currRow);
					buffOut.write(currRow);
				}
				
				//calculate and write out determinate
				double det = mySon.determinator();
				buffOut.write("det(m) = " + det);
				
				//Provided it exists, calculate the inverse matrix and write it to file
				if (det != 0){
					Matrix notMySon = mySon.inversinator();
					buffOut.write("M inverse =");
					for(int i = 0; i < n; i++){
						buffOut.write(notMySon.getRow(i));
					}
					
				}
				
			}
			
			buffIn.close();
			buffOut.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}

}
