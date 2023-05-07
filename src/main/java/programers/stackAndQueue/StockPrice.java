package programers.stackAndQueue;

public class StockPrice {

    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
                if (j == len - 1) {
                    answer[i] = j - i;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] times = solution(new int[]{1, 2, 3, 2, 3});
        for (int time : times) {
            System.out.print(time + " ");
        }
    }

//    prices	         return
//    [1, 2, 3, 2, 3]	 [4, 3, 1, 1, 0]

}
