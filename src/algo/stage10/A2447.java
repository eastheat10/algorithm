package algo.stage10;

import java.io.*;

public class A2447 {

	static String star ="*";
	static int count = 0, height = 0;
	static StringBuffer sb = new StringBuffer();

	public static String printStar(int n) {
		if(count == 1){
			if (height != 2) {
				sb.append(star + star + star + "\n");
				if(height == 3) height = 0;
				star = sb.toString();
			}
			else
				sb.append(star + " " + star + "\n");
		} else {
			count++;
			printStar(n - count);
		}
		return star;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		printStar(n);

		bw.write(sb.toString());
		bw.flush();bw.close();
		br.close();

	}
}
