package Eksamener.Eksamen2014;

import java.io.PrintStream;

public abstract class QuestionSuper {

    protected String question;

    public QuestionSuper(String question) {
        this.question = question;

    }

    public abstract boolean checkAnswer(String answer);

    public void askQuestion(PrintStream ps) {
        ps.println(this.question);
    }
}