import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter amount in base currency: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter base currency code (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter target currency code (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double convertCurrency(double amount, String baseCurrency, String targetCurrency) throws Exception {
        URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseBody = response.toString();
        String ratesData = responseBody.substring(responseBody.indexOf("rates\":") + 7, responseBody.indexOf("}"));
        String[] currencyRates = ratesData.split(",");
        double rate = 0.0;

        for (String currencyRate : currencyRates) {
            String[] parts = currencyRate.split(":");
            String currencyCode = parts[0].trim().replaceAll("\"", "");
            double value = Double.parseDouble(parts[1].trim());
            if (currencyCode.equals(targetCurrency)) {
                rate = value;
                break;
            }
        }

        return amount * rate;
    }
}
