package com.sapient.day3.observer;

import java.util.Observer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventSource eventSource = new EventSource();
		
		Observer o1 = new ResponseHandler1();
		Observer o2 = new ResponseHandler2();
		
		eventSource.addObserver(o1);
		eventSource.addObserver(o2);
		
		Thread observable = new Thread(eventSource);
		observable.start();
	}

}
