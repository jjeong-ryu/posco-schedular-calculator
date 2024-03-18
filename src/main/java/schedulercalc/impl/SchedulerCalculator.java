package schedulercalc.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SchedulerCalculator {
    LocalDateTime now = LocalDateTime.now();
    void printResult();
    long calc();
}
