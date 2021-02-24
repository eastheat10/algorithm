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
		String[] words = new String[n];

		for (int i = 0; i < n; i++)
			words[i] = br.readLine();

		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();	// 글자수 오름차순
				} else {
					return o1.compareTo(o2);	// 사전적 오름차순
				}

			}
		});

		sb.append(words[0] + "\n");

		for (int i = 1; i < n; i++) {
			if(words[i].equals(words[i-1]))
				continue;
			sb.append(words[i] + "\n");
		}

		bw.write(sb.toString());
		bw.flush(); bw.close(); br.close();

	}

}
