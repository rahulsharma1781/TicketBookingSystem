package com.org.work.booking;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import static java.time.temporal.ChronoUnit.DAYS;
import org.springframework.scheduling.annotation.Scheduled;
import com.org.work.booking.respository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
public class ReleaseSeatsOldDayBooking {
	private ScreeningRepository screeningRepository;

    @Autowired
    public ReleaseSeatsOldDayBooking(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }
    
    /*
     * This method uses cron 0 0 0 * * ? 
     * (run every day midnight) to delete screenings which are already days old.
     */

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteSevenDayOldScreening() {
        LocalDate today = LocalDate.now();

        screeningRepository.deleteAllInBatch(screeningRepository.findAll()
        		.stream()
        		.filter(screening -> DAYS.between(screening.getDate(), today) > 1)
        		.collect(Collectors.toList()));

        log.info("Clear day old screenings");
    }

}