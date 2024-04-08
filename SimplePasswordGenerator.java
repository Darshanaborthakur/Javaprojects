import java.util.Scanner;
import java.util.Random;

public class SimplePasswordGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = sc.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        boolean useNumbers = sc.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean useLowercase = sc.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean useUppercase = sc.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean useSpecial = sc.next().equalsIgnoreCase("yes");

        String password = generatePassword(length, useNumbers, useLowercase, useUppercase, useSpecial);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean useNumbers, boolean useLowercase, boolean useUppercase,
            boolean useSpecial) {
        String characters = "";
        if (useNumbers)
            characters += "0123456789";
        if (useLowercase)
            characters += "abcdefghijklmnopqrstuvwxyz";
        if (useUppercase)
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (useSpecial)
            characters += "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }
}
