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
		Boolean shouldCount(LocalDateTime when) {
			return new WorkingDayFilterStrategy().is(when) 
					&& new RegularMinuteFilterStrategy().is(when);
		}

		@Override
		Double tariff() {
			return 0.05;
		}
	},
	LATE_NIGHT {
		@Override
		Boolean shouldCount(LocalDateTime when) {
			return new WorkingDayFilterStrategy().is(when) 
					&& new LateNightMinuteStrategy().is(when);
		}

		@Override
		Double tariff() {
			return 0.02;
		}
	},
	WEEKEND {
		@Override
		Boolean shouldCount(LocalDateTime when) {			
			return new WeekendDayStategy().is(when);
		}

		@Override
		Double tariff() {
			return 0.01;
		}

	};
	
	abstract Boolean shouldCount(LocalDateTime when);
	abstract Double tariff();

	Long minutes(final LocalDateTime started, final LocalDateTime finished) {
		LocalDateTime currentMinute = started;
		final LocalDateTime lastMinute = finished;
		AtomicLong minutes = new AtomicLong(0);
		while (currentMinute.isBefore(lastMinute)) {
			if(shouldCount(currentMinute)) {
				minutes.incrementAndGet();
			}			
			currentMinute = currentMinute.plusMinutes(1);
		}
		return minutes.get();
	}
		
}
