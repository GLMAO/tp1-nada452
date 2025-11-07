package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        testDuTimeService();
    }

    private static void testDuTimeService() {
        TimerService timerService = new DummyTimeServiceImpl();
        Horloge horloge1 = new Horloge("Num 1") ;
        Horloge horloge2= new Horloge("Num 2") ;
        Horloge horloge3= new Horloge("Num 3") ;
        try {
            Thread.sleep(10000); // 10 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
