import edu.uwm.cs351.ArrayRobot;
import edu.uwm.cs351.Part;

public class TestArrayRobot extends AbstractTestRobot {
	
	@Override // required
	protected void initRobot() {
		r = new ArrayRobot(6);
		// Note: the robot must remain of at least size 5 for the abstract tests.
	}
	
	
	// test of capacity
	public void testCapacity() {
		r = new ArrayRobot(3);
		r.addPart("arm", new Part());
		r.addPart("leg", new Part());
		r.addPart("head", new Part());
		assertFalse(r.addPart("arm", new Part()));
		assertFalse(r.addPart("leg", new Part()));
		assertFalse(r.addPart("head", new Part()));
	}
	
	
	/*
	 * Tests of differing behavior between FixedRobot and ArrayRobot
	 * 
	 * Please note that these Ax tests line up with the Fx tests in the other
	 * class. For example, testF02 and testA02 have the same order of
	 * adds/removals/gets (with attention to type of part) in order to highlight
	 * the differing behavior.
	 */
	
	// test of adding extra parts
	public void testA01() {
		r = new ArrayRobot(10);
		r.addPart("leg", new Part());
		r.addPart("leg", new Part());
		r.addPart("arm", new Part());
		r.addPart("arm", new Part());
		r.addPart("head", new Part());
		
		assertTrue(r.addPart("leg", new Part()));
		assertTrue(r.addPart("arm", new Part()));
		assertTrue(r.addPart("head", new Part()));
		assertTrue(r.addPart("body", new Part()));
	}
	
	// additional tests
	public void testA02() {
		Part p1 = new Part();
		Part p2 = new Part();
		
		r.addPart("leg", p1);
		r.addPart("arm", p2);
		assertEquals(p1, r.removePart(null));
	}
	
	public void testA03() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		
		r.addPart("leg", p1);
		r.addPart("leg", p2);
		r.addPart("arm", p3);
		assertEquals(p1, r.removePart(null));
		assertEquals(p2, r.removePart(null));
	}
	
	public void testA04() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		
		r.addPart("head", p1);
		r.addPart("leg", p2);
		r.addPart("arm", p3);
		r.addPart("leg", p4);
		r.removePart("arm");
		assertEquals(p2, r.removePart("leg"));
		assertEquals(p4, r.getPart(null, 1)); // remember that ArrayRobot implementation skips over nulls
	}
	
	public void testA05() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		Part p5 = new Part();
		
		r.addPart("head", p1);
		r.addPart("leg", p2);
		r.addPart("arm", p3);
		r.addPart("leg", p4);
		r.removePart("arm");
		r.removePart("leg");
		
		r.addPart("leg", p5);
		assertEquals(p5, r.getPart(null, 1));
		assertEquals(p4, r.getPart(null, 2));
	}
	
	public void testA06() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		Part p5 = new Part();
		
		r.addPart("head", p1);
		r.addPart("arm", p4);
		r.addPart("leg", p3);
		r.addPart("arm", p2);
		
		assertEquals(p1, r.getPart(null, 0));
		assertEquals(p1, r.removePart(null));
		assertTrue(r.addPart("body", p5));
		assertEquals(p5, r.getPart(null, 0));
	}
	
	public void testA07() {
		assertException(NegativeArraySizeException.class, () -> new ArrayRobot(-1));
	}
	
	public void testA08() {
		r = new ArrayRobot(0);
		assertFalse(r.addPart("arm", new Part()));
	}
	
	public void testA09() {
		r = new ArrayRobot(0);
		assertNull(r.getPart(null, 0));
	}
	
	public void testA10() {
		r = new ArrayRobot(0);
		assertNull(r.removePart("arm"));
	}
}