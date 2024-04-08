import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = sc.next().charAt(0);

        double convertedTemperature;
        if (unit == 'C' || unit == 'c') {
            convertedTemperature = temperature * 9 / 5 + 32;
            System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
        } else if (unit == 'F' || unit == 'f') {
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + convertedTemperature);
        } else {
            System.out.println("Invalid unit of measurement. Please enter C or F.");
        }

    }
}
