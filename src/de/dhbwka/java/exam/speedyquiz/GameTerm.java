package de.dhbwka.java.exam.speedyquiz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * GameTerm
 */
public class GameTerm extends JFrame implements GameClient {

    private static final long serialVersionUID = 1L;
    private String name;
    private GameClient client;
    private int points;

    private JButton answ1 = new GameAnswerButton(0);
    private JButton answ2 = new GameAnswerButton(1);
    private JButton answ3 = new GameAnswerButton(2);
    private JButton answ4 = new GameAnswerButton(3);
    private JLabel questionLabel = new JLabel();
    private JLabel timeLabel = new JLabel(10 + "");
    private QuestionNumberLabel[] questionNumbers;

    public GameTerm(String name, Game game) {
        super(name);
        client = this;
        this.name = name;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
        setLayout(new BorderLayout());

        questionNumbers = new QuestionNumberLabel[game.getQuestionsCount()];
        JPanel levels = new JPanel();
        for (int i = 0; i < game.getQuestionsCount(); i++) {
            questionNumbers[i] = new QuestionNumberLabel((i + 1) + "");
            levels.add(questionNumbers[i]);
        }

        levels.setLayout(new GridLayout(1, game.getQuestionsCount()));
        add(levels, BorderLayout.NORTH);

        JPanel question = new JPanel();
        question.setLayout(new GridLayout(2, 1));
        question.add(questionLabel);
        question.add(timeLabel);
        add(question, BorderLayout.CENTER);

        JPanel answers = new JPanel();
        answers.setLayout(new GridLayout(2, 2));

        ActionListener buttonClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.answerSelected(client, ((GameAnswerButton) e.getSource()).getAnswerIndex());
            }
        };

        answ1.addActionListener(buttonClick);
        answ2.addActionListener(buttonClick);
        answ3.addActionListener(buttonClick);
        answ4.addActionListener(buttonClick);
        answers.add(answ1);
        answers.add(answ2);
        answers.add(answ3);
        answers.add(answ4);

        add(answers, BorderLayout.SOUTH);
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public int getPoints() {
        return points < 0 ? 0 : points;
    }

    @Override
    public void setQuestion(int questionIndex, Question q) {
        questionLabel.setText(q.getQuestionText());
        answ1.setText(q.getAnswers()[0]);
        answ2.setText(q.getAnswers()[1]);
        answ3.setText(q.getAnswers()[2]);
        answ4.setText(q.getAnswers()[3]);

        setAnswerState(questionIndex, Status.ACTIVE);
    }

    @Override
    public void setRemainingSeconds(int seconds) {
        timeLabel.setText(seconds + "");
        this.repaint();
    }

    @Override
    public void gameIsOver() {
        answ1.setEnabled(false);
        answ2.setEnabled(false);
        answ3.setEnabled(false);
        answ4.setEnabled(false);
    }

    @Override
    public void setAnswerState(int questionIndex, Status status) {
        Status state = questionNumbers[questionIndex].getState();

        if (state != Status.CORRECT && state != Status.WRONG && state != Status.NO_ANSWER)
            questionNumbers[questionIndex].setState(status);

        points += status.getPoints();
    }

}