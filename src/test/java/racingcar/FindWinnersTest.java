package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.domain.FindWinners.winnerFinder;

public class FindWinnersTest {

    @Test
    @DisplayName("우승자가 한 명일 경우 올바르게 반환하는지 검증")
    public void findOneWinners() {
        Car pobi = new Car("pobi", 3);
        Car woni = new Car("woni", 4);
        Cars testCars = new Cars(List.of(pobi, woni));

        List<Car> winners = winnerFinder(testCars);

        assertThat(winners).isEqualTo(List.of(woni));
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 올바르게 반환하는지 검증")
    public void findSomeWinners() {
        Car pobi = new Car("pobi", 3);
        Car woni = new Car("woni", 3);
        Cars testCars = new Cars(List.of(pobi, woni));

        List<Car> winners = winnerFinder(testCars);

        List<Car> listForExpectedWinners = List.of(pobi, woni);
        List<Car> expectedWinners = new ArrayList<>(listForExpectedWinners);

        winners.sort(Comparator.comparing(Car::getCarName));
        expectedWinners.sort(Comparator.comparing(Car::getCarName));


        assertThat(winners).isEqualTo(expectedWinners);
    }
}
