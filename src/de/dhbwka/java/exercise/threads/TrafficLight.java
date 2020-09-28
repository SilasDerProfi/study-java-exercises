package de.dhbwka.java.exercise.threads;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * TrafficLight
 */
public class TrafficLight extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private LightPhase[] lightPhases = new LightPhase[4];
    private int curLightphase = 0;
    Thread runner;

    public static void main(String[] args) {
        new TrafficLight();
    }

    TrafficLight() {
        lightPhases[0] = new LightPhase(true, false, false, 4500);
        lightPhases[1] = new LightPhase(true, true, false, 1500);
        lightPhases[2] = new LightPhase(false, false, true, 4000);
        lightPhases[3] = new LightPhase(false, true, false, 2000);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(650, 650);

        this.runner= new Thread(this);
        this.runner.start();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(225, 40, 200, 600);

        g.setColor(Color.WHITE);
        g.fillOval(235, 50, 180, 180);
        g.fillOval(235, 250, 180, 180);
        g.fillOval(235, 450, 180, 180);

        if(lightPhases[curLightphase].red)
        {
            g.setColor(Color.RED);
            g.fillOval(240, 55, 170, 170);
        }

        if(lightPhases[curLightphase].yellow)
        {
            g.setColor(Color.YELLOW);
            g.fillOval(240, 255, 170, 170);
        }

        if(lightPhases[curLightphase].green)
        {
            g.setColor(Color.GREEN);
            g.fillOval(240, 455, 170, 170);
        }
        System.out.println(curLightphase);
    }

    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(lightPhases[curLightphase].duration);
                curLightphase = (curLightphase + 1) % lightPhases.length;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class LightPhase{
        private boolean red;
        private boolean yellow;
        private boolean green;
        private int duration;

        private LightPhase(boolean red, boolean yellow, boolean green, int duration){
            this.red = red;
            this.yellow = yellow;
            this.green = green;
            this.duration = duration;
        }
    }
}