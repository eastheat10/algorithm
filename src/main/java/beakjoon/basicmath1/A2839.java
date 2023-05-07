package beakjoon.stage8;

import java.util.Scanner;

public class A2839 {

	public static int count(int kg) {
		int count = 0;
		int five = 0, three = 0;

		if(kg % 5 == 0) {
			count = kg / 5;
			return count;
		}
		else {
			int tmp = kg / 5;
			for(int i = tmp; i > 0; i--) {
				if((kg - (5 * i)) % 3 == 0) {
					five = i;
					three = (kg - (5 * i)) / 3;
					count = five + three;
					return count;
				}
			}
		}

		if(kg % 3 == 0)
			count = kg / 3;
		else
			count = -1;

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("설탕 무게를 입력하세요: ");
		int kg = sc.nextInt();

		System.out.println(count(kg));

	}

}
