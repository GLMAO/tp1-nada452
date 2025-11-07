package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.clients.CompteARebours;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        testDuTimeService();
        testCompteARebours();
    }

    private static void testDuTimeService() {
        TimerService timerService = new DummyTimeServiceImpl();
        Horloge horloge1 = new Horloge("Num 1",timerService) ;
        Horloge horloge2= new Horloge("Num 2",timerService) ;
        Horloge horloge3= new Horloge("Num 3",timerService) ;
        try {
            Thread.sleep(10000); // 10 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private static void testCompteARebours() {
        TimerService timerService = new DummyTimeServiceImpl();

        System.out.println("=== TEST COMPTE À REBOURS ===");

        // 1. Test avec un compte à rebours de 5
        CompteARebours car1 = new CompteARebours("CAR-5", timerService, 5);

        // 2. Test avec 10 comptes à valeurs aléatoires
        System.out.println("\n=== 10 COMPTES À REBOURS ALÉATOIRES ===");
        for (int i = 0; i < 10; i++) {
            int valeurInitiale = 10 + (int)(Math.random() * 11); // 10-20
            new CompteARebours("CAR-" + (i+1), timerService, valeurInitiale);
        }

        // Garder l'application alive pour voir les résultats
        try {
            Thread.sleep(25000); // 25 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
