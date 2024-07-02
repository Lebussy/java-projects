import org.example.Converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What currency would you like to exchange?");
        String from = scanner.nextLine();
        System.out.println("What currency would you like in return?");
        String to = scanner.nextLine();
        System.out.println("Please enter the amount in " + from + ":");
        float amount = Float.parseFloat(scanner.nextLine());
        Converter converter = new Converter();
        double converted = converter.convert(from, to, amount);
        System.out.println(amount + " in " + from + " converts to " + converted + " " + to);
    }
}