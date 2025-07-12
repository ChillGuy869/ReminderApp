package org.example;

import javax.swing.*;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderApp {
    public static void main(String[] args) {
        System.out.println("Reminder app started...");

        LocalTime alarmTime1 = LocalTime.of(10, 0);
        LocalTime alarmTime2 = LocalTime.of(15, 0);
        LocalTime alarmTime3 = LocalTime.of(18, 0);

        Timer timer = new Timer(true); // Mark as daemon

        timer.scheduleAtFixedRate(new TimerTask() {
            boolean alreadyShown1 = false;
            boolean alreadyShown2 = false;
            boolean alreadyShown3 = false;

            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                System.out.println("Current time: " + now);

                if (!alreadyShown1 && now.getHour() == alarmTime1.getHour()
                        && now.getMinute() == alarmTime1.getMinute()) {
                    alreadyShown1 = true;
                    showPopup("action 1");
                }

                if (!alreadyShown2 && now.getHour() == alarmTime2.getHour()
                        && now.getMinute() == alarmTime2.getMinute()) {
                    alreadyShown2 = true;
                    showPopup("action 2");
                }

                if (!alreadyShown3 && now.getHour() == alarmTime3.getHour()
                        && now.getMinute() == alarmTime3.getMinute()) {
                    alreadyShown3 = true;
                    showPopup("action 3");
                }
            }
        }, 0, 1000);

        // Keep the main thread alive
        while (true) {
            try {
                Thread.sleep(60000); // Check once per minute to keep the process alive
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showPopup(String message) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            frame.setUndecorated(true);
            frame.setAlwaysOnTop(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null); // center on screen

            // Set size and manually show frame first to grab focus
            frame.setSize(300, 100);
            frame.setVisible(true);
            frame.requestFocus();
            frame.toFront();

            // Display dialog using the frame as parent
            JOptionPane.showMessageDialog(frame, message, "Alarm", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        });
    }

}


