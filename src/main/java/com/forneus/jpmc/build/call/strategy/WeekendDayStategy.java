package com.forneus.jpmc.build.call.strategy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WeekendDayStategy extends BuildCallStrategy {

	@Override
	public boolean is(LocalDateTime when) {
		return (when.isAfter(ofThisWeek(when, DayOfWeek.SATURDAY)) &&
				when.isBefore(ofThisWeek(when, DayOfWeek.MONDAY))) ||
				when.isEqual(ofThisWeek(when, DayOfWeek.SATURDAY));
	}

}
