import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import schedulercalc.impl.CancelOrderCalc;
import schedulercalc.impl.SchedulerCalculator;
import schedulercalc.impl.SnackAutoOrderingCalc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================================================================");
        printSchedulerTime();
        System.out.println("================================================================================");
    }

    public static void printSchedulerTime() {
        try {
            Reflections reflections = new Reflections(new ConfigurationBuilder()
                    .addScanners(Scanners.SubTypes.filterResultsBy(s -> true))
                    .forPackages("schedulercalc.impl"));
            Set<Class<? extends SchedulerCalculator>> schedulerCalculatorClasses = reflections.getSubTypesOf(SchedulerCalculator.class);
            for (Class<? extends SchedulerCalculator> clazz : schedulerCalculatorClasses) {
                SchedulerCalculator schedulerCalculator = clazz.getDeclaredConstructor().newInstance();
                schedulerCalculator.printResult();
            }
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
