package programers.greedy;

import java.util.Arrays;

public class LifeBoat {

    public static int solution(int[] people, int limit) {
        if(people.length == 1 )
            return 1;
        int answer = 0;
        int i = 0;
        int j = people.length - 1;

        Arrays.sort(people);

        for (; j > i; j--) {
            if (people[i] + people[j] <= limit) {
                answer++;
                i++;
            } else {
                answer++;
            }

        }
        if (i == j) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

//    people        	limit	return
//    [70, 50, 80, 50]	100	    3
//    [70, 80, 50]	    100	    3

}
