package Eksamener.Eksamen2014;

public class StringQuestion extends QuestionSuper {

    protected String answer;

    public StringQuestion(String question, String answer) {
        super(question);
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return this.answer.equals(answer);
    }
}