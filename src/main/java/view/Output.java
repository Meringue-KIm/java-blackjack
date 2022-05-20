package view;

import domain.Dealer;
import domain.Player;
import domain.Players;

import java.util.stream.Collectors;

public class Output {

    public static void printProgressMsg(Players players) {
        System.out.print("딜러와 ");
        String joinedPlayerName = players.getPlayers().stream()
                .map(Player::getUserName)
                .collect(Collectors.joining(","));
        System.out.print(joinedPlayerName);

        System.out.println("에게 2장을 나눠줬습니다.");
    }

    public static void printDealerAndPlayersCard(Dealer dealer, Players players) {
        System.out.println(dealer.getPlayer().getUserName() + ": " + dealer.getPlayer().getUserCard().get(1));
        for (Player player : players.getPlayers()) {
            System.out.println(player.getUserName() + ": " + player.getUserCard()
                    .toString().replace("[", "").replace("]", ""));
        }
    }

}
