package beakjoon.stage9;

import java.util.Arrays;
import java.util.Scanner;

public class A4153 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int[] t = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
			if(t[0] == 0 && t[1] == 0 && t[2] == 0)
				return;
			Arrays.sort(t);
			if(Math.pow(t[0], 2) + Math.pow(t[1], 2) == Math.pow(t[2], 2))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}
