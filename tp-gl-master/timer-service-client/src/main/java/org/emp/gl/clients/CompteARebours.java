package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {
    private String name;
    private TimerService timerService;
    private int compteur;

    public CompteARebours(String name, TimerService timerService, int initialValue) {
        this.name = name;
        this.timerService = timerService;
        this.compteur = initialValue;
        this.timerService.addTimeChangeListener(this);
        System.out.println("CompteARebours " + name + " initialisé avec " + compteur + " secondes");
    }

    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            if (compteur > 0) {
                compteur--;
                System.out.println(name + " : " + compteur);

                if (compteur == 0) {
                    System.out.println(name + " : Terminé! Désinscription...");
                    timerService.removeTimeChangeListener(this);
                }
            }
        }}
}

