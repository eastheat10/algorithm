package beakjoon.stage7;

//문제
//알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
//
//입력
//첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
//
//출력
//첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

import java.util.Scanner;

public class A1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("단어를 입력하세요: ");
		String s = sc.next().trim().toUpperCase();

		int[] n = new int[26];
		int count = 0;
		int max = 0;
		char tmp = ' ';

		for(int i = 0; i < 26; i++) {

			int asc = i + 65;
			for(int j = 0; j < s.length(); j++) {
				if((char)asc == s.charAt(j))
					n[i]++;
			}

		}

		max = n[0];

		for(int i = 1; i < 26; i++) {
			if(max < n[i]) {
				max = n[i];
				tmp = (char)(i + 65);
			}
		}

		if(max == n[0])
			tmp = (char)65;

		for(int m : n) {
			if(max == m)
				count++;
		}

		if(count > 1)
			System.out.println("?");
		else
			System.out.println(tmp);

	}
}
