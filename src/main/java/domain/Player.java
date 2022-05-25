package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static final String DEALER_NAME = "딜러";
    public static final String SPECIAL_CARD = "A스페이드";
    public static final int DEFAULT_VALUE = 0;
    public static final int START_INDEX = 0;
    public static final int END_INDEX = 2;

    private final String userName;
    private final List<String> userCard;
    private int cardSumValue;

    public Player() {
        this.userName = DEALER_NAME;
        this.userCard = new ArrayList<>();
        this.cardSumValue = DEFAULT_VALUE;
    }

    public Player(String userName) {
        this.userName = validate(userName);
        this.userCard = new ArrayList<>();
        this.cardSumValue = DEFAULT_VALUE;
    }

    public void calculateCardsValueSum() {
        int sum = DEFAULT_VALUE;
        for (String card : this.userCard) {
            sum += searchCardValue(card);
        }
        this.cardSumValue = sum;
    }

    public int searchCardValue(String card) {
        if (card.equals(SPECIAL_CARD)) {
            return isCardValueSumByValueChoice();
        }
        String cardNumber = card.substring(START_INDEX, END_INDEX);
        if (cardNumber.equals("10")) {
            return 10;
        }
        cardNumber = String.valueOf(card.charAt(0));
        if (cardNumber.equals(CardCharNumber.KING.getCardCharNumber())
                || cardNumber.equals(CardCharNumber.JACK.getCardCharNumber())
                || cardNumber.equals(CardCharNumber.QUEEN.getCardCharNumber())) {
            return 10;
        } else if (cardNumber.equals(CardCharNumber.FIRST.getCardCharNumber())) {
            return 1;
        }
        return Integer.parseInt(cardNumber);
    }

    private int isCardValueSumByValueChoice() {
        if (this.cardSumValue + 11 > 21) {
            return 1;
        }
        return 11;
    }

    private String validate(String userName) {
        return userName;
    }

    public void addUserCard(String card) {
        this.userCard.add(card);
    }

    public String getUserName() {
        return this.userName;
    }

    public List<String> getUserCard() {
        return this.userCard;
    }

    public int getCardSumValue() {
        return this.cardSumValue;
    }

}
