package homework.hw11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 그리디 알고리즘 - 회의실 배정
public class Hw11_1 {

    public static void sort (Conference[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j].end < arr[j - 1].end) {
                    Conference tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("hw11_1 : 윤동열\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("신청 회의 수 입력: ");
        int n = Integer.parseInt(br.readLine());
        Conference[] array = new Conference[n];

        System.out.println("12개의 회의명과 회의실 사용 시간(시작시와 종료시)을 whitespace로 구분하여 입력:");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();   // 회의 이름
            int startTime = Integer.parseInt(st.nextToken());   // 시작시간
            int endTime = Integer.parseInt(st.nextToken());    // 종료시간
            Conference conference = new Conference(name, startTime, endTime);
            array[i] = conference;
        }

        sort(array);    // 버블 정렬

        ArrayList<Conference> list = new ArrayList<>();

        if (array[0].start >= 6 && array[0].end < 23)
            list.add(array[0]);

        Conference before = array[0];
        Conference now;
        for (int i = 1; i < n; i++) {
            now = array[i];
            if (array[i].start >= 6 && array[i].end < 23) {
                if (array[i].start == array[i - 1].start) {
                    continue;
                }
                if (before.end <= now.start) {
                    list.add(array[i]);
                    before = array[i];
                }
            }
        }

        System.out.println("선정된 회의 수 = " + list.size());
        System.out.println("선정된 회의 스케줄 = ");
        for (Conference conference : list) {
            System.out.println(conference);
        }

    }
}

class Conference {
    String name;
    int start;
    int end;

    public Conference(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return name + " (" + start + ", " + end + ")";
    }
}