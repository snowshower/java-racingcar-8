package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printRoundResult(List<Car> cars) {
        System.out.println("실행 결과");

        for (Car car : cars) {
            String dash = "-".repeat(car.getCarPosition());
            System.out.println(car.getCarName() + " : " + dash);
        }
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames=winners.stream().map(Car::getCarName).collect(Collectors.toList());

        String result=String.join(", ", winnerNames);

        System.out.println("최종 우승자 : "+result);
    }
}
