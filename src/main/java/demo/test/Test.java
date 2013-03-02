package demo.test;

import static java.lang.System.out;
import demo.test.Demo.Demo1;
import demo.test.Demo.Demo2;

class Demo {
	public Demo() {
		out.println("demo");
	}

	// 内部类
	class Demo1 {
		public Demo1() {
			out.println("demo1");
		}

		public void test() {
			out.println("test in demo1");
		}
	}

	class Demo2 {
		public Demo1 test() {
			// 匿名类
			Demo1 demo1 = new Demo1() {
				public void test() {
					out.println("test in demo2");
				}
			};
			return demo1;
		}
	}
}

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 demo1 = new Demo().new Demo1();
		Demo2 demo2 = new Demo().new Demo2();
		Demo1 demo12 = demo2.test();
		demo12.test();

	}

}
