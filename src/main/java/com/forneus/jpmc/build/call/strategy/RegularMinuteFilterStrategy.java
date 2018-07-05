package com.forneus.jpmc.build.call.strategy;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RegularMinuteFilterStrategy extends BuildCallStrategy {

	private static final int FROM_HOUR = 3;
	private static final int FROM_MINUTE = 59;
	private static final int TO_HOUR = 22;
	private static final int TO_MINUTE = 00;

	@Override
	public boolean is(LocalDateTime when) {
		return when.toLocalTime().isAfter(LocalTime.of(FROM_HOUR, FROM_MINUTE))
				&& when.toLocalTime().isBefore(LocalTime.of(TO_HOUR, TO_MINUTE));
	}

}
