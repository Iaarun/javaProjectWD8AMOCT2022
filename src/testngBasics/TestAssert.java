package testngBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssert {
	
	@Test
	public void assertTest() {
		Assert.assertEquals(true, false," comparison fails");
	}

}
