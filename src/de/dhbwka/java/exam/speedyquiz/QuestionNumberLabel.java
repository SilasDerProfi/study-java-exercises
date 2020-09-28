package de.dhbwka.java.exam.speedyquiz;

import javax.swing.JLabel;

/**
 * QuestionNumberLabel
 */
public class QuestionNumberLabel extends JLabel {

    private static final long serialVersionUID = 1L;
    private Status state = Status.PENDING;

    public QuestionNumberLabel(String text) {
        super(text);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public Status getState() {
        return this.state;
    }

    public void setState(Status state) {
        this.state = state;
        setBackground(state.getColor());
    }

}