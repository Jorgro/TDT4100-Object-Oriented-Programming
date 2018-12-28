package passwordRandomizer;

public
class Program {
    public static void main(String[] args) {
        PasswordRandomizer randomizer = new PasswordRandomizer(3);
        System.out.println("Password: " + randomizer.createPassword());
        System.out.println("Password: " + randomizer.createPassword());
        System.out.println("Password: " + randomizer.createPassword());
        System.out.println("Password: " + randomizer.createPassword());
    }
}
    
