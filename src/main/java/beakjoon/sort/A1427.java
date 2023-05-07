package beakjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class A1427 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String s = br.readLine();
		Integer[] num = new Integer[s.length()];

		for(int i = 0; i < num.length; i++)
			num[i] = Integer.parseInt(Character.toString(s.charAt(i)));

		Arrays.sort(num, Collections.reverseOrder());

		for(int n : num)
			bw.write(Integer.toString(n));

		br.close(); bw.flush(); bw.close();
	}

}
