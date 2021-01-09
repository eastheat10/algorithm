package algo.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String word = br.readLine();
		int count = 0;

		for(String s : croa) {
			word = word.replace(s, "T");
		}

		System.out.println(word.length());
		br.close();

	}

}

//	String class의 메소드 공부 열심히 하자