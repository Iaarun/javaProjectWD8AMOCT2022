package encapdemo;
//POJO  - plain old java object
public class Employee {

	private String name;
	private String uid;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age >= 18 && age <=60) {
			this.age = age;
		}
		
	}
	

}
