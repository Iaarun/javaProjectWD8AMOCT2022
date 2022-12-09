package collectionDemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		hashmapinterate();
	}
	 public static void hashmapinterate() {
		 HashMap<Integer, String> map = new HashMap<>();
			map.put(101, "Virat");
			map.put(102, "Rahul");
			map.put(103, "Rohit");
			map.put(104, "Rishabh");
			map.put(104, "Shikhar");
			map.putIfAbsent(105, "Pujara");
			
			System.out.println("===Iterate over key====");
			
			for(Integer k: map.keySet()) {
				System.out.println(k);
			}
			
			System.out.println("===Iterate over Value====");
			for(String v: map.values()) {
				System.out.println(v);
			}
			
			System.out.println("===Iterate over map for each and lambda ====");
			map.forEach((k, v)->{System.out.println(k+" | "+v);});
			
			System.out.println("===Iterate using stream====");
			map.entrySet().stream().forEach(x->{
				System.out.println(x.getKey()+">>"+x.getValue());
			});
	 }

	public static void createHashmap() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(101, "Virat");
		map.put(102, "Rahul");
		map.put(103, "Rohit");
		map.put(104, "Rishabh");
		map.put(104, "Shikhar");
		map.putIfAbsent(105, "Pujara");
		map.size();
		System.out.println(map);
		System.out.println(map.get(106));
		System.out.println(map.getOrDefault(106, "Arun"));
		System.out.println(map.containsKey(105));
		System.out.println(map.containsValue("Pujara"));
		
	//	map.clear();
		System.out.println(map.remove(105));
		
	}

}
