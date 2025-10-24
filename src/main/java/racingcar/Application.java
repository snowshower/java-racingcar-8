package racingcar;

import racingcar.dto.AttemptInput;
import racingcar.dto.CarInput;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        CarInput carInput = inputView.carInput();

        AttemptInput attemptInput = inputView.attemptInput();







    }
}
