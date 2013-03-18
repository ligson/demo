package demo.test;

class Tea<T> {
	public void println() {
		System.out.println(this.getClass().getSimpleName());
	}
}

public class TypeTest extends Tea<TypeTest> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypeTest test = new TypeTest();
		test.println();
	}

}
