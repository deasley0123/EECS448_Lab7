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
				
			}
			
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
