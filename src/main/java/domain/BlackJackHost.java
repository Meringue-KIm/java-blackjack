package domain;

import view.Input;
import view.Output;

public class BlackJackHost {

    public static void givePlayerCard(Players players, Dealer dealer) {
        for (Player player : players.getPlayers()) {
            BlackJackHost.questionPlayers(player, players);
            Output.printPlayersCard(player);
        }
        calculatePlayersCardValueSum(players);
        checkDealerCard(dealer);
    }

    public static void calculatePlayersCardValueSum(Players players) {
        for (Player player : players.getPlayers()) {
            player.calculateCardsValueSum();
        }
    }

    public static void questionPlayers(Player player, Players players) {
        if (players.isTakeCard(player, Input.inputTakeCard(player.getUserName()))) {
            questionPlayers(player, players);
        }
    }

    public static void checkDealerCard(Dealer dealer) {
        if (dealer.isDealerCardsValueSum()) {
            Output.printDealerCardSumValueMsg();
        }
    }

    public static String compareDealerAndPlayers(Dealer dealer, Player player) {
        if (player.getCardSumValue() > 21) {
            return "패";
        }
        if (dealer.getPlayer().getCardSumValue() < player.getCardSumValue() || dealer.getPlayer().getCardSumValue() > 21) {
            return "승";
        } else if (dealer.getPlayer().getCardSumValue() > player.getCardSumValue()) {
            return "패";
        }
        return "무";
    }

}
