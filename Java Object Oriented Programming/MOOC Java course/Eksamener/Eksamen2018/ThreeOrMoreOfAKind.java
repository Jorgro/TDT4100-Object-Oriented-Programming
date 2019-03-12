package Eksamener.Eksamen2018;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThreeOrMoreOfAKind implements DiceScorer {








    @Override
    public Dice getScore(Dice dice) {

        ArrayList<int[]> count = counter(dice);

        if (count.stream().noneMatch(c -> c[1] >= 3)) {
            return null;
        }
        int[] values = count.stream()
        .filter(c -> c[1] >= 3)
        .sorted((a, b) -> (int) ((100*b[0]*Math.pow(2, b[1]-3) - (100*a[0]*Math.pow(2, a[1]-3)))))
        .findFirst().get();
        Collection<Integer> dieValues = new ArrayList<>();
        for (int i = 0; i < values[1]; i++) {
            dieValues.add(values[0]);
        }
        return new Dice(dieValues, (int) (100*values[0]*Math.pow(2, values[1]-3)));


        //.mapToInt(c ->  (int) (100*c[0]*Math.pow(2, c[1]-3)))
        //.max();
    }


    private ArrayList<int[]> counter(Dice dice) {
        ArrayList<int[]> count = new ArrayList<int[]>();
        for(int i = 1; i <= 6; i++) {
           int e = i;
           int k = (int) dice.getDieValues().stream().filter(c -> c == e).count();
           count.add(new int[]{i, k});
        }

        return count;

    }
    public Collection<Dice> computeDiceScores(Dice dice) {
        Collection<Dice> dices = new ArrayList<>(); 
        Dice diceTest = new Dice(1);
        while (diceTest != null) {
            diceTest = getScore(dice);
            if (diceTest != null) {
                dices.add(diceTest);
                dice = dice.remove(diceTest);
            }
        }

        return dices;
     }  

    public static void main(String[] args) {
        ThreeOrMoreOfAKind ds = new ThreeOrMoreOfAKind();
        Dice dice = new Dice(30);
        System.out.println(dice);

        System.out.println(ds.computeDiceScores(dice));


        String[] test1 = {"Jørgen", "Løping", "23"};
        List<String[]> hello = new ArrayList<>();
        hello.add(test1);hello.add(new String[]{"Gaute", "Løping", "1"});
        hello.add(new String[]{"Jostein", "Løping", "2000"});

        try {
        Map<String, String[]> resultater =
        Files.lines(Paths.get("/Users/jorgenrosager/Library/Mobile Documents/com~apple~CloudDocs/Java VSCode/Java Object Oriented Programming/MOOC Java course/Eksamener/Eksamen2018/test.txt"))
        .map(a -> a.split(";"))
        .collect(Collectors.toMap(a -> a[0], a -> new String[]{a[1], a[2]}));
        resultater.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ Arrays.toString(y))); 
    
    
        }
        catch(Exception e) {
            System.out.println(e);
        }

       


    }



}