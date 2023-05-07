package programers.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// 전화번호 목록
public class Phone_book {

    public static boolean solution(String[] phone_book) {
    	int len = phone_book.length;
		HashSet<String> hs = new HashSet<>();
//        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
//			hm.put(i, phone_book[i]);
			hs.add(phone_book[i]);
		}

		Iterator<String> iter = hs.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			for (int i = 0; i < s.length(); i++) {
				if (hs.contains(s.substring(0, i))) {
					return false;
				}
			}
		}
		return true;

//		for (int i = 0; i < hm.size(); i++) {
//            String number = hm.get(i);
//            hm.remove(i);
//            for (int j = 0; j < len + 1; j++) {
//                if (hm.containsValue(number.substring(0, j))) {
//                    return false;
//                }
//            }
//            hm.put(i, number);
//        }
//        return true;
    }

    public static void main(String[] args) {

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "213", "1235", "567", "88"};

        System.out.println(solution(phone_book1));
        System.out.println(solution(phone_book2));
        System.out.println(solution(phone_book3));

    }
}
