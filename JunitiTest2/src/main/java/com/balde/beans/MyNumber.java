package com.balde.beans;

public class MyNumber {
	int number;
	
	public MyNumber() {
		super();
		this.number = 0;
	}
	
	public MyNumber(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public MyNumber add(MyNumber rhs) {
		this.number += rhs.number;
		return this;
	}
	
	public MyNumber div(MyNumber rhs) {
		if(rhs.number == 0)
			throw new IllegalArgumentException("Cannot divide by 0!");
		this.number /= rhs.number;
		return this;
	}
	
	
}
