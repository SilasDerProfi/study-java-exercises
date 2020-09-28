package de.dhbwka.java.exam.speedyquiz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

/**
 * Game
 */
public class Game {

    private Question[] questions;
    private int questionCount;
    private List<GameClient> clients = new ArrayList<GameClient>();
    private int currentQuestion;
    private int gameSeconds;
    private int questionSeconds = 10;
    private boolean isStarted;
    private Timer timer = new Timer();

    public Game(List<Question> questionPool, int questionCount) throws GameException {
        if (questionCount > questionPool.size())
            throw new GameException("Too few questions available");

        this.questionCount = questionCount;
        questions = new Question[questionCount];

        for (int i = 0; i < questionCount; i++)
            questions[i] = questionPool.remove((int) (Math.random() * questionPool.size()));
    }

    public void registerClient(GameClient client) {
        if (!isStarted)
            clients.add(client);
    }

    public int getQuestionsCount() {
        return questionCount;
    }

    public void startGame() {
        isStarted = true;
        clients.forEach(c -> c.setQuestion(currentQuestion, questions[currentQuestion]));
        startTimer();
    }

    public void answerSelected(GameClient client, int index) {
        questionSeconds = 10;
        if (questions[currentQuestion].getCorrectIndex() == index)
            client.setAnswerState(currentQuestion, Status.CORRECT);
        else
            client.setAnswerState(currentQuestion, Status.WRONG);

        clients.forEach(c -> {
            c.setAnswerState(currentQuestion, Status.NO_ANSWER);
            if (currentQuestion + 1 < questionCount)
                c.setQuestion(currentQuestion + 1, questions[currentQuestion + 1]);
        });

        currentQuestion++;

        if (currentQuestion >= questionCount) {
            String message = "Game finished after " + gameSeconds + " seconds, score: ";

            for (GameClient c : clients) {
                c.gameIsOver();
                message += c.getPlayerName() + " (" + c.getPoints() + "), ";
            }

            message = message.substring(0, message.length() - 2);

            JOptionPane.showMessageDialog(null, message, "Meldung", JOptionPane.INFORMATION_MESSAGE);

            try (FileWriter fw = new FileWriter("io/highscore_quiz.txt", true)) {
                fw.append(message + "\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startTimer() {
        questionSeconds = 10;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!(currentQuestion < questionCount)) {
                    timer.cancel();
                    return;
                }

                gameSeconds++;
                clients.forEach(c -> c.setRemainingSeconds(questionSeconds));

                if (questionSeconds == 0 && currentQuestion < questionCount) {
                    clients.forEach(c -> {
                        c.setAnswerState(currentQuestion, Status.NO_ANSWER);

                        if (currentQuestion + 1 < questionCount)
                            c.setQuestion(currentQuestion + 1, questions[currentQuestion + 1]);
                    });
                    questionSeconds = 10;
                } else
                    questionSeconds--;
            }
        }, 0, 1000);
    }

}