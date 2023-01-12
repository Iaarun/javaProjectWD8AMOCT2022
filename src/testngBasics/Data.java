package testngBasics;

import org.testng.annotations.DataProvider;

public class Data {
	@DataProvider(name = "mydata")
	public Object[][] logindata() {

		Object[][] data = new Object[1][2];

		data[0][0] = "cbatest7@gmail.com";
		data[0][1] = "cba@test";

		return data;

	}

}
