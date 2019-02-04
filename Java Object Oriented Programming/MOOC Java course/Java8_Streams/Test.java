package Java8_Streams;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7};
        System.out.println(Arrays.stream(a).max().getAsInt());
    }


}