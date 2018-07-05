package com.forneus.jpmc.build.call.strategy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.TemporalAdjusters;

public abstract class BuildCallStrategy {
	
	abstract boolean is(LocalDateTime when);
	
	public ChronoLocalDateTime<?> ofThisWeek(LocalDateTime when, DayOfWeek dow) {
		return LocalDateTime.of(when.with(TemporalAdjusters.next(dow)).toLocalDate(), LocalTime.of(0, 0));
	}


}
