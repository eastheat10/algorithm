package algo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		set.add("C");
		set.add("A");
		set.add("B");

		System.out.println("set = " + set);

		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
