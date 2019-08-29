package Eksamener.Eksamen2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private Collection<Question> questions = new ArrayList<>();
    private boolean mode;
    private Scanner scanner;
    private PrintStream out;
    private List<Question> remaining;
    private int correctCount;

    public void addQuestion(Question que) {
        if (!this.questions.contains(que)) {
            this.questions.add(que);
        }
    }

    public void run() {
        Scanner reader = new Scanner(System.in);
        // this.questions.stream().forEach(q -> q.askQuestion(System.out));

        for (Question q : this.questions) {
            q.askQuestion(System.out);
            String answer = reader.nextLine();
            while (!q.checkAnswer(answer)) {
                System.out.print("Try again: ");
                answer = reader.nextLine();
            }
            System.out.println("Correct!");
        }
    }

    public void init() {
        addQuestion(new Question("Hva heter Norge?", "Oslo", "Bergen", "Trondheim", "Oslo"));
        addQuestion(new Question("Hvor lang er jeg?", "185 cm"));
    }

    public void init(String filename) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));

        while (reader.hasNextLine()) {
            String question = reader.nextLine().trim();
            String answer = reader.nextLine().trim();
            Collection<String> alternatives = new ArrayList<>();
            String alternative = "k";
            while (reader.hasNextLine() && alternative.length() > 0) {
                alternative = reader.nextLine().trim();
                if (alternative.length() > 0) {
                    alternatives.add(alternative);
                } else {
                    break;
                }
            }
            addQuestion(new Question(question, answer, alternatives));
        }
    }

    public void start(boolean mode, PrintStream out, InputStream in) {
        this.mode = mode;
        this.out = out;
        this.scanner = new Scanner(in);
        this.remaining = new ArrayList<>(this.questions);
        this.correctCount = 0;

    }

    public int doQuestion() {
        Question q = remaining.remove(0);
        q.askQuestion(this.out);
        if (q.checkAnswer(this.scanner.nextLine())) {
            System.out.println("Correct!");
            correctCount++;
        } else if (mode) {
            remaining.add(q);
        } else {
            remaining.add(0, q);
        }
        return remaining.size();
    }

    public int stop() {
        scanner.close();
        return correctCount;
    }

    // pass p at det ikke finnes to av samme klasse?? Problemet er retarda
    public static void main(String[] args) throws FileNotFoundException {
        Quiz quiz = new Quiz();
        quiz.init(
                "/Users/jorgenrosager/Library/Mobile Documents/com~apple~CloudDocs/Java VSCode/Java Object Oriented Programming/MOOC Java course/Eksamener/Eksamen2014/sample.txt");
        quiz.run();
    }
}