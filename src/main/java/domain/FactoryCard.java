package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FactoryCard {

    private static final List<String> CARD_NUMBER = new ArrayList<>();

    static {
        for (int i = 2; i <= 10; i++) {
            CARD_NUMBER.add(String.valueOf(i));
        }
        CardCharNumber[] cardCharNumbers = CardCharNumber.values();
        for (CardCharNumber cardCharNumber : cardCharNumbers) {
            CARD_NUMBER.add(cardCharNumber.getCardCharNumber());
        }
    }

    public static String createRandomCardNumber() {
        List<String> randomCardNumber = new ArrayList<>(CARD_NUMBER);
        Collections.shuffle(randomCardNumber);
        return randomCardNumber.get(0);
    }

    public static String createCard(String cardNumber) {
        StringBuilder sb = new StringBuilder();
        List<CardKind> cardKinds = Arrays.asList(CardKind.values());
        sb.append(cardNumber);
        Collections.shuffle(cardKinds);
        sb.append(cardKinds.get(0));
        return sb.toString();
    }

}
