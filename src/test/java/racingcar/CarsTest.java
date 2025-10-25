package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.ForwardStrategy;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    private static class fourGenerator implements NumberGenerator {
        @Override
        public int generateNumber() {
            return 4;
        }
    }

    private final List<String> testCarNames = List.of("pobi", "woni", "jun");

    @Test
    @DisplayName("Cars 객체 생성 확인")
    public void testCarsCreate(){
        Cars cars = new Cars(testCarNames, new ForwardStrategy(), new fourGenerator());

        List<String> testCars=cars.getCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        assertThat(testCars).isEqualTo(testCarNames);
    }

    @Test
    @DisplayName("moveAll 메소드 검증")
    public void testMoveAll(){
        Cars  cars = new Cars(testCarNames, new ForwardStrategy(), new fourGenerator());

        cars.moveAll();

        List<Car> testCars=cars.getCars();

        for (Car testCar : testCars) {
            assertThat(testCar.getCarPosition()).isEqualTo(1);
        }

    }
}
