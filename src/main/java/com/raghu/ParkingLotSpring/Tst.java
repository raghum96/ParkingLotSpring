package com.raghu.ParkingLotSpring;

class A{
	static void fun1() {
		System.out.println("fun1-A");
	}
}

class B extends A{
	static void fun1() {
		System.out.println("fun1-B");
	}
}



public class Tst {
public static void main(String[] args) {
	A a= new B();
	a.fun1();
}
}
