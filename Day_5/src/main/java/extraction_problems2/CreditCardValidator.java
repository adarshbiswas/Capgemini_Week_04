package extraction_problems2;

import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        String cardNumber = "4123456789012345"; // Example input (Visa)
        String visaRegex = "^4[0-9]{15}$"; // Regex for Visa cards
        String masterCardRegex = "^5[1-5][0-9]{14}$"; // Regex for MasterCard

        boolean isVisa = Pattern.matches(visaRegex, cardNumber);
        boolean isMasterCard = Pattern.matches(masterCardRegex, cardNumber);

        if (isVisa) {
            System.out.println(cardNumber + " is a valid Visa card.");
        } else if (isMasterCard) {
            System.out.println(cardNumber + " is a valid MasterCard.");
        } else {
            System.out.println(cardNumber + " is invalid.");
        }
    }
}