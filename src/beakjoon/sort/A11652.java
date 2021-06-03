package beakjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

// 카드
public class A11652 {
    static int n;
    static long[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
    }

    static void sort() {
        Arrays.sort(arr);
        long mode = arr[0];
        int modeCnt = 1, curCnt = 1;  // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {  // a[i] 라는 숫자가 계속 등장하고 있다.
                curCnt++;
            } else {
                curCnt = 1;  // a[i] 라는 숫자가 새롭게 등장했다.
            }

            if (curCnt > modeCnt) {
                modeCnt = curCnt;
                mode = arr[i];
            }
        }
        System.out.println(mode);

    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
    }

}
//
//    static int n;
//    static HashMap<Long, Integer> map = new HashMap<>();
//    static ArrayList<Long> list;
//
//    static void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String s = br.readLine();
//            long t;
//            if(s.charAt(0) == '-') {
//                s = s.substring(1, s.length()).trim();
//                t = Long.parseLong(s) * -1;
//            }else
//                t = Long.parseLong(s);
//            map.put(t, map.getOrDefault(t, 0) + 1);
//        }
//    }
//
//    static void sort() {
//        list = new ArrayList<>(map.keySet());
//        list.sort((i, j)->{
//            if (Objects.equals(map.get(i), map.get(j))){
//                return Long.valueOf(i - j).intValue();
//            } else {
//                return map.get(j) - map.get(i);
//            }
//        });
//    }
//
//    public static void main(String[] args) throws IOException {
//        input();
//        sort();
//
//        System.out.println(list.get(0));
//    }
//}
//
