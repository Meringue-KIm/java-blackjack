package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardNumber {

    private static final List<String> cardNumber = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            cardNumber.add(String.valueOf(i));
        }
        cardNumber.add("K");
        cardNumber.add("Q");
        cardNumber.add("J");
    }

    public static String getRandomCardNumber() {
        List<String> randomCardNumber = new ArrayList<>(cardNumber);
        Collections.shuffle(randomCardNumber);
        return randomCardNumber.get(0);
    }

}
