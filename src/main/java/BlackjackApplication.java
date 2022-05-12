import controller.BlackjackManager;

public class BlackjackApplication {

    public static void main(String[] args) {
        try {
            BlackjackManager blackjackManager = new BlackjackManager();
            blackjackManager.Proceed();
        } catch (Exception e) {
            System.out.println("종료 되었습니다.");
        }
    }

}
