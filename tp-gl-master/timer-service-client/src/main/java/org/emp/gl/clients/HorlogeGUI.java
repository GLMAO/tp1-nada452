package org.emp.gl.clients;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeGUI extends JFrame implements TimerChangeListener {
    private TimerService timerService;
    private JLabel timeLabel;

    public HorlogeGUI(TimerService timerService, String title) {
        this.timerService = timerService;


        setTitle("Horloge - " + title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationByPlatform(true);
        setResizable(false);


        initializeComponents();

        this.timerService.addTimeChangeListener(this);


        updateTimeDisplay();

        setVisible(true);
    }

    private void initializeComponents() {

        setLayout(new BorderLayout());


        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        timeLabel.setForeground(Color.MAGENTA);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        add(timeLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(e -> {
            timerService.removeTimeChangeListener(this);
            dispose();
        });
        add(closeButton, BorderLayout.SOUTH);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            updateTimeDisplay();
        }
    }

    private void updateTimeDisplay() {
        SwingUtilities.invokeLater(() -> {
            if (timerService != null && timeLabel != null) {
                String time = String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes());
                timeLabel.setText(time);
            }
        });
    }
}