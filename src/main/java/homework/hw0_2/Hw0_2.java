package homework.hw0_2;

import java.util.Scanner;

public class Hw0_2 {

    public static int factorial(int n) {
        /**
         * 팩토리얼은 1 부터 주어진 수 n 까지 모든 수를 곱하는 것
         * f(n) = n * (n-1) * (n-2) * ... * 2 * 1
         *      = n * f(n-1)
         */
        if(n < 0)
            return -1;
        else if(n == 0 || n == 1)   // factorial(0), factorial(1)은 1 출력
            return 1;
        else    // 1 또는 0 이 아니면 n * factorial(n - 1)
            return n * factorial((n - 1));
    }

    public static void show(int n) {
        if(n <= 0)  // 0이하 고려하지 않음
            return;
        else {
            if(n == 1) {    // n == 1 이면 메서드 종료
                System.out.print(n + " ");
                return;
            }
            show(n - 1);    // 1이 아니면 show (n - 1) 호출 후 본인 출력
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("hw0_2: 윤동열");
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 n 입력: ");
        int n = sc.nextInt();   // 수 입력받기

        System.out.println(factorial(n));   // factorial 메서드 출력
        show(n);    // show 메서드 출력

    }
}
