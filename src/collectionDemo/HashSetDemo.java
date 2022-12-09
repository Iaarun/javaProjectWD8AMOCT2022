package collectionDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		hsetIterate();
	}

	public static void createhaset() {
		HashSet<String> hset = new HashSet<>();
		hset.add("Java");
		hset.add("Python");
		hset.add("C#");
		hset.add("Javascript");
		hset.add("Ruby");
		hset.add("cobol");
		hset.add("Ruby");
		hset.add("cobol");

		System.out.println(hset);

		System.out.println(hset.size());
		System.out.println(hset.isEmpty());
		System.out.println(hset.contains("C#"));
		HashSet<String> hset1 = new HashSet<>();
		hset1.add("Java1");
		hset1.add("Python1");
		hset1.add("C1#");
		System.out.println(hset.addAll(hset1));

		System.out.println(hset);
		hset.removeAll(hset1);
		System.out.println(hset);
	}

	public static void removeduplicate() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Java");
		names.add("Python");
		names.add("C#");
		names.add("Javascript");
		names.add("Ruby");
		names.add("cobol");
		names.add("Ruby");
		names.add("cobol");

		System.out.println(names);

		HashSet<String> set1 = new HashSet<>(names);
		ArrayList<String> li1 = new ArrayList<>(set1);
		System.out.println(li1);
	}

	public static void hsetIterate() {
		HashSet<String> hset = new HashSet<>();
		hset.add("Java");
		hset.add("Python");
		hset.add("C#");
		hset.add("Javascript");
		hset.add("Ruby");
		hset.add("cobol");
		hset.add("Ruby");
		hset.add("cobol");
		System.out.println("==== using for each with lamda operator ===");

		hset.forEach(x -> {
			System.out.print(x + " ");
		});

		System.out.println();
		System.out.println("==== using enhance for each ===");
		for (String x : hset) {
			System.out.print(x + " ");
		}

		System.out.println();
		System.out.println("==== using stream ===");
		hset.stream().forEach(x -> {
			System.out.print(x + " ");
		});

		System.out.println();
		System.out.println("==== using iterator ===");

		Iterator<String> it = hset.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}

	}

}
