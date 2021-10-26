import java.util.*;
import java.io.*;

// 멀티탭 스케줄링
@SuppressWarnings("unchecked")
class Main {

    static int n, k;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(process());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }
 
    static int process() {
        int count = 0;
        HashSet<Integer> tap = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int now = list.get(i);
            if (tap.size() < n) {
                tap.add(now);
            } else {
                if (tap.contains(now)) {
                    continue;
                } else {
                    HashSet<Integer> set = copySet(tap);
                    for (int j = i + 1; j < list.size(); j++) {
                        if (tap.contains(list.get(j))) {
                            if (set.size() == 1)
                                break;
                            set.remove(list.get(j));
                        }
                    }
                    int t = 0;
                    for (int k : set) {
                        t = k;
                        break;
                    }
                    tap.remove(t);
                    count++;
                    tap.add(now);
                }
            }
        }
        return count;
    }

    static HashSet<Integer> copySet(HashSet<Integer> set) {
        HashSet<Integer> copy = new HashSet<>();
        for (Integer i : set) {
            copy.add(i);
        }
        return copy;
    }

}
