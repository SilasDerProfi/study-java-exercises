package de.dhbwka.java.exam.speedyquiz;

/**
 * Question
 */
public class Question {

    public Question(String questionText, String[] answers, int correctIndex)
    {
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }
    
	private String questionText;
    private String[] answers;
    private int correctIndex;

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectIndex() {
        return this.correctIndex;
    }

    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }
}