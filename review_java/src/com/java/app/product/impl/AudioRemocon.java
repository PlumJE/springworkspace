package com.java.app.product.impl;

import com.java.app.product.RemoteControl;

public class AudioRemocon implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Andio ON");
	}

	@Override
	public void tunrOff() {
		System.out.println("Andio OFF");
	}

}
