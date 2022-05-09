package domain;

public class Player {

    private final String userName;

    public Player(String userName) {
        this.userName = validate(userName);

    }

    private String validate(String userName) {
        return userName;
    }

    public String getUserName() {
        return this.userName;
    }
}
