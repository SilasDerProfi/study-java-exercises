package de.dhbwka.java.exercise.ui;

import javax.swing.*;

/**
 * ComponentFrame
 */
public class ComponentFrame  extends JFrame{

    private static final long serialVersionUID = 4407641735045508197L;

    ComponentFrame(){
        initializeComponent();
    }

    private void initializeComponent() 
    {
        JPanel pnl = new JPanel();
        setTitle("Several basic Swing components");
        setSize(300, 150);

        // ein Label
        JLabel lbl = new JLabel("JLabel");
        pnl.add(lbl);

        // ein Textfeld
        JTextField tf = new JTextField("JTextField");
        pnl.add(tf);

        // ein Password-Feld
        JPasswordField pf = new JPasswordField("JPasswordField");
        pnl.add(pf);

        // ein Button (mit einem Tooltipp)
        JButton btn = new JButton("JButton");
        btn.setToolTipText("btnTooltip");
        pnl.add(btn);

        // ein Toggle-Button
        JToggleButton tbtn = new JToggleButton("JToggleButton");
        pnl.add(tbtn);

        // eine Check-Box
        JCheckBox checkBox = new JCheckBox("JCheckBox");
        pnl.add(checkBox);

        // eine Combo-Box
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Item1");
        comboBox.addItem("Item2");
        comboBox.addItem("Item3");
        comboBox.addItem("Item4");
        pnl.add(comboBox);

        // eine Radio-Button-Gruppe mit drei Radio-Buttons.
        ButtonGroup bgrp = new ButtonGroup();
        JRadioButton rbt1 = new JRadioButton("Radio-Button-1");
        bgrp.add(rbt1);
        pnl.add(rbt1);
        JRadioButton rbt2 = new JRadioButton("Radio-Button-2");
        bgrp.add(rbt2);
        pnl.add(rbt2);
        JRadioButton rbt3 = new JRadioButton("Radio-Button-3");
        bgrp.add(rbt3);
        pnl.add(rbt3);



        add(pnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}