package com.nt.main;

/**
 * Hello world!
 */
public class App {

	public int sum(int a, int b) {
		return a + b;
	}

	public int sub(int x, int y) {
		return x - y;
	}

	public int mul(int p, int q) {

		System.out.println("mul() method");
		return p * q;
	}
	
	public int findNameLength(String name) {
		System.out.println("App.findNameLength() bug 123 fixing is going on");
		return name.length();
	}

	public String reverse(String name) {
		StringBuffer sb = new StringBuffer(name);
		return sb.reverse().toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
		System.out.println("sum is:: " + app.sum(10, 20));
		System.out.println("sub is:: " + app.sum(20, 10));
		System.out.println("mul is:: " + app.sum(10, 20));
	}
}
