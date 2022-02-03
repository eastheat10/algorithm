package beakjoon.greedy;

import java.util.*;
import java.io.*;

public class A2217 {

	static int n;
	static ArrayList<Integer> ropes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		process();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			ropes.add(Integer.parseInt(br.readLine()));
		}

		ropes.sort((i, j) -> j - i);
	}

	static void process() {
		Integer max = Integer.MIN_VALUE;
		Integer sum = 0;
		Integer result = 0;

		for (int i = 0; i < n; i++) {
			Integer tmp  = ropes.get(i);
			max = Math.max(max, (tmp * (i + 1)));
		}
		System.out.println(max);
	}
}