package Eksamener.Kont2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ExamReader {

    private BufferedWriter scanner2;
    private BufferedReader reader;

    public Collection<Exam> readExams(Reader input) {
        Scanner scanner = new Scanner(input);

        Collection<Exam> exams = new ArrayList<>();
        String s = "";
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            try {
                Course.checkTime(s);
                continue;
            } catch (Exception e) {
                String[] exam = s.split(" ");
                for (int i = 2; i < exam.length; i++) {
                    exams.add(new Exam(exam[i], exam[0]));
                }
            }
    }
}