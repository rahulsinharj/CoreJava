package com;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class MySchedular {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static Runnable scTask;
	private static ScheduledThreadPoolExecutor schedulerService;
	private static ScheduledFuture<?> futureSchedule;

	private Calendar schedulerCal;
	private Calendar localCal;
	private String scheduledTime;
	private String currentDayTime;
	private Long scheduledTimeInMilliSec;
	
	public static void main(String[] args) {

		MySchedular mySchedular = new MySchedular();
		mySchedular.initiateSTAResultsScheduler1();
	}

	private void initiateSTAResultsScheduler1() {
		try {
			long startSchedulerAfterMiliSec = setSchedule("00:35");

			String zoneFromCurrentTimeStamp = currentDayTime.substring(20, 23);
			LOGGER.info("** Timezone of Local server : " + zoneFromCurrentTimeStamp);

			scTask = new Runnable() {

				@Override
				public void run() {
					try {
						LOGGER.info("** Calling the SCHEDULED_TASK**");

						System.out.println("Schedular task is called !!!");

					} catch (Exception e) {
						LOGGER.severe(e.getMessage());
					}
				}
			};

			schedulerService = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
			schedulerService.setRemoveOnCancelPolicy(true);
			futureSchedule = schedulerService.scheduleAtFixedRate(scTask, startSchedulerAfterMiliSec, 86400000, TimeUnit.MILLISECONDS);
			LOGGER.info("** Future task will run after :" + futureSchedule.getDelay(TimeUnit.MINUTES) + " minutes");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long setSchedule(String key) {

		int hour = Integer.parseInt(key.substring(0, key.indexOf(":")));
		int min = Integer.parseInt(key.substring(key.indexOf(":") + 1));

		schedulerCal = Calendar.getInstance();
		schedulerCal.set(Calendar.HOUR, hour);
		schedulerCal.set(Calendar.MINUTE, min);
		schedulerCal.set(Calendar.SECOND, 0);
		
		localCal = Calendar.getInstance();
		Long currentTimeInMilliSec = localCal.getTime().getTime();
		currentDayTime = localCal.getTime().toString();

		if (schedulerCal.getTime().getTime() < currentTimeInMilliSec) {			// matlab ki agar current time 1000 mili sec hai, aur scheduled time 800mili sec hua, malab ki wo already bit chuka hai, add a day more 
			schedulerCal.add(Calendar.DATE, 1);
		}

		scheduledTimeInMilliSec = schedulerCal.getTime().getTime();
		scheduledTime = schedulerCal.getTime().toString();
		LOGGER.info("**Scheduled start time for the task : " + scheduledTime + "***" + scheduledTimeInMilliSec);
		LOGGER.info("**Current time of the day		  : " + currentDayTime + "***" + currentTimeInMilliSec);

		long startScheduler = scheduledTimeInMilliSec - currentTimeInMilliSec;
		return startScheduler;

	}

}
