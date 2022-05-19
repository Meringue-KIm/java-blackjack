package domain;

public enum CardCharNumber {

    FIRST("A"),
    KING("K"),
    JACK("J"),
    QUEEN("Q");

    private final String charNumber;

    CardCharNumber(String charNumber) {
        this.charNumber = charNumber;
    }

    public String getCardCharNumber() {
        return this.charNumber;
    }

}
