package homework;

import java.util.*;
import java.io.*;


public class Test {

    static void bubbleSort(Conference[] A,int p,int r) {
        Conference temp;
        for(int last=r;last>p;last--) {
            for(int first=p;first<last;first++) {
                if(A[first+1].getFinish()<A[first].getFinish()) {
                    temp=A[first+1];
                    A[first+1]=A[first];
                    A[first]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hw11_1:김재연");
        Scanner sc = new Scanner(System.in);
        String name;
        int start,finish;
        int maxTime=0,count=0;
        System.out.print("신청 회의 수 입력:");
        int n = sc.nextInt();
        Conference[] con = new Conference[n];
        Conference[] result = new Conference[n];
        System.out.println(n);
        System.out.println("선정된 회의 스케줄:");
        for(int i=0;i<n;i++) {
            System.out.println("입력 : ");
            String s = sc.nextLine();
            System.out.println("====" + s + "====");
            StringTokenizer st = new StringTokenizer(s);
            name = st.nextToken();   // 회의 이름
            start = Integer.parseInt(st.nextToken());   // 시작시간
            finish = Integer.parseInt(st.nextToken());    // 종료시간
            con[i]=new Conference(name,start,finish);
        }
        bubbleSort(con,0,n-1);
        for(int i=0;i<n;i++) {
            if(con[i].getStart()<=6 && con[i].getFinish()>=23)
                continue;
            if(maxTime <= con[i].getStart()) {
                result[count++]=con[i];
                maxTime=con[i].getFinish();
            }
        }
        System.out.println("선정된 회의 수 = " + count);
        for(int i=0;i<count;i++) {
            System.out.println(result[i].getName() + "(" + result[i].getStart() + "," + result[i].getFinish() +")");
        }
        sc.close();
    }

}
class Conference {
    String name;
    int start;
    int finish;

    public Conference(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.finish = end;
    }

    @Override
    public String toString() {
        return name + " (" + start + ", " + finish + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int end) {
        this.finish = end;
    }
}