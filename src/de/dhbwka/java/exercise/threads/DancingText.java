package de.dhbwka.java.exercise.threads;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

/**
 * TrafficLight
 */
public class DancingText extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    JTextField text = new JTextField();
    JSpinner interval = new JSpinner();
    String[] fonts = { "Arial", "Comic Sans MS", "Book Antiqua", "Hiragino Kaku Gothic Std", "Kai" };// GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    Thread runner;

    public static void main(String[] args) {
        new DancingText();
    }

    DancingText() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout(0));

        text.setText("Dancing Text :-)");
        pnl.add(text);
        
        interval.setValue(1000);
        pnl.add(interval);

        this.add(pnl);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 200);

        this.runner = new Thread(this);
        this.runner.start();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        int textLength = text.getText().length();
        int baseSize = getWidth() / textLength;
        final int TEXT_HEIGHT = 80;
        final int RGB_LIMIT = 200;
        for (int i = 0; i < textLength; i++) {

            g.setColor(new Color((int) (Math.random() * RGB_LIMIT), (int) (Math.random() * RGB_LIMIT),
                    (int) (Math.random() * RGB_LIMIT)));
            g.setFont(new Font(fonts[(int) (Math.random() * fonts.length)], Font.BOLD,
                    baseSize > TEXT_HEIGHT ? TEXT_HEIGHT : baseSize));
            g.drawString(text.getText().charAt(i) + "", i * baseSize + 10, (int) (Math.random() * TEXT_HEIGHT + 110));
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep((int)interval.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}