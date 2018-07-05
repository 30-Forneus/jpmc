package com.forneus.jpmc.entity;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import com.forneus.jpmc.build.call.strategy.LateNightMinuteStrategy;
import com.forneus.jpmc.build.call.strategy.RegularMinuteFilterStrategy;
import com.forneus.jpmc.build.call.strategy.WeekendDayStategy;
import com.forneus.jpmc.build.call.strategy.WorkingDayFilterStrategy;

enum CallBuilder {
	
	REGULAR {
		@Override
		boolean condition(LocalDateTime when) {
			return new WorkingDayFilterStrategy().is(when) 
					&& new RegularMinuteFilterStrategy().is(when);
		}
	},
	LATE_NIGHT {
		@Override
		boolean condition(LocalDateTime when) {
			return new WorkingDayFilterStrategy().is(when) 
					&& new LateNightMinuteStrategy().is(when);
		}
	},
	WEEKEND {
		@Override
		boolean condition(LocalDateTime when) {			
			return new WeekendDayStategy().is(when);
		}

	};
	

	abstract boolean condition(LocalDateTime when);

	Long minutes(LocalDateTime started, LocalDateTime finished) {
		LocalDateTime currentMinute = started;
		LocalDateTime lastMinute = finished;
		AtomicLong minutes = new AtomicLong(0);
		while (currentMinute.isBefore(lastMinute)) {
			if(condition(currentMinute)) {
				minutes.incrementAndGet();
			}			
			currentMinute = currentMinute.plusMinutes(1);
		}
		return minutes.get();
	}
		
}
