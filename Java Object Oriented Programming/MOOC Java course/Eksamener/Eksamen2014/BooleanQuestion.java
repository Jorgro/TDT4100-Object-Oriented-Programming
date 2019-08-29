package Eksamener.Eksamen2014;

public class BooleanQuestion extends QuestionSuper {

    private boolean answer;

    public BooleanQuestion(String question, boolean answer) {
        super(question);
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (answer.equals("ja") && this.answer) {
            return true;
        } else if (answer.equals("nei") && !this.answer) {
            return true;
        }
        return false;
    }

}