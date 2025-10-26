package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        List<String> carNames=inputView.carInput().getCarNames();
        int attempt= inputView.attemptInput().getAttempts();
        Cars cars = racingService.createCars(carNames);

        for (int i = 0; i < attempt; i++) {
            racingService.runOneRound(cars);

            outputView.printRoundResult(cars.getCars());
        }

        List<Car> winners = racingService.findWinners(cars);

        outputView.printWinners(winners);
    }
}
