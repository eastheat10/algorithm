package beakjoon.stage9;

import java.util.Scanner;

public class A3053 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double radius = sc.nextInt();

		double circle = Math.PI * Math.pow(radius, 2);
		double taxi_circle = 2 * Math.pow(radius, 2);

		System.out.printf("%.6f\n%.6f", circle, taxi_circle);

	}

}
