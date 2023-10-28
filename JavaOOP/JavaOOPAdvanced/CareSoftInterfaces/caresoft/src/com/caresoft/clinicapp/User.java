package com.caresoft.clinicapp;

public class User {
	protected Integer id;
	protected int pin;

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, int pin) {
		this.id = id;
		this.pin = pin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public boolean setPin(int pin, int requiredLength) {
		requiredLength = 6;
		if (String.valueOf(pin).length() >= requiredLength) {
			this.pin = pin;
			return true;
		} else {
			return false;
		}
	}
}
