package org.example;

import javax.swing.*;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderApp {
    public static void main(String[] args) {
        System.out.println("Reminder app started...");

        // Your target alarm time. It uses 24 hour system. 0-11 = 0-11 am, 12-23 = 12-11 pm
        LocalTime alarmTime1 = LocalTime.of(10, 0);
        LocalTime alarmTime2 = LocalTime.of(15, 0);
        LocalTime alarmTime3 = LocalTime.of(18, 0);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean alreadyShown1 = false;
            boolean alreadyShown2 = false;           // add for each new alarm
            boolean alreadyShown3 = false;

            @Override
            public void run() {
                LocalTime now = LocalTime.now();

                System.out.println("Current time: " + now);

                // If current time is after alarm time, and we haven’t shown the popup yet
                if (!alreadyShown1 && now.getHour() == alarmTime1.getHour()
                        && now.getMinute() == alarmTime1.getMinute()) {
                    alreadyShown1 = true;
                    showPopup1();
                }
                if (!alreadyShown2 && now.getHour() == alarmTime2.getHour()
                        && now.getMinute() == alarmTime2.getMinute()) {
                    alreadyShown2 = true;
                    showPopup2();
                }
                if (!alreadyShown3 && now.getHour() == alarmTime3.getHour()  // add for each new alarm
                        && now.getMinute() == alarmTime3.getMinute()) {
                    alreadyShown3 = true;
                    showPopup3();
                }
            }
        }, 0, 1000);
    }

    private static void showPopup1() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            frame.setUndecorated(true);
            frame.setAlwaysOnTop(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "action1", "Alarm", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        });
    }

    private static void showPopup2() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            frame.setUndecorated(true);
            frame.setAlwaysOnTop(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "action2", "Alarm", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        });
    }

    private static void showPopup3() {             // add for each new alarm
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            frame.setUndecorated(true);
            frame.setAlwaysOnTop(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "action3", "Alarm", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        });
    }
}

