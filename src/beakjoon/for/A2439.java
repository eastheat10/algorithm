package beakjoon.stage3;

// 별찍기 오른쪽정렬

import java.util.Scanner;

public class A2439 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.print("숫자를 입력하세요: ");
	int n = sc.nextInt();

	int i;
	int count = 0;

	for(;n > 0; n--) {
		count++;
		for(i = 0; i < n - 1; i++)
			System.out.print(" ");
		for(i = 0; i < count; i++)
			System.out.print("*");
		System.out.println("");
	}

	}

}