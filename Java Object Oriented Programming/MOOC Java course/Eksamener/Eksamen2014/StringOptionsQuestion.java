package Eksamener.Eksamen2014;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringOptionsQuestion extends StringQuestion {

    private List<String> alternatives = new ArrayList<>();

    public StringOptionsQuestion(String question, String answer, Collection<String> alternatives) {
        super(question, answer);
        if (alternatives.stream().noneMatch(c -> c.equals(this.answer)) && alternatives.size() > 0) {
            throw new IllegalArgumentException();
        } else if (alternatives != null) {
            this.alternatives.addAll(alternatives);
        }
    }

    public StringOptionsQuestion(String question, String answer, String... alternatives) {
        this(question, answer, Arrays.asList(alternatives));
    }

    @Override
    public void askQuestion(PrintStream ps) {
        super.askQuestion(ps);

        for (String str : this.alternatives) {
            ps.print(" " + (this.alternatives.indexOf(str) + 1) + ". " + str);
        }

        ps.println();
    }

    @Override
    public boolean checkAnswer(String answer) {
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