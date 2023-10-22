package baseball.logic;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.constant.Constant.*;

public class GameManage {

    private int strike;
    private int ball;

    public void init() {
        strike = 0;
        ball = 0;
    }

    public int getStrikeCount() {
        return this.strike;
    }

    public int getBallCount() {
        return this.ball;
    }

    public void getResult(List<Integer> answerNumbers, List<Integer> userNumbers) {
        checkStrike(answerNumbers, userNumbers);
        checkBall(answerNumbers, userNumbers);
    }

    public void showResult() {
        message(strike, ball);
    }

    private void message(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }
    }

    private void checkStrike(List<Integer> answerNumbers, List<Integer> userNumbers) {
        strike = (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> answerNumbers.get(i).equals(userNumbers.get(i)))
                .count();
    }

    private void checkBall(List<Integer> answerNumbers, List<Integer> userNumbers) {
        ball = (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> answerNumbers.get(i) != userNumbers.get(i) && answerNumbers.contains(userNumbers.get(i)))
                .count();
    }
}
