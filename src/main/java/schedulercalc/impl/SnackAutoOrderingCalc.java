package schedulercalc.impl;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.*;

public class SnackAutoOrderingCalc implements SchedulerCalculator {

    @Override
    public void printResult() {
        System.out.println("SnackAutoOrdering 스케줄러의 등록 시간 : " + calc() + "분");
    }
    @Override
    public long calc() {
        // 월요일 0시 ~ 0시 40분 사이인 경우
        if(now.getDayOfWeek().equals(MONDAY) && now.getHour() == 0 && now.getMinute() >= 0 && now.getMinute() <= 40){
            return Duration.between(now, LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 40))).toMinutes();
        }
        // 그 외의 시
        LocalDate targetLocalDate = now.with(TemporalAdjusters.next(MONDAY)).toLocalDate();
        return Duration.between(now, LocalDateTime.of(targetLocalDate, LocalTime.of(0, 40))).toMinutes();
    }
}
