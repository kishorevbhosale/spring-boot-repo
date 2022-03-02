# Spring boot scheduler

## Enable Scheduling : 
Add the `@EnableScheduling` annotation to the main class.

## Scheduling timing details :
Two schedulers :
1) Scheduler run in each 5 sec and add data to db
2) Scheduler run in each 15 sec to fetch the data from db

## Scheduling Tasks : 
1) `@Scheduled(fixedRate = 5000)` - Added in main class - cron run at every 5 sec
2) `@Scheduled(cron = "0/15 * * * * *")` - Added in service class - cron run at every 15 sec

## Scheduled task details : 
Printed the logs to check the cron job status

## parallel scheduling : 
We can also enable parallel scheduling by adding the `@Async` annotation to the scheduled tasks.

## Schedule a Task with Initial Delay : 
We can also use the initialDelay parameter to delay the first execution of the task with the specified number of milliseconds.
e.g. `@Scheduled(fixedRate = 2000, initialDelay = 5000)`


