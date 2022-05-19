package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String userName;
    private final List<String> userCard;

    public Player(String userName) {
        this.userName = validate(userName);
        this.userCard = new ArrayList<>();
    }

    private String validate(String userName) {
        return userName;
    }

    public void addUserCard(String card) {
        this.userCard.add(card);
    }

    public String getUserName() {
        return this.userName;
    }

}
