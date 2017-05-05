package tests.junit.sim.atomic;

import org.jLOAF.inputs.AtomicInput;
import org.jLOAF.inputs.Feature;
import org.jLOAF.sim.atomic.PercentDifference;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PercentDifferenceTest {
	
	@Test
	public void TestPDNotSame(){
		AtomicInput i1 = new AtomicInput("h1",new Feature(1.6));
		AtomicInput i2 = new AtomicInput("h2",new Feature(1.2));
		PercentDifference p = new PercentDifference();
		assertEquals(p.similarity(i1,i2),0.857,0.001);
	}
	
	@Test
	public void TestPDDividebyZero(){
		AtomicInput i1 = new AtomicInput("h1",new Feature(1.6));
		AtomicInput i2 = new AtomicInput("h2",new Feature(-1.6));
		PercentDifference p = new PercentDifference();
		assertEquals(p.similarity(i1,i2),0.0,0.001);
	}
	
}
