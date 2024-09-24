package unit_tests;

import org.junit.jupiter.api.Test;
import ugly_trivia.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameTest {
    @Test
    public void sample_simulation_1() {
        var rollResults = Arrays.asList(5, 4, 2, 2, 3, 4, 2, 3, 3, 5, 3, 2, 3, 5, 3, 3, 1, 1, 4, 5);
        var answerIsRightList = Arrays.asList(false, false, false, true, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false);
        final GameForTesting game = new GameForTesting(rollResults, answerIsRightList);
        game.add("Chet");
        game.add("Pat");
        game.add("Sue");

        game.run();

        assertThat(game.messagesShown, is(getExpectedMessagesForSimulation1()));
    }

    @Test
    public void sample_simulation_2() {
        var rollResults = Arrays.asList(3, 2, 3, 2, 3, 4, 3, 5, 3, 3, 5, 3, 4, 1, 5, 2, 4, 3, 3, 1, 1, 1, 3, 2, 3, 3, 4);
        var answerIsRightList = Arrays.asList(true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
        final GameForTesting game = new GameForTesting(rollResults, answerIsRightList);
        game.add("Chet");
        game.add("Pat");
        game.add("Sue");
        game.add("Pete");
        game.add("Meh");

        game.run();

        assertThat(game.messagesShown, is(getExpectedMessagesForSimulation2()));
    }

    private List<String> getExpectedMessagesForSimulation1() {
        return Arrays.asList("Chet was added","They are player number 1","Pat was added","They are player number 2","Sue was added","They are player number 3","Chet is the current player","They have rolled a 5","Chet's new location is 5","The category is Science","Science Question 0","Answer was correct!!!!","Chet now has 1 Gold Coins.","Pat is the current player","They have rolled a 4","Pat's new location is 4","The category is Pop","Pop Question 0","Answer was correct!!!!","Pat now has 1 Gold Coins.","Sue is the current player","They have rolled a 2","Sue's new location is 2","The category is Sports","Sports Question 0","Answer was correct!!!!","Sue now has 1 Gold Coins.","Chet is the current player","They have rolled a 2","Chet's new location is 7","The category is Rock","Rock Question 0","Question was incorrectly answered","Chet was sent to the penalty box","Pat is the current player","They have rolled a 3","Pat's new location is 7","The category is Rock","Rock Question 1","Answer was correct!!!!","Pat now has 2 Gold Coins.","Sue is the current player","They have rolled a 4","Sue's new location is 6","The category is Sports","Sports Question 1","Answer was correct!!!!","Sue now has 2 Gold Coins.","Chet is the current player","They have rolled a 2","Chet is not getting out of the penalty box","Pat is the current player","They have rolled a 3","Pat's new location is 10","The category is Sports","Sports Question 2","Answer was correct!!!!","Pat now has 3 Gold Coins.","Sue is the current player","They have rolled a 3","Sue's new location is 9","The category is Science","Science Question 1","Question was incorrectly answered","Sue was sent to the penalty box","Chet is the current player","They have rolled a 5","Chet is getting out of the penalty box","Chet's new location is 0","The category is Pop","Pop Question 1","Answer was correct!!!!","Chet now has 2 Gold Coins.","Pat is the current player","They have rolled a 3","Pat's new location is 1","The category is Science","Science Question 2","Question was incorrectly answered","Pat was sent to the penalty box","Sue is the current player","They have rolled a 2","Sue is not getting out of the penalty box","Chet is the current player","They have rolled a 3","Chet is getting out of the penalty box","Chet's new location is 3","The category is Rock","Rock Question 2","Answer was correct!!!!","Chet now has 3 Gold Coins.","Pat is the current player","They have rolled a 5","Pat is getting out of the penalty box","Pat's new location is 6","The category is Sports","Sports Question 3","Answer was correct!!!!","Pat now has 4 Gold Coins.","Sue is the current player","They have rolled a 3","Sue is getting out of the penalty box","Sue's new location is 0","The category is Pop","Pop Question 2","Answer was correct!!!!","Sue now has 3 Gold Coins.","Chet is the current player","They have rolled a 3","Chet is getting out of the penalty box","Chet's new location is 6","The category is Sports","Sports Question 4","Answer was correct!!!!","Chet now has 4 Gold Coins.","Pat is the current player","They have rolled a 1","Pat is getting out of the penalty box","Pat's new location is 7","The category is Rock","Rock Question 3","Answer was correct!!!!","Pat now has 5 Gold Coins.","Sue is the current player","They have rolled a 1","Sue is getting out of the penalty box","Sue's new location is 1","The category is Science","Science Question 3","Answer was correct!!!!","Sue now has 4 Gold Coins.","Chet is the current player","They have rolled a 4","Chet is not getting out of the penalty box","Pat is the current player","They have rolled a 5","Pat is getting out of the penalty box","Pat's new location is 0","The category is Pop","Pop Question 3","Answer was correct!!!!","Pat now has 6 Gold Coins.");
    }

    private List<String> getExpectedMessagesForSimulation2() {
        return Arrays.asList("Chet was added","They are player number 1","Pat was added","They are player number 2","Sue was added","They are player number 3","Pete was added","They are player number 4","Meh was added","They are player number 5","Chet is the current player","They have rolled a 3","Chet's new location is 3","The category is Rock","Rock Question 0","Question was incorrectly answered","Chet was sent to the penalty box","Pat is the current player","They have rolled a 2","Pat's new location is 2","The category is Sports","Sports Question 0","Answer was correct!!!!","Pat now has 1 Gold Coins.","Sue is the current player","They have rolled a 3","Sue's new location is 3","The category is Rock","Rock Question 1","Answer was correct!!!!","Sue now has 1 Gold Coins.","Pete is the current player","They have rolled a 2","Pete's new location is 2","The category is Sports","Sports Question 1","Answer was correct!!!!","Pete now has 1 Gold Coins.","Meh is the current player","They have rolled a 3","Meh's new location is 3","The category is Rock","Rock Question 2","Answer was correct!!!!","Meh now has 1 Gold Coins.","Chet is the current player","They have rolled a 4","Chet is not getting out of the penalty box","Pat is the current player","They have rolled a 3","Pat's new location is 5","The category is Science","Science Question 0","Answer was correct!!!!","Pat now has 2 Gold Coins.","Sue is the current player","They have rolled a 5","Sue's new location is 8","The category is Pop","Pop Question 0","Answer was correct!!!!","Sue now has 2 Gold Coins.","Pete is the current player","They have rolled a 3","Pete's new location is 5","The category is Science","Science Question 1","Answer was correct!!!!","Pete now has 2 Gold Coins.","Meh is the current player","They have rolled a 3","Meh's new location is 6","The category is Sports","Sports Question 2","Question was incorrectly answered","Meh was sent to the penalty box","Chet is the current player","They have rolled a 5","Chet is getting out of the penalty box","Chet's new location is 8","The category is Pop","Pop Question 1","Answer was correct!!!!","Chet now has 1 Gold Coins.","Pat is the current player","They have rolled a 3","Pat's new location is 8","The category is Pop","Pop Question 2","Answer was correct!!!!","Pat now has 3 Gold Coins.","Sue is the current player","They have rolled a 4","Sue's new location is 0","The category is Pop","Pop Question 3","Answer was correct!!!!","Sue now has 3 Gold Coins.","Pete is the current player","They have rolled a 1","Pete's new location is 6","The category is Sports","Sports Question 3","Answer was correct!!!!","Pete now has 3 Gold Coins.","Meh is the current player","They have rolled a 5","Meh is getting out of the penalty box","Meh's new location is 11","The category is Rock","Rock Question 3","Answer was correct!!!!","Meh now has 2 Gold Coins.","Chet is the current player","They have rolled a 2","Chet is not getting out of the penalty box","Pat is the current player","They have rolled a 4","Pat's new location is 0","The category is Pop","Pop Question 4","Answer was correct!!!!","Pat now has 4 Gold Coins.","Sue is the current player","They have rolled a 3","Sue's new location is 3","The category is Rock","Rock Question 4","Answer was correct!!!!","Sue now has 4 Gold Coins.","Pete is the current player","They have rolled a 3","Pete's new location is 9","The category is Science","Science Question 2","Answer was correct!!!!","Pete now has 4 Gold Coins.","Meh is the current player","They have rolled a 1","Meh is getting out of the penalty box","Meh's new location is 0","The category is Pop","Pop Question 5","Answer was correct!!!!","Meh now has 3 Gold Coins.","Chet is the current player","They have rolled a 1","Chet is getting out of the penalty box","Chet's new location is 9","The category is Science","Science Question 3","Answer was correct!!!!","Chet now has 2 Gold Coins.","Pat is the current player","They have rolled a 1","Pat's new location is 1","The category is Science","Science Question 4","Answer was correct!!!!","Pat now has 5 Gold Coins.","Sue is the current player","They have rolled a 3","Sue's new location is 6","The category is Sports","Sports Question 4","Answer was correct!!!!","Sue now has 5 Gold Coins.","Pete is the current player","They have rolled a 2","Pete's new location is 11","The category is Rock","Rock Question 5","Answer was correct!!!!","Pete now has 5 Gold Coins.","Meh is the current player","They have rolled a 3","Meh is getting out of the penalty box","Meh's new location is 3","The category is Rock","Rock Question 6","Answer was correct!!!!","Meh now has 4 Gold Coins.","Chet is the current player","They have rolled a 3","Chet is getting out of the penalty box","Chet's new location is 0","The category is Pop","Pop Question 6","Answer was correct!!!!","Chet now has 3 Gold Coins.","Pat is the current player","They have rolled a 4","Pat's new location is 5","The category is Science","Science Question 5","Answer was correct!!!!","Pat now has 6 Gold Coins.");
    }

    private class GameForTesting extends Game {
        private final List<Integer> rollResults;
        private final List<Boolean> answerIsRightList;
        public final List<String> messagesShown;
        private int answersIndex;
        private int rollsIndex;

        public GameForTesting(List<Integer> rollResults, List<Boolean> answerIsRightList) {
            this.rollResults = rollResults;
            this.answerIsRightList = answerIsRightList;
            this.messagesShown = new ArrayList<>();
            this.answersIndex = 0;
            this.rollsIndex = 0;
        }

        @Override
        protected void showMessage(String message) {
            this.messagesShown.add(message);
        }

        @Override
        protected boolean isAnswerRight() {
            final Boolean result = answerIsRightList.get(answersIndex);
            answersIndex++;
            return result;
        }

        @Override
        protected int getRollResult() {
            final Integer result = rollResults.get(rollsIndex);
            rollsIndex++;
            return result;
        }
    }
}