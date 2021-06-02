package beakjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 국영수
public class A10825 {

    static int n;
    static ArrayList<Student> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korean, english, math));
        }
    }

    static void sort() {
        list.sort((s1, s2) -> {
            if (s1.korean == s2.korean) {
                if (s1.english == s2.english) {
                    if (s1.math == s2.math) {
                        return s1.name.compareTo(s2.name);
                    }
                    return s2.math - s1.math;
                }
                return s1.english - s2.english;
            } else {
                return s2.korean - s1.korean;
            }
        });

        for (Student student : list) {
            sb.append(student.name).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb);
    }

}

class Student {

    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

}
