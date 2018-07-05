package com.forneus.jpmc.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private List<Call> calls;
	private LocalDate suscriptionDate;
	private String id;
	private String name;

	public Client(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.suscriptionDate = LocalDate.now();
		this.calls = new ArrayList<Call>();
	}

	public Double bill(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
