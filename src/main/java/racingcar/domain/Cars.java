package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    //테스트용 생성자
    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public Cars(List<String> carNames, ForwardStrategy forwardStrategy, NumberGenerator numberGenerator) {
        this.cars = carNames.stream()
                .map(name -> new Car(name, forwardStrategy, numberGenerator))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }
}
