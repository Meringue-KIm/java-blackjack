package controller;

import domain.BlackJackHost;
import domain.Dealer;
import domain.Player;
import domain.Players;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class BlackjackManager {

    private static final String DELIMITER = ",";

    public void Proceed() {
        String[] names = Input.inputPlayerName().split(DELIMITER);
        Players players = createPlayers(names);
        Dealer dealer = new Dealer(new Player());
        players.giveDefaultCardCount(dealer);
        Output.printProgressMsg(players);
        Output.printDealerAndPlayersCard(dealer, players);
        BlackJackHost.givePlayerCard(players, dealer);
        List<String> blackjackFinalResult = players.findWinner(dealer, players);
        Output.printResult(dealer, players);
        Output.printFinalResult(dealer, players, blackjackFinalResult);
    }

    private Players createPlayers(String[] names) {
        List<Player> players = new ArrayList<>();
        for (String userName : names) {
            players.add(new Player(userName.trim()));
        }
        return new Players(players);
    }

}
