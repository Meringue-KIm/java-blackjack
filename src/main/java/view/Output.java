package view;

import domain.Dealer;
import domain.Player;
import domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static void printDealerCardSumValueMsg() {
        System.out.println();
        System.out.println("딜러는 16이하라 한 장의 카드를 더 받았습니다.");
        System.out.println();
    }

    public static void printProgressMsg(Players players) {
        System.out.print("딜러와 ");
        String joinedPlayerName = players.getPlayers().stream()
                .map(Player::getUserName)
                .collect(Collectors.joining(","));
        System.out.print(joinedPlayerName);

        System.out.println("에게 2장을 나눠줬습니다.");
    }

    public static void printDealerAndPlayersCard(Dealer dealer, Players players) {
        System.out.println(dealer.getPlayer().getUserName() + ": " + dealer.getPlayer().getUserCard().get(0));
        for (Player player : players.getPlayers()) {
            System.out.println(player.getUserName() + "카드: " + player.getUserCard()
                    .toString().replace("[", "").replace("]", ""));
        }
    }

    public static void printPlayersCard(Player player) {
        System.out.println(player.getUserName() + "카드: " + player.getUserCard()
                .toString().replace("[", "").replace("]", ""));
    }

    public static void printResult(Dealer dealer, Players players) {
        System.out.print(dealer.getPlayer().getUserName() + "카드: ");
        System.out.print(String.join(",", dealer.getPlayer().getUserCard()));
        System.out.println(" 결과:" + dealer.getPlayer().getCardSumValue());
        for (Player player : players.getPlayers()) {
            System.out.println(player.getUserName() + ": " + player.getUserCard()
                    .toString().replace("[", "").replace("]", "")
                    + " 결과:" + player.getCardSumValue());
        }
        System.out.println();
        System.out.println("결과가 21이 초과해도 패배입니다.");
        System.out.println();
    }

    public static void printFinalResult(Dealer dealer, Players players, List<String> blackjackFinalResult) {
        System.out.println("## 최종 승패");
        System.out.println(dealer.getPlayer().getUserName() + ": " + blackjackFinalResult.get(0));
        for (int i = 0; i < players.getPlayers().size(); i++) {
            System.out.println(players.getPlayers().get(i).getUserName() + ": " + blackjackFinalResult.get(i + 1));
        }
    }

}
