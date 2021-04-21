package beakjoon.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int count = n;

		for(int i = 0; i < n; i++) {
			char[] word = br.readLine().trim().toCharArray();
			boolean[] alpha = new boolean[26];

			for(int j = 1; j < word.length; j++) {
				if(word[j] != word[j - 1]) {
					if(alpha[word[j] - 97]) {
						count--; break;
					}
					alpha[word[j - 1] - 97] = true;
				}
			}
		}
		System.out.println(count);

	}
}


//느낀점
//if 문이 true일 때 count++ 말고
//if 문이 false일 때 count-- 하는 사고가 필요한 것 같다.