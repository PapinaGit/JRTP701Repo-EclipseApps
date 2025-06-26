package com.nt.main;

/**
 * Hello world!
 */
public class App {
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int sub(int x, int y) {
		return x-y;
	}
	
	public int mul(int p, int q) {
		return p*q;
	}
	
	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        App app = new App();
        System.out.println("sum is:: "+app.sum(10, 20));
        System.out.println("sub is:: "+app.sum(20, 10));
        System.out.println("mul is:: "+app.sum(10, 20));
    }
}
