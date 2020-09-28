package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * CurrencyCalculator
 */
public class CurrencyCalculator {

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Frame1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.setSize(400, 100);
        frame1.setTitle("Currency converter");

        JTextPane tb = new JTextPane();
        tb.setText("Please enter amount to convert!");

        JButton eurUsd = new JButton("EUR -> USD");
        eurUsd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tb.setText(Double.parseDouble(tb.getText()) * 1.14 + "");
                } catch (NumberFormatException n) {
                    tb.setText("Der eingegebene Text ist keine Zahl, Vallah");
                }
            }
        });

        JButton usdEur = new JButton("USD -> EUR");
        usdEur.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tb.setText(Double.parseDouble(tb.getText()) / 1.14 + "");
                } catch (NumberFormatException n) {
                    tb.setText("Der eingegebene Text ist keine Zahl, Vallah");
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame1.add(tb, BorderLayout.NORTH);

        JPanel pnl = new JPanel();
        pnl.add(eurUsd);
        pnl.add(usdEur);
        pnl.add(cancel, BorderLayout.EAST);
        frame1.add(pnl, BorderLayout.SOUTH);

        frame1.setVisible(true);
    }
}