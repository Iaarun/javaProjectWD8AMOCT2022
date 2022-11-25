package classesandObjects;

/*
private
default
protected
public
*/
public class AccessModifiers {

	private int age;
	String name;
	protected String uid;
	public String coursename;

	private void test1() {
       System.out.println("Private function");
	}

	void test2() {
		System.out.println("default function");
	}

	protected void test3() {
		System.out.println("protected function");
	}

	public void test4() {
		System.out.println("public function");
	}
	
	public static void test5() {
		System.out.println("public static function");
	}
	
	
	 static public void main(String[] args) {
		AccessModifiers accessmodifier = new AccessModifiers();
		
		accessmodifier.test1();
		accessmodifier.test2();
		accessmodifier.test3();
		accessmodifier.test4();
		
		test5();
	}

}
