package controller;

import domain.Player;
import domain.Players;
import view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackManager {

    private static final String DELIMITER = ",";

    public void Proceed() {
        List<Player> playerList = new ArrayList<>();
        for (String userName : divideName(Input.inputPlayerName())) {
            playerList.add(new Player(userName));
        }
        Players players = new Players(playerList);


    }

    private List<String> divideName(String name) {
        return Arrays.asList(name.split(DELIMITER));
    }

}
