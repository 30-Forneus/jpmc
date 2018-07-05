package com.forneus.jpmc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.forneus.jpmc.entity.Client;

public class BillingTest {

	private Client client;
	private LocalDate from;
	private LocalDate to;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void regularCallBillingTest() {
		Double bill = client.bill( from,  to);
		
	}

}
