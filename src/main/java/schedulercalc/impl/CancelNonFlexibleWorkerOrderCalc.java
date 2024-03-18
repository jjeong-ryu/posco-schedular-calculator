package schedulercalc.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CancelNonFlexibleWorkerOrderCalc implements SchedulerCalculator {
    @Override
    public void printResult() {
        System.out.println("CancelNonFlexibleWorkerOrderCalc 스케줄러의 등록 시간 : " + calc() + "분");
    }
    @Override
    public long calc() {
        // 자정 ~ 0시 30분인 경우
        if(now.getHour() == 0 && now.getMinute() >= 0 && now.getMinute() <= 30){
            return 30 - now.getMinute();
        }
        return Duration.between(now, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(0, 30))).toMinutes();
    }
}
