package racingcar.dto;

import java.util.List;

public class CarInput {
    private final List<String> carNames;

    public CarInput(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
