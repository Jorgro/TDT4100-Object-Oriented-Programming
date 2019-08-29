package Eksamener.Eksamen2014;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Question {

    private String question;
    private String answer;
    private List<String> alternatives = new ArrayList<>();

    public Question(String question, String answer, String... alternatives) {
        this(question, answer, Arrays.asList(alternatives));
    }

    public Question(String question, String answer, Collection<String> alternatives) {
        this.question = question;
        this.answer = answer;

        if (alternatives.stream().noneMatch(c -> c.equals(this.answer)) && alternatives.size() > 0) {
            throw new IllegalArgumentException();
        } else if (alternatives != null) {
            this.alternatives.addAll(alternatives);
        }
    }

    public void askQuestion(PrintStream ps) {
        String result = question;
        if (this.alternatives.size() > 0) {
            for (String str : this.alternatives) {
                result += " " + (this.alternatives.indexOf(str) + 1) + ". " + str;
            }
        }
        ps.println(result);
    }

    public boolean checkAnswer(String answer) {

        if (this.alternatives.size() == 0) {
            return answer.equals(this.answer);
        }

        try {
            int i = Integer.parseInt(answer);
            if (this.alternatives.get(i - 1).equals(this.answer)) {
                return true;
            } else if (answer.equals(this.answer)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return answer.equals(this.answer);
        }
    }

}