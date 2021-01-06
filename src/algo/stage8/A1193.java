package algo.stage8;

import java.util.Scanner;

public class A1193 {

	public static int d_down(int n, int d) {
		while(d != 0) {
			n++;
			d--;
			System.out.println(n + " " + d);
		}
		return n;
	}

	public static int d_up(int n, int d) {
		while(n != 0) {
			n--;
			d++;
			System.out.println(n + " " + d);
		}
		return d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n = 1;
		int d = 1;

		for(int i = 0; i < num; i++) {
			if(i == 0) {
				d++;
				n = d_down(n, d);
				d = 1;
			}
			if(n == 1) {
				n++;
				n = 1;
				d = d_up(n, d);
			}
			else {
				d++;
				n = d_down(n, d);
				d = 1;
			}
		}

		System.out.println(n + "/" + d);
	}

}
