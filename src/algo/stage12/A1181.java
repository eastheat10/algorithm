package algo.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

// 단어정렬
public class A1181 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		String[] word = new String[n];

		for(int i = 0; i < n; i++)
			word[i] = br.readLine();


		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});

		sb.append(word[0] + "\n");
		for(int i = 1; i < n; i++) {
			if(word[i - 1].equals(word[i]))
				continue;
			sb.append(word[i] + "\n");
		}

		bw.write(sb.toString());
		bw.flush(); bw.close(); br.close();

	}

}
