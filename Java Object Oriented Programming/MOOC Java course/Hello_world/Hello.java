package Hello_world;

import java.util.Map;

public class Hello  {

    public static final Map<Integer, String> values = Map.of(1, "hello");

    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(values.get(1));
        
        String hey = "hello";
        System.out.println(hey);

        System.out.println("whats wrong? ");
    }
}