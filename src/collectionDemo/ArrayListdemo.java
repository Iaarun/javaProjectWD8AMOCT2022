package collectionDemo;

import java.util.ArrayList;

/*
  Generics
  Wrapperclasses
 */
public class ArrayListdemo {
	public static void main(String[] args) {
		ArrayListdemo ad = new ArrayListdemo();
		ad.createArrayList();
	}

	public void wrapperdemo() {
		Integer a = new Integer(21);
		int num = a; // unboxing

		Integer b = a; // autoboxing

		ArrayList<Integer> li = new ArrayList();
	}

	public void createArrayList() {
		// default size of arraylist is 16 loadfactor = .75 16*.75= 12 28
		ArrayList<String> li = new ArrayList();
		System.out.println(li);
		System.out.println(li.size());

		li.add("Java");
		li.add("Python");
		System.out.println(li);

		System.out.println(li.get(1));
		li.add(0, "Ruby");
		System.out.println(li);
		li.set(0, "JavaScript");
		System.out.println(li);

		System.out.println(li.contains("Java1"));

		System.out.println(li.indexOf("Java"));
		System.out.println(li.lastIndexOf("Java"));
		System.out.println(li.isEmpty());

		// System.out.println(li.remove("JavaScript1"));

		ArrayList<String> li1 = new ArrayList();

		li1.add("Groovy");
		li1.add("cobol");

		li.addAll(0, li1);
		System.out.println(li);

		System.out.println(li.subList(0, 3));

		System.out.println(li.subList(0, li.size()));

		System.out.println(li.hashCode());

		// li.containsAll(li1)

		Object[] arr = li.toArray();

	}
}
