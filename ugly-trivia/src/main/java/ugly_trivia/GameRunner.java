package ugly_trivia;

public class GameRunner {

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        aGame.run();
    }
}