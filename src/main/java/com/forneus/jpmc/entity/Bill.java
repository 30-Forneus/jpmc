package com.forneus.jpmc.entity;

import java.time.LocalDate;
import java.util.List;

public class Bill {
	
	private static final int MONTHS_FOR_NEW_CLIENT = 3;
	private List<Call> calls;
	private LocalDate billingDate;
	private Client client;
	
	public Bill(List<Call> callsToBill, Client client) {
		super();
		this.calls = callsToBill;
		this.billingDate = LocalDate.now();
		this.client = client;
	}

	public Double amount() {
		Double total = 0.0;
		for (Call call : calls) {
			total = total + call.getWeekendMinutes() * CallBuilder.WEEKEND.tariff();
			total = total + call.getLateNightMinutes() * CallBuilder.LATE_NIGHT.tariff();
			total = total + call.getRegularMinutes() * regularTariff();
			total = (call.isInternational() ? 2 * total : total);
		}
		return total;		
	}
	
	private Double regularTariff() {
		return isNewClient()? CallBuilder.LATE_NIGHT.tariff():CallBuilder.REGULAR.tariff();
	}

	public Boolean isNewClient() {
		return this.client.getSuscriptionDate().plusMonths(MONTHS_FOR_NEW_CLIENT).isAfter(billingDate);
	}
}
