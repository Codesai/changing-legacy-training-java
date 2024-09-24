package ugly_trivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    private final List<String> players = new ArrayList<>();
    private final int[] places = new int[6];
    private final int[] purses = new int[6];
    private final boolean[] inPenaltyBox = new boolean[6];
    private int currentPlayer;
    private boolean isGettingOutOfPenaltyBox;

    private final LinkedList<String> popQuestions = new LinkedList<>();
    private final LinkedList<String> scienceQuestions = new LinkedList<>();
    private final LinkedList<String> sportsQuestions = new LinkedList<>();
    private final LinkedList<String> rockQuestions = new LinkedList<>();
    private Random rand;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public void run() {
        boolean notAWinner;
        rand = new Random();

        do {
            roll(getRollResult());

            if (isAnswerRight()) {
                notAWinner = wrongAnswer();
            } else {
                notAWinner = wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }

    protected int getRollResult() {
        return rand.nextInt(5) + 1;
    }

    protected boolean isAnswerRight() {
        return rand.nextInt(9) == 7;
    }

    private String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean add(String playerName) {
        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        showMessage(playerName + " was added");
        showMessage("They are player number " + players.size());
        return true;
    }

    protected void showMessage(String playerName) {
        System.out.println(playerName);
    }

    private int howManyPlayers() {
        return players.size();
    }

    private void roll(int roll) {
        showMessage(players.get(currentPlayer) + " is the current player");
        showMessage("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                showMessage(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
                if (places[currentPlayer] > 11) {
                    places[currentPlayer] = places[currentPlayer] - 12;
                }

                showMessage(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                showMessage("The category is " + currentCategory());
                askQuestion();
            } else {
                showMessage(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            places[currentPlayer] = places[currentPlayer] + roll;
            if (places[currentPlayer] > 11) {
                places[currentPlayer] = places[currentPlayer] - 12;
            }

            showMessage(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            showMessage("The category is " + currentCategory());
            askQuestion();
        }
    }

    private void askQuestion() {
        if (currentCategory().equals("Pop")) {
            showMessage(popQuestions.getFirst());
            popQuestions.removeFirst();
        } else if (currentCategory().equals("Science")) {
            showMessage(scienceQuestions.getFirst());
            scienceQuestions.removeFirst();
        } else if (currentCategory().equals("Sports")) {
            showMessage(sportsQuestions.getFirst());
            sportsQuestions.removeFirst();
        } else if (currentCategory().equals("Rock")) {
            showMessage(rockQuestions.getFirst());
            rockQuestions.removeFirst();
        }
    }

    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    private boolean wrongAnswer() {
        showMessage("Question was incorrectly answered");
        showMessage(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size())
            currentPlayer = 0;
        return true;
    }

    private boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                showMessage("Answer was correct!!!!");
                purses[currentPlayer]++;
                showMessage(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size())
                    currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size())
                    currentPlayer = 0;
                return true;
            }
        } else {
            showMessage("Answer was correct!!!!");
            purses[currentPlayer]++;
            showMessage(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size())
                currentPlayer = 0;

            return winner;
        }
    }
}