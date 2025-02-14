package com.java.app.product.impl;

import com.java.app.product.RemoteControl;

public class TvRemocon implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("TV ON");
	}

	@Override
	public void tunrOff() {
		System.out.println("TV OFF");
	}


}
