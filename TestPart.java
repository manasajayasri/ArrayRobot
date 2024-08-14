import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.Part;

public class TestPart extends LockedTestCase {
	
	protected void assertException(Class<? extends Throwable> c, Runnable r) {
		try {
			r.run();
			assertFalse("Exception should have been thrown",true);
		} catch (Throwable ex) {
			assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
		}
	}

	public void testA() {
		Part p = new Part("SN #1234");
		assertEquals(Ts(276290015), p.getSerial());
	}
	
	public void testB() {
		Part p = new Part();
		assertFalse(p.getSerial() == null);
	}
	
	public void testC() {
		Part p1 = new Part();
		Part p2 = new Part();
		assertFalse(p1.getSerial().equals(p2.getSerial()));
	}
	
	public void testD() {
		assertException(NullPointerException.class, () -> new Part(null));
	}
	
	public void testE() {
		Part p = new Part("");
		assertEquals("", p.getSerial());
	}
	
	public void testF() {
		Part p = new Part("RSN6719");
		 // see Section 1 of the Homework
		assertEquals(Ts(605881237), p.toString()); 		
		//The serial number is going be printed as Part(RSN6719), that is how I implemented my toString() method. 
	}
	
	public void testG() {
		Part p = new Part("4.037(e)");
		assertEquals("Part(4.037(e))", p.toString());
	}
	
	public void testH() {
		Part p1 = new Part("AA");
		Part p2 = new Part("AA");
		assertTrue(p1.equals(p2));
	}
	
	public void testI() {
		Part p1 = new Part("Aa");
		Part p2 = new Part("AA");
		assertFalse(p1.equals(p2));
	}
	
	public void testJ() {
		Part p1 = new Part("Aa");
		Part p2 = new Part("BB");
		assertFalse(p1.equals(p2));
	}
	
	public void testK() {
		Part p1 = new Part("SN #1234");
		Part p2 = new Part("SN 1234");
		assertFalse(p1.equals(p2));
	}
	
	public void testL() {
		Part p1 = new Part();
		Part p2 = new Part();
		assertFalse(p1.equals(p2)); // OK to fail once in a billion times
	}
	
	public void testM() {
		Part p1 = new Part("");
		Part p2 = new Part();
		assertFalse(p1.equals(p2));
	}
	
	public void testN() {
		Part p = new Part("");
		assertEquals(0, p.hashCode());
	}
	
	public void testO() {
		String key = "RSN780009";
		assertEquals(-1424399657, key.hashCode());
		Part p = new Part(key);
		assertEquals(Ti(705968173), p.hashCode());
	}
}
