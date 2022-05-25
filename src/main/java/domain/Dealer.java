package domain;

public class Dealer {

    private final Player player;

    public Dealer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isDealerCardsValueSum() {
        player.calculateCardsValueSum();
        if (player.getCardSumValue() <= 16) {
            player.addUserCard(CardFactory.createCard(CardFactory.createRandomCardNumber()));
            player.calculateCardsValueSum();
            return true;
        }
        return false;
    }

}
