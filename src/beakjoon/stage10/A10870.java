package beakjoon.stage10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10870 {

	public static int fibonacci(int n) {
		if(n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(Integer.toString(fibonacci(n)));
		br.close();
		bw.flush();
		bw.close();
	}
}
