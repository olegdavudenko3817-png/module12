package task1;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InputTime {
    static void main(String[] args) {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(2);

        long startTime = System.currentTimeMillis();

        timer.scheduleAtFixedRate(() -> {
            long expires = (System.currentTimeMillis() - startTime) / 1000;
                           System.out.println("час від запуску: " + expires + " секунд");
        },0,1, TimeUnit.SECONDS);

        timer.scheduleAtFixedRate(() -> {
            System.out.println("Минуло 5 секунд");
        },5,5,TimeUnit.SECONDS);

    }
}
