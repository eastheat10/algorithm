package algo.stage8;

import java.util.Scanner;

public class A2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("설탕 무게를 입력하세요: ");
		int kg = sc.nextInt();
		int three = 0;
		int five = 0;

		if (kg == 4 || kg < 3) {
			System.out.println(-1);
			return;
		}

		if((kg % 5) % 3 == 0) {
			five = kg / 5;
			three = (kg % 5) / 3;
			System.out.println(five + three);
			return;
		}
		else if((kg % 3) % 5 == 0) {
			three = kg / 3;
			five = (kg % 3) / 5;
			System.out.println(three + five);
			return;
		}
		else if(kg % 3 == 0) {
			System.out.println(kg / 3);
			return ;
		}
		else if(kg % 5 == 0) {
			System.out.println(kg / 5);
		}
		else {
			System.out.println(-1);
			return;
		}



	}

}
