import java.util.*;
import java.io.*;

class A2470 {

	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		process();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

	}

	static void process() {
		Arrays.sort(arr, 1, n + 1);

		int best = Integer.MAX_VALUE;
		int v1 = 0;
		int v2 = 0;

		for (int l = 1; l <= n; l++) {
			int t = binarySearch(l + 1, n, -arr[l]);

			if(t >= l + 1 && t <= n && Math.abs(arr[l] + arr[t]) < best) {
				best = Math.abs(arr[l] + arr[t]);
				v1 = arr[l];
				v2 = arr[t];
			}

			if(t - 1 >= l + 1 && t - 1 <= n && Math.abs(arr[l] + arr[t - 1]) < best) {
				best = Math.abs(arr[l] + arr[t - 1]);
				v1 = arr[l];
				v2 = arr[t - 1];
			}

		}

		System.out.println(v1 + " " + v2);
	}

	static int binarySearch(int l, int r, int x) {
		int result = r + 1;

		while(l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] >= x) {
				result = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return result;
	}
}