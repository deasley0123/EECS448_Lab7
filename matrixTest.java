import static org.junit.Assert.*;

import org.junit.Test;

public class matrixTest {

	@Test
	public void testGetRow() {
		Matrix testy = new Matrix(3);
		testy.innards[0][0] = 3.0;
		testy.innards[0][1] = 4.0;
		testy.innards[0][2] = 5.0;

		assertTrue(testy.getRow(0).equals("3.0 4.0 5.0"));
	}

	@Test
	public void testDeterminator() {
		Matrix testy = new Matrix(3);
		double x = 1;
		for (int i = 0; i < testy.size; i++) {
			for (int j = 0; j < testy.size; j++){
				if(i == testy.size -1 && j == testy.size -1)
					testy.innards[i][j] = 12;
				else
					testy.innards[i][j] = x;
				x += 1;
			}
		}	
		
		assertTrue(-9.0 - testy.determinator() == 0);
	}

	@Test
	public void testInversinator() {
		Matrix testy = new Matrix(3);
		testy.innards[0][0] = 7.0;
		testy.innards[0][1] = 2.0;
		testy.innards[0][2] = 1.0;
		testy.innards[1][0] = 0.0;
		testy.innards[1][1] = 3.0;
		testy.innards[1][2] = -1.0;
		testy.innards[2][0] = -3.0;
		testy.innards[2][1] = 4.0;
		testy.innards[2][2] = -2.0;
												
		Matrix testy2 = new Matrix(3);
		testy2.innards[0][0] = -2.0;
		testy2.innards[0][1] = 8.0;
		testy2.innards[0][2] = -5.0;
		testy2.innards[1][0] = 3.0;
		testy2.innards[1][1] = -11.0;
		testy2.innards[1][2] = 7.0;
		testy2.innards[2][0] = 9.0;
		testy2.innards[2][1] = -34.0;
		testy2.innards[2][2] = 21.0;
		
		assertEquals(testy2.innards, testy.inversinator().innards);
	}

}
