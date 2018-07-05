package com.forneus.jpmc.build.call.strategy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WorkingDayFilterStrategy extends BuildCallStrategy {

	@Override
	public boolean is(LocalDateTime when) {
		return (when.isAfter(ofThisWeek(when, DayOfWeek.MONDAY)) &&
				when.isBefore(ofThisWeek(when, DayOfWeek.SATURDAY))) ||
				when.isEqual(ofThisWeek(when, DayOfWeek.MONDAY));
	}

}
