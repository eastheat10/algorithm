package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 저항
public class A1076 {

    static HashMap<String, long[]> hm = new HashMap<>();

    static void setMap() {
        hm.put("black", new long[]{0, 1});
        hm.put("brown", new long[]{1, 10});
        hm.put("red", new long[]{2, 100});
        hm.put("orange", new long[]{3, 1000});
        hm.put("yellow", new long[]{4, 10000});
        hm.put("green", new long[]{5, 100000});
        hm.put("blue", new long[]{6, 1000000});
        hm.put("violet", new long[]{7, 10000000});
        hm.put("grey", new long[]{8, 100000000});
        hm.put("white", new long[]{9, 1000000000});
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap();
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        long result = Integer.parseInt(hm.get(s1)[0] + "" + hm.get(s2)[0]) * hm.get(s3)[1];

        System.out.println(result);

    }
}
