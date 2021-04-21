package beakjoon.stage3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// bufferedReader, bufferedWriter를 이용한 입출력

public class A15552 {
	public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			System.out.print("숫자를 입력하세요: ");
			int n = Integer.parseInt(br.readLine().trim());


			for(int i = 0; i < n; i++) {
				String s1 = br.readLine();
				String[] s2 = s1.split(" ");
				int sum = Integer.parseInt(s2[0]) + Integer.parseInt(s2[1]);
				bw.write(sum + "\n");
			}
			br.close();
			bw.flush();
			bw.close();

	}

}
