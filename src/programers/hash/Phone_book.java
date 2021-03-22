package programers.hash;

import java.util.HashMap;

public class Phone_book {

		/*
		boolean result = true;
		int size = phone_book.length;
		for(int i = 0; i < size - 1; i++){
			for(int j = i + 1; j < size; j++){
				System.out.println("phone_book[i] = " + phone_book[i]);
				System.out.println("phone_book[j] = " + phone_book[j]);
				if(phone_book[j].startsWith(phone_book[i])){
					return false;
				}
			}
		}
		return true;
*/
		public static boolean solution(String[] phone_book){
			HashMap<Integer, String> hm = new HashMap<>();
			int min = 1000000;
			for(int i = 0; i < phone_book.length; i++){
				if(phone_book[i].length() < min)
					min = phone_book[i].length();
				hm.put(i, phone_book[i]);
			}

			for(int i = 0; i < hm.size(); i++){
				String number = hm.get(i);
				hm.remove(i);
					for (int j = 0; j < min + 1; j++) {
						if (hm.containsValue(number.substring(0, j))) {
							return false;
						}
					}
				hm.put(i, number);
			}
			return true;
		}

	public static void main(String[] args) {

//		 String[] phone_book = {"119", "97674223", "1195524421"};
		 String[] phone_book = {"123", "456", "789"};
//		 String[] phone_book = {"12", "213", "1235", "567", "88"};
		System.out.println(solution(phone_book));

	}
}
