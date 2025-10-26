package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.FindWinners;
import racingcar.domain.ForwardStrategy;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingService {

    public RacingService() {
    }

    public Cars createCars(List<String> carNames) {
        return new Cars(carNames, new ForwardStrategy(), new RandomNumberGenerator());
    }

    public void runOneRound(Cars cars) {
        cars.moveAll();
    }

    public List<Car> findWinners(Cars cars){
        return FindWinners.winnerFinder(cars);
    }
}
