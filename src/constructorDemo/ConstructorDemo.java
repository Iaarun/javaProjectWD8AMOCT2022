package constructorDemo;

import java.util.Scanner;

class Box {
	int length;
	int width;
	int height;

	public Box(int length, int width, int height) {
		this.length = length;
		width = width;
		height = height;
	}

	Box() {

	}

	Box(int a) {

	}
	
	Box(double a) {

	}

	

	// non parameterized

}

public class ConstructorDemo {

	public static void main(String[] args) {
		Box box = new Box(150, 200, 350);

		System.out.println(box.length);
		System.out.println(box.width);
		System.out.println(box.height);
		
		
	}
}
