package programers.sort;

import java.util.Arrays;

// k 번째 수
public class KthNumber {

    public static int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];

        for (int m = 0; m < len; m++) {
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];
            int l = j - i;
            if (l == 0) {
                l = 1;
                answer[m] = array[i - 1];
                continue;
            }

            int[] arr = new int[l + 1];

            for (int n = i - 1; n < j; n++) {
                arr[n - i + 1] = array[n];
            }
            Arrays.sort(arr);
            answer[m] = arr[k - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        for (int i : arr) {
            System.out.println("i = " + i);
        }

    }

//    array	                  commands	                          return
//    [1, 5, 2, 6, 3, 7, 4]	  [[2, 5, 3], [4, 4, 1], [1, 7, 3]]	  [5, 6, 3]

}
