package beakjoon.stage1;

//(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
//
//(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
//
//세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class A10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, z;
		System.out.print("첫번째 수: ");
		x = sc.nextInt();
		System.out.print("두번째 수: ");
		y = sc.nextInt();
		System.out.print("세번째 수: ");
		z = sc.nextInt();

		// 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

		System.out.println((x + y) % z);
		System.out.println(((x % z) + (y % z)) % z);
		System.out.println( (x * y) % z );
		System.out.println( ((x % z) * (y % z)) % z );

		}
}
