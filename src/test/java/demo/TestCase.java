package demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class TestCase {
	
	
	@Test
	public void TestOne() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void TestTwo() {
		Assert.assertFalse(true);
	}
	

	@Test(dependsOnMethods = {"TestTwo"})
	public void Testthree() {
		Assert.assertFalse(false);
	}
}
