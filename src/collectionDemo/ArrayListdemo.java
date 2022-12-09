package collectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/*
  Generics
  Wrapperclasses
 */
public class ArrayListdemo {
	public static void main(String[] args) {
		ArrayListdemo ad = new ArrayListdemo();
		ad.iterateoverlist();
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

//		System.out.println(li.subList(0, 3));
//
//		System.out.println(li.subList(0, li.size()));
//
//		System.out.println(li.hashCode());

		// li.containsAll(li1)

		Object[] arr = li.toArray();

		Collections.sort(li);
		System.out.println(li);
		Collections.sort(li, Collections.reverseOrder());
		System.out.println(li);

	}

	public void iterateoverlist() {

		ArrayList<String> names = new ArrayList<>();
		names.add("Java");
		names.add("Python");
		names.add("C#");
		names.add("Javascript");
		names.add("Ruby");
		names.add("cobol");
		names.add("Ruby");
		names.add("cobol");

		System.out.println("==== using for loop ===");
		for (int i = 0; i <= names.size() - 1; i++) {
			System.out.print(names.get(i) + " ");
		}

		System.out.println();
		System.out.println("==== using while loop ===");
		int i = 0;
		while (i <= names.size() - 1) {
			System.out.print(names.get(i) + " ");
			i++;
		}
		System.out.println();
		System.out.println("==== using enhance for loop ===");

		for (String x : names) {
			System.out.print(x + " ");
		}

		System.out.println();
		System.out.println("==== using for each with lamda operator ===");

		names.forEach(x -> {
			System.out.print(x + " ");
		});

		System.out.println();
		System.out.println("==== using stream api ===");
		names.stream().forEach(x -> {
			System.out.print(x + " ");
		});
       
		System.out.println();
		System.out.println("==== using iterator ===");

		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
		System.out.println();
		System.out.println("==== using list iterator ===");
		
		ListIterator<String> lit = names.listIterator(2);
		while(lit.hasPrevious()) {
			System.out.print(lit.previous()+" ");
		}
		System.out.println();
        ArrayList<String> tdata = new ArrayList<>();
        
        for(int j=0; j<=names.size()-1; j++) {
        	if(!tdata.contains(names.get(j))) {
        		tdata.add(names.get(j));
        	}
        }
        System.out.println(tdata);
        
        names.stream().distinct().forEach(x->{System.out.print(x+" ");});
	}

}
