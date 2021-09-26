import java.util.*;
import java.io.*;

class A7795 {

	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			input(br);
			process();
		}
		System.out.println(sb);
	}

	static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n + 1];
		b = new int[m + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

	}

	static void process() {
		Arrays.sort(b, 1, m + 1);

		int sum = 0;
		for (int l = 1; l <= n; l++) {
			sum += binarySearch(a[l]);
		}

		sb.append(sum).append('\n');

	}

	static int binarySearch(int x) {
		int result = 0;
		int l = 1;
		int r = m;

		while(l <= r) {
			int mid = (l + r) / 2;
			if (b[mid] < x) {
				l = mid + 1;
				result = mid;
			} else {
				r = mid - 1;
			}
		}

		return result;
	}

}
