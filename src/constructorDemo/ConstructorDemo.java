package constructorDemo;

import java.util.Scanner;

class Box {
	int length;
	int width;
	int height;

	public Box(int length, int width, int height) {
		this.test();
		this.length = length;
		this.width = width;
		this.height = height;
	}

   	Box() {
		this(94, 25, 40);
       System.out.println("Non parametrised constructor");
	}
	
	public void test() {
		System.out.println("test function in Box class");
	}
	

	// non parameterized

}

public class ConstructorDemo {

	public static void main(String[] args) {
	//	Box box = new Box(150, 200, 350);
		Box box = new Box();

		System.out.println(box.length);
		System.out.println(box.width);
		System.out.println(box.height);
		
		
		
		
	}
}
