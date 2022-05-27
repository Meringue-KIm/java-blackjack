package domain;

import java.util.ArrayList;
import java.util.List;


public class Player {

    private static final String BLANK_SPACE = " ";
    private static final int MAX_NAME_LENGTH = 20;
    private static final String DEALER_NAME = "딜러";
    private static final String SPECIAL_CARD = "A스페이드";
    private static final int DEFAULT_VALUE = 0;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 2;

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

    private String validate(String userName) {
        validateNameContainsNumber(userName);
        validateNameLength(userName);
        validateNameContainsBlank(userName);
        validateEmptyName(userName);
        return userName;
    }

    public void calculateCardsValueSum() {
        int sum = DEFAULT_VALUE;
        for (String card : this.userCard) {
            sum += searchCardValue(card);
        }
        this.cardSumValue = sum;
    }

    private int searchCardValue(String card) {
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

    private void validateNameContainsNumber(String name) {
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("이름의 숫자가 포함되어 있습니다");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 20글자를 넘을 수 없습니다");
        }
    }

    private void validateNameContainsBlank(String name) {
        if (name.contains(BLANK_SPACE)) {
            throw new IllegalArgumentException("이름은 공백을 포함할 수 없습니다");
        }
    }

    private void validateEmptyName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("비어 있는 이름을 입력할 수 없습니다");
        }
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
