package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String userName;
    private final List<String> userCard;
    private int cardSumValue;

    public Player() {
        this.userName = "딜러";
        this.userCard = new ArrayList<>();
        this.cardSumValue = 0;
    }

    public Player(String userName) {
        this.userName = validate(userName);
        this.userCard = new ArrayList<>();
        this.cardSumValue = 0;
    }

    public void calculateCardsValueSum() {
        for (String card : this.userCard) {
            this.cardSumValue += calculateCardValueSum(card);
        }
    }

    public int calculateCardValueSum(String card) {
        if (card.equals("A스페이드")) {
            return isCardValueSumByValueChoice();
        }
        String cardNumber = String.valueOf(card.charAt(0));
        if (cardNumber.equals("K") || cardNumber.equals("J") || cardNumber.equals("Q")) {
            return 10;
        } else if (cardNumber.equals("A")) {
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
