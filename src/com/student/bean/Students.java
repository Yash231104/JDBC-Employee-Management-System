package com.student.bean;

import java.io.Serializable;

public class Students implements Serializable{
        
	private int roll;
	private String name;
	private String address;
	private Float per;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getPer() {
		return per;
	}
	public void setPer(Float per) {
		this.per = per;
	}
	public Students(int roll, String name, String address, Float per) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.per = per;
	}
	public Students() {}
	@Override
	public String toString() {
		return  roll + "\t" + name + "\t" + address + "\t" + per + "]";
	};
	
}
