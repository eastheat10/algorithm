package programers.bruteforce;

public class FindPrimeNumber {

    static boolean[] prime;
    static int count = 0;

    public static void prime(int n) {
        int tmp = (int)Math.pow(10, n);
        prime = new boolean[tmp + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i < tmp; i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < tmp; j += i)
                prime[j] = true;
        }
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            if (check(arr, r))
                count++;
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static boolean check(int[] arr, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++)
            sb.append(arr[i] + "");

        int tmp = Integer.parseInt(sb.toString());
        if (!prime[tmp]) {
            System.out.println("sb.toString() = " + Integer.parseInt(sb.toString()));
            prime[tmp] = true;
            return true;
        }
        return false;
    }


    public static int solution(String numbers) {
        int len = numbers.length();
        int[] num = new int[len];
        for (int i = 0; i < len; i++)
            num[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        prime(numbers.length());
        for(int i = 1; i <= len; i++)
            permutation(num, 0, len, i);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        count = 0;
        System.out.println(solution("011"));
    }

    /**
     * numbers	return
     * "17"	    3
     * "011"	2
     */
}
