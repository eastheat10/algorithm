package algo.stage9;

import java.util.Scanner;

public class A3009 {

	public static int point(int[] a) {
		if(a[0] == a[1])
			return a[2];
		else if(a[0] == a[2])
			return a[1];
		else // if(a[1] == a[2])
			return a[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3];
		int[] y = new int[3];

		for(int i = 0; i < 3; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int x_point = point(x);
		int y_point = point(y);

		System.out.printf("%d %d", x_point, y_point);
	}

}
