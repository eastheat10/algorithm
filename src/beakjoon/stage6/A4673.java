package beakjoon.stage6;

public class A4673 {

	public static boolean[] self = new boolean[10001];

	public static void self_number() {
		for(int i = 1; i < self.length; i++) {
			int tmp = i;
			String s = Integer.toString(tmp);
			for(int j = 0; j < s.length(); j++) {
				tmp += Integer.parseInt(Character.toString(s.charAt(j)));
			}
			if(tmp <= 10000)
				self[tmp] = true;
		}
	}

	public static void main(String[] args) {
		self_number();
		for(int t = 1; t < self.length; t++) {
			if(!self[t])
				System.out.println(t);
		}

	}

}
