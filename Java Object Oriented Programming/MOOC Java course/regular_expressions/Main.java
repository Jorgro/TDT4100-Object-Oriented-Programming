package regular_expressions;

import java.util.Date;

public class Main {

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    public static boolean allVowels(String string) {
        return string.matches("[aeiuoøæåy]*");
    }

    public static boolean clockTime(String string) {
        if (string.matches("..:..:..")) {
            int hour = Integer.valueOf((string.substring(0, 2))); 
            int minute = Integer.valueOf((string.substring(3, 5)));
            int second = Integer.valueOf((string.substring(6)));

            return (hour < 24 && minute < 60 && second < 60);
            
        }
        return false;
    }
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println(isAWeekDay("abs"));
        System.out.println(allVowels("aaaaeeeæøå"));
        System.out.println(clockTime("27:24:29"));
    }
}