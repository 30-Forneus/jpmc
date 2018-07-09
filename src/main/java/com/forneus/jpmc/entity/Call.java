package com.forneus.jpmc.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Call {
	
	private LocalDateTime started;
	private LocalDateTime finished;
	private Boolean international;
	private Long lateNightMinutes;
	private Long weekendMinutes;
	private Long regularMinutes;

	public Call(LocalDateTime started, LocalDateTime finished, Boolean international) {
		super();
		this.started = started;
		this.finished = finished;
		this.international = international;
		this.regularMinutes = CallBuilder.REGULAR.minutes(started, finished);
		this.lateNightMinutes = CallBuilder.LATE_NIGHT.minutes(started, finished);
		this.weekendMinutes = CallBuilder.WEEKEND.minutes(started, finished);
	}
	
	public Long totalMinutes() {
		return ChronoUnit.MINUTES.between(started, finished);
	}

	public LocalDateTime getStarted() {
		return started;
	}

	public LocalDateTime getFinished() {
		return finished;
	}

	public Boolean isInternational() {
		return international;
	}

	public Long getLateNightMinutes() {
		return lateNightMinutes;
	}

	public Long getWeekendMinutes() {
		return weekendMinutes;
	}

	public Long getRegularMinutes() {
		return regularMinutes;
	}
	
}
