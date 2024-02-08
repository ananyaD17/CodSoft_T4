import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == -1) {
            System.out.println("Error fetching exchange rates. Exiting program.");
            return;
        }

       
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

       
        double convertedAmount = convertCurrency(amountToConvert, exchangeRate);

        System.out.printf("%.2f %s is equal to %.2f %s%n",
                amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

  
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
       
        try {
            
            if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
                return 0.85;
            } else if (baseCurrency.equals("USD") && targetCurrency.equals("GBP")) {
                return 0.75;
            } else if (baseCurrency.equals("USD") && targetCurrency.equals("JPY")) {
                return 110.25;
            } else {
                System.out.println("Unsupported currency pair.");
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    
    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
