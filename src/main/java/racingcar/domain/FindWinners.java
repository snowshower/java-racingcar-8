package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindWinners {

    //객체 생성 막음
    private FindWinners(){}

    public static List<Car> winnerFinder(Cars cars){
        List<Car> carList=cars.getCars();

        Car oneWinner = Collections.max(carList, Comparator.comparingInt(Car::getCarPosition));

        int maxPosition=oneWinner.getCarPosition();

        return carList.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
