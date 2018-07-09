package com.forneus.jpmc.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
	
	private List<Call> calls;
	private LocalDate suscriptionDate;
	private String id;
	private String name;

	public Client(String id, String name, List<Call> calls) {
		super();
		this.id = id;
		this.name = name;
		this.suscriptionDate = LocalDate.now();
		this.calls = calls;
	}

	public Bill bill(final DatePeriod period) {
		List<Call> callsToBill = calls.stream()
                .filter(call -> period.belongs(call.getStarted().toLocalDate()))
                .collect(Collectors.toList());
		
		return new Bill(callsToBill, this);
	}

	public List<Call> getCalls() {
		return calls;
	}

	public LocalDate getSuscriptionDate() {
		return suscriptionDate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

}
