package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public void giveDefaultCardCount(Dealer dealer) {
        for (int i = 0; i < 2; i++) {
            dealer.getPlayer().addUserCard(CardFactory.createCard(CardFactory.createRandomCardNumber()));
            giveDefaultPlayerCard();
        }
    }

    private void giveDefaultPlayerCard() {
        for (Player player : this.players) {
            player.addUserCard(CardFactory.createCard(CardFactory.createRandomCardNumber()));
        }
    }

    public boolean isTakeCard(Player player, String playerTakeCardResult) {
        if (playerTakeCardResult.equals("y") || playerTakeCardResult.equals("Y")) {
            giveCard(player);
            return true;
        }
        return false;
    }

    private void giveCard(Player player) {
        if (player.getCardSumValue() <= 21) {
            player.addUserCard(CardFactory.createCard(CardFactory.createRandomCardNumber()));
        }
    }

    public List<String> findWinner(Dealer dealer, Players players) {
        List<String> playersFinalResults = new ArrayList<>();
        List<Integer> dealerResults = new ArrayList<>(Arrays.asList(0, 0, 0));
        for (Player player : players.getPlayers()) {
            String playerResult = BlackJackHost.compareDealerAndPlayers(dealer, player);
            playersFinalResults.add(playerResult);
            findDealerFinalResult(playerResult, dealerResults);
        }
        String dealerFinalResult = dealerResults.get(0) + "승" +
                dealerResults.get(1) + "무" +
                dealerResults.get(2) + "패";
        playersFinalResults.add(0, dealerFinalResult);

        return playersFinalResults;
    }

    private void findDealerFinalResult(String playersFinalResults, List<Integer> dealerResult) {
        if (playersFinalResults.equals("승")) {
            dealerResult.add(2, +1);
        } else if (playersFinalResults.equals("패")) {
            dealerResult.add(0, +1);
        } else {
            dealerResult.add(1, +1);
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

}
