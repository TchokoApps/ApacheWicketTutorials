package com.tchokoapps.wicket.tutorial.chap03.section_3_1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cheese implements Serializable {
	private String name;
	private String description;
	private double price;

	public Cheese(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
}
