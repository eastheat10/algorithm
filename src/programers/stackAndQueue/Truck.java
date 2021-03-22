package programers.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Truck {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(truck_weights[0]);
        int tmpWeight = truck_weights[0];
        int index = 0;  // 선두 트럭 인덱스

        for (int i = 1; i < truck_weights.length; i++) {
            if(tmpWeight + truck_weights[i] > weight) {
                while (tmpWeight + truck_weights[i] > weight) {
                    time += bridge_length;
                    q.poll();
                    tmpWeight -= truck_weights[index];
                    index++;
                }
            }
            else {
                q.add(truck_weights[i]);
                tmpWeight += truck_weights[i];

            }
        }
        time += bridge_length;

        return time;
    }

    public static void main(String[] args) {

        int weight = 10;
//        int weight = 100;
//        int weight = 100;

        int bridge_length = 2;
//        int bridge_length = 100;
//        int bridge_length = 100;


        int[] truck_weight = {7, 4, 5, 6};
//        int[] truck_weight = {10};
//        int[] truck_weight = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int result = solution(weight, bridge_length, truck_weight);

        System.out.println("result = " + result);

    }
}
