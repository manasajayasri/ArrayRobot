import edu.uwm.cs351.FixedRobot;
import edu.uwm.cs351.Part;

public class TestFixedRobot extends AbstractTestRobot {
	
	@Override // required
	protected void initRobot() {
		r = new FixedRobot();
	}
	
	
	/*
	 * Tests of differing behavior between FixedRobot and ArrayRobot
	 * 
	 * Please note that these Fx tests line up with the Ax tests in the other
	 * class. For example, testF02 and testA02 have the same order of
	 * adds/removals/gets (with attention to type of part) in order to highlight
	 * the differing behavior.
	 */
	
	// test of adding extra parts (doubles as a test of capacity)
	public void testF01() {
		r.addPart("leg", new Part());
		r.addPart("leg", new Part());
		r.addPart("arm", new Part());
		r.addPart("arm", new Part());
		r.addPart("head", new Part());
		
		assertFalse(r.addPart("leg", new Part()));
		assertFalse(r.addPart("arm", new Part()));
		assertFalse(r.addPart("head", new Part()));
		assertFalse(r.addPart("body", new Part()));
	}
	
	// additional tests
	public void testF02() {
		Part p1 = new Part();
		Part p2 = new Part();
		
		r.addPart("leg", p1);
		r.addPart("arm", p2);
		assertEquals(p2, r.removePart(null));
	}
	
	public void testF03() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		
		r.addPart("leg", p1);
		r.addPart("leg", p2);
		r.addPart("arm", p3);
		assertEquals(p3, r.removePart(null));
		assertEquals(p1, r.removePart(null));
	}
	
	public void testF04() {
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
		assertEquals(p1, r.getPart(null, 1));
	}
	
	public void testF05() {
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
		assertEquals(p4, r.getPart(null, 1));
		assertEquals(p1, r.getPart(null, 2));
	}
	
	public void testF06() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		Part p5 = new Part();
		
		r.addPart("head", p1);
		r.addPart("arm", p4);
		r.addPart("leg", p3);
		r.addPart("arm", p2);
		
		assertEquals(p4, r.getPart(null, 0));
		assertEquals(p4, r.removePart(null));
		assertFalse(r.addPart("body", p5));
		assertEquals(p2, r.getPart(null, 0));
	}
}
