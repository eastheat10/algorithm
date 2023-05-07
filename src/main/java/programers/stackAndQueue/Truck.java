package programers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
public class Truck {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();  // 다리
        int currentWeight = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    currentWeight += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    currentWeight -= bridge.poll();
                } else {
                    if (truck + currentWeight > weight) {
                        bridge.offer(0);
                        answer++;
                    } else {
                        bridge.offer(truck);
                        answer++;
                        currentWeight += truck;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) {
        System.out.println("answer = " + solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println("answer = " + solution(100, 10, new int[]{10}));
        System.out.println("answer = " + solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

//    bridge_length	weight	truck_weights	                 return
//    2	            10	    [7,4,5,6]	                     8
//    100	        100	    [10]	                         101
//    100	        100	    [10,10,10,10,10,10,10,10,10,10]	 110
}
