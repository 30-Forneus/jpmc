package com.forneus.jpmc.entity;

import java.time.LocalDate;

public class DatePeriod {
	private LocalDate from; 
	private LocalDate to;
	
	public DatePeriod(LocalDate date1, LocalDate date2) {
		super();
		
		if(date2.isBefore(date1)) {
			LocalDate hold = date1;
			date1 = date2;
			date2 = hold;
		}
		this.from = date1;
		this.to = date2;
	}

	public boolean belongs(LocalDate date) {		
		return (date.isAfter(from) && date.isBefore(to)) || date.isEqual(from) || date.isEqual(to) ;
	}
	
	

}
