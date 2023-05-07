package homework.hw4_1;

import java.util.Scanner;

public class Hw4_1 {

    public static String[] arr;

    public static void quickSort(int start, int end) {
        // partition 함수를 통해 파티션을 나누고 오른쪽 파티션의 시작 인덱스를 반환받음
        int partition = partition(start, end);
        // 시작 인덱스가 파티션 인덱스보다 작으면 왼쪽 파티션 퀵정렬 실행
        if (start < partition - 1) {
            quickSort(start, partition - 1);
        }
        // 끝 인덱스가 파티션 인덱스보다 크면 오른쪽 파티션 퀵정렬 실행
        if (partition < end) {
            quickSort(partition, end);
        }
    }

    public static int partition(int start, int end) {
        String pivot = arr[(start + end) / 2];  // 피벗을 배열의 가운데 원소로 지정

        while (start <= end) {
            // 비교될 문자열과 피벗 문자열이 사전순으로 정렬되어있지 않은 원소가 나올 때 까지 반복문 호출
            while (arr[start].compareToIgnoreCase(pivot) < 0)
                start++;
            while (arr[end].compareToIgnoreCase(pivot) > 0)
                end--;
            // 앞에서 부터 시작한 인덱스가 뒤에서 시작한 인덱스와 겹쳐지면
            if (start <= end) {
                // 두 문자열 교환
                String tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hw4_1 : 윤동열");
        System.out.print("단어 수 입력: ");
        int n = sc.nextInt();
        arr = new String[n];

        System.out.println("10개의 단어 입력");
        for (int i = 0; i < n; i++)
            // Apple aPple apPle appLe applE APPLE apple dog cat age 입력
            arr[i] = sc.next();

        quickSort(0, n - 1); // 퀵정렬 실행

        for (String s : arr)
            System.out.print(s + " ");
            // age aPple apPle appLe applE APPLE apple Apple cat dog 출력

    }
}
