import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = in.nextLine();
        String str = s.toUpperCase();
        int strLen = str.length();
        boolean isPalin = true;
        for (int i = 0; i < strLen / 2; i++) {
            if (str.charAt(i) != str.charAt(strLen - 1 - i)) {
                isPalin = false;
                break;
            }
        }
        if (isPalin)
            System.out.println("It is a palindrome string.");
        else
            System.out.println("It is not a palindrome string.");
        in.close();
    }
}
