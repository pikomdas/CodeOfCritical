package rnd;

public class extendClassArray {

	class A extends extendClassArray {
		int i = 10;
	}

	class B extends A {
		int j = 20;
	}

	class C extends B {
		int k = 30;
	}

	class D extends C {
		int m = 40;
	}

	public static void main(String[] args) {
		A[] a = { new A(), new B(), new C(), new D() };

		System.out.println(a[3]);

		System.out.println(a[2]);

		System.out.println(a[1]);

		System.out.println(a[0]);
	}

}
