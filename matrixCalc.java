import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class matrixCalc {
	
	public static void main(String[] args) {
		//Confirm command-line parameters
		if(args.length < 2)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
			return;
		}
		
		// Initialize file streams
		BufferedReader buffIn;
		BufferedWriter buffOut;
		
		try {
			buffIn = new BufferedReader(new FileReader(args[0]));
			buffOut = new BufferedWriter(new FileWriter(args[1]));
		} catch (IOException e) {
			e.printStackTrace();
			return;
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
				buffOut.newLine();
				for(int i = 0; i < n; i++){
					currRow	 = buffIn.readLine();
					mySon.setRow(i, currRow);
					buffOut.write(currRow);
					buffOut.newLine();
				}
				
				//calculate and write out determinate
				double det = mySon.determinator();
				buffOut.write("det(m) = " + det);
				buffOut.newLine();
				
				//Provided it exists, calculate the inverse matrix and write it to file
				if (det != 0){
					
					Matrix notMySon = mySon.inversinator();
					buffOut.write("M inverse =");
					buffOut.newLine();
					
					for(int i = 0; i < n; i++){
						buffOut.write(notMySon.getRow(i));
						buffOut.newLine();
					}
					
				}
				
			}
			
			buffOut.write("Done!");
			buffIn.close();
			buffOut.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}

}
