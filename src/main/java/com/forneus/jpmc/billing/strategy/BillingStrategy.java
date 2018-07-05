package com.forneus.jpmc.billing.strategy;

import com.forneus.jpmc.entity.Call;

public interface BillingStrategy {

	public void bill(Call call);
}
