package programers.hash;

import java.util.HashMap;

public class Main {

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
	public static boolean solution(String[] phoneBook) {
		HashMap<String, Integer> map = new HashMap<>();

		for(int i = 0; i < phoneBook.length; i++) {
			map.put(phoneBook[i], i);
		}

		for(int i = 0; i < phoneBook.length; i++) {
			for(int j = 0; j < phoneBook[i].length(); j++) {
				if(map.containsKey(phoneBook[i].substring(0,j))) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		 String[] phone_book = {"119", "97674223", "1195524421"};
//		 String[] phone_book = {"123", "456", "789"};
//		 String[] phone_book = {"12", "213", "1235", "567", "88"};
		System.out.println(solution(phone_book));

	}
}
