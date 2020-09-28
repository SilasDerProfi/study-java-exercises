package de.dhbwka.java.exam.speedyquiz;

import javax.swing.JButton;

/**
 * GameButton
 */
public class GameAnswerButton extends JButton{
    private static final long serialVersionUID = 1L;
    private int answerIndex;

    public GameAnswerButton(int answerIndex){
        super();
        this.answerIndex = answerIndex;
    }

    public int getAnswerIndex() {
        return this.answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }
    
}