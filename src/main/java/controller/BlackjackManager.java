package controller;

import domain.CardFactory;
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
        String name = Input.inputPlayerName();
        Players players = createPlayerList(name.split(DELIMITER));
        Dealer dealer = new Dealer(new Player());
        giveDefaultCardCount(dealer, players);
        Output.printProgressMsg(players);
        Output.showDealerAndPlayersCard(dealer, players);


    }

    private Players createPlayerList(String[] names) {
        List<Player> players = new ArrayList<>();
        for (String userName : names) {
            players.add(new Player(userName));
        }
        return new Players(players);
    }

    private void giveDefaultCardCount(Dealer dealer, Players players) {
        for (int i = 0; i < 2; i++) {
            dealer.getPlayer().addUserCard(CardFactory.createCard(CardFactory.createRandomCardNumber()));
            giveDefaultPlayerCard(players);
        }
    }

    private void giveDefaultPlayerCard(Players players) {
        for (Player player : players.getPlayers()) {
            player.addUserCard(CardFactory.createCard(CardFactory.createRandomCardNumber()));
        }
    }

}
