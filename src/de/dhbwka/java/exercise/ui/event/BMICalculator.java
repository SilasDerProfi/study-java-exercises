package de.dhbwka.java.exercise.ui.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * BMICalculator
 */
public class BMICalculator {

    public static void main(String[] args) {
        JFrame bmiFrame = new JFrame("BMI Calculator");
        bmiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bmiFrame.setLayout(new FlowLayout());

        JPanel pnl1 = new JPanel();
        pnl1.add(new JLabel("Weight [kg]:"));
        JTextField weight = new JTextField();
        weight.setColumns(10);
        pnl1.add(weight);
        bmiFrame.add(pnl1, BorderLayout.NORTH);

        JPanel pnl2 = new JPanel();
        pnl2.add(new JLabel("Body height [m]"));
        JTextField height = new JTextField();
        height.setColumns(10);
        pnl2.add(height);
        bmiFrame.add(pnl2);

        // eine Radio-Button-Gruppe mit drei Radio-Buttons.
        JPanel pnl3 = new JPanel();
        ButtonGroup bgrp = new ButtonGroup();
        JRadioButton rbt1 = new JRadioButton("male");
        bgrp.add(rbt1);
        pnl3.add(rbt1);
        JRadioButton rbt2 = new JRadioButton("female");
        bgrp.add(rbt2);
        pnl3.add(rbt2);
        bmiFrame.add(pnl3);

        JButton calc = new JButton("Calculate");

        bmiFrame.add(calc);



        JPanel pnl4 = new JPanel();
        pnl4.add(new JLabel("BMI:"));
        JTextField bmi = new JTextField();
        bmi.setColumns(10);
        pnl4.add(bmi);
        bmiFrame.add(pnl4);

        JTextField bmiText = new JTextField();
        bmiText.setEditable(false);
        bmiText.setColumns(10);
        bmiFrame.add(bmiText);

        calc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Double bmiValue = Double.parseDouble(weight.getText()) / Math.pow(Double.parseDouble(height.getText()), 2);
                bmi.setText(String.format("%5f", bmiValue));

                if(rbt1.isSelected())
                {
                    if(bmiValue < 20)
                        bmiText.setText("Short weight");
                    else if(bmiValue < 25)
                        bmiText.setText("Normal weight");
                    else if(bmiValue < 30)
                        bmiText.setText("Overweight");
                    else if(bmiValue < 40)
                        bmiText.setText("Adiposity");
                    else 
                        bmiText.setText("Massive Adipositly");
                }
                else
                {
                    if(bmiValue < 19)
                        bmiText.setText("Short weight");
                    else if(bmiValue < 24)
                        bmiText.setText("Normal weight");
                    else if(bmiValue < 30)
                        bmiText.setText("Overweight");
                    else if(bmiValue < 40)
                        bmiText.setText("Adiposity");
                    else 
                        bmiText.setText("Massive Adipositly");
                }
                
            }
        });

        bmiFrame.setVisible(true);
        bmiFrame.setSize(280, 250);
        bmiFrame.setMinimumSize(bmiFrame.getSize());
        bmiFrame.setMaximumSize(bmiFrame.getSize());
    }
}