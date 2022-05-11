package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    public Players() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
