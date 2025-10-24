package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.ForwardStrategy;
import racingcar.util.NumberGenerator;

public class CarTest {

    //4만 반환하는 테스트용 난수 생성기
    private static class fourGenerator implements NumberGenerator {
        @Override
        public int generateNumber() {
            return 4;
        }
    }

    //3만 반환하는 테스트용 난수 생성기
    private static class threeGenerator implements NumberGenerator {
        @Override
        public int generateNumber() {
            return 3;
        }
    }

    @Test
    @DisplayName("난수가 4 이상이면 전진한다")
    public void randomNumberIsFourOrMore_Forward() {

        Car car = new Car("pobi", new ForwardStrategy(), new fourGenerator());

        Assertions.assertThat(car.getCarPosition()).isEqualTo(0);

        car.move();

        Assertions.assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("난수가 4 미만이면 전진하지 않는다")
    public void randomNumberIsLessThanFour_Stop() {

        Car car = new Car("pobi", new ForwardStrategy(), new threeGenerator());

        Assertions.assertThat(car.getCarPosition()).isEqualTo(0);

        car.move();

        Assertions.assertThat(car.getCarPosition()).isEqualTo(0);
    }
}
