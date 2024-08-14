import edu.uwm.cs.junit.LockedTestCase;

public class UnlockTest {
	public static void main(String[] args){
		unlock("TestPart");
		unlock("AbstractTestRobot");
	}
	
	private static void unlock(String classname){
		unlock(classname,classname);
	}
	
	private static void unlock(String infoName, String fileName) {
		LockedTestCase.unlockAll(infoName, fileName);
		System.out.format("Tests in %s.java are unlocked.%n"
				+ "You can run it against your progam now.%n"
				, fileName);
	}
}
