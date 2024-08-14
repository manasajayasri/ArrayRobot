import edu.uwm.cs351.FixedRobot;
import edu.uwm.cs351.Part;
import edu.uwm.cs351.Robot;
import junit.framework.TestCase;

public class ExtraTests extends TestCase {

	protected Robot r;
	
	@Override // implementation
	protected void setUp() {
		r = new FixedRobot();
	}
	
	public void test39() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		Part p5 = new Part();
		
		r.addPart(new String("arm"), p1);
		r.addPart("arm", p2);
		r.addPart("leg", p3);
		r.addPart("leg", p4);
		r.addPart("head", p5);
		
		assertEquals(p2, r.getPart(new String("arm"), 1));
	}
	
	public void test40() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		Part p5 = new Part();
		
		r.addPart("arm", p1);
		r.addPart("arm", p2);
		r.addPart("leg", p3);
		r.addPart("leg", p4);
		r.addPart("head", p5);
		
		assertEquals(p3, r.getPart(new String("leg"), 0));
	}
	
	public void test42() {
		Part p1 = new Part();
		Part p2 = new Part();
		Part p3 = new Part();
		Part p4 = new Part();
		Part p5 = new Part();
		
		r.addPart("arm", p1);
		r.addPart("arm", p2);
		r.addPart("leg", p3);
		r.addPart("leg", p4);
		r.addPart("head", p5);
		
		assertEquals(p5, r.getPart(new String("head"), 0));
	}

}

