package algo.stage3;

// 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class A2742 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();

		for(; n > 0; n--) {
			System.out.println(n);
		}
	}

}
