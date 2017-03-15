package org.sonatype.bmi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class BmiCalcTest {
	
	@Test
	public void BmitestAge26Height186Weight80() {
		BmiCalculator testBmi = new BmiCalculator(26,186,80); 
		String a = testBmi.result();
		assertEquals("23.12 -> Normal", a);
	}
	@Test
	public void BmitestResultNotEquals() {
		BmiCalculator testBmi3 = new BmiCalculator(26,186,80); 
		String c = testBmi3.result();
		assertNotEquals("26.55 -> Normal", c);
	}
	
	@Test
	public void BmitestAge12Height150Weight40(){
		BmiCalculator testBmi2 = new BmiCalculator(12,150,40);
		String d=testBmi2.result();
		assertEquals("17.78 -> Healthy weight",d);
	
	}
	
}
