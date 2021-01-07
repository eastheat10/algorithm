package algo.stage10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10872 {

	public static int factorial(int n) {
		if(n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(Integer.toString(factorial(n)));
		br.close();
		bw.flush();
		bw.close();
	}
}
