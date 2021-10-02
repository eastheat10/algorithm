import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static int[] arr;
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        Arrays.sort(arr, 1, n + 1);
        long l = 1;
        long r = Integer.MAX_VALUE;
        long result = 0;
        
        while (l <= r) {
            long mid = (l + r) / 2;
            if(determine(mid)) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean determine(long x) {
        if (x >= arr[n])
            return false;
        
        long sum = 0;
        for (int i = n; i > 0; i--) {
            if (arr[i] < x)
                break;
            sum += arr[i] - x;
        }

        return sum >= m;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}