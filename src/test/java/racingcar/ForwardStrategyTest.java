package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.ForwardStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardStrategyTest {

    private final ForwardStrategy fwd = new ForwardStrategy();

    @Test
    @DisplayName("무작위 값이 4일 경우 전진")
    public void testNumberIsFour_Forward() {
        int testNumber = 4;
        boolean result = fwd.isForward(testNumber);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("무작위 값이 4 이상일 경우 전진")
    public void testNumberIsFourOrMore_Forward() {
        int testNumber = 5;
        boolean result = fwd.isForward(testNumber);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("무작위 값이 4 미만일 경우 전진하지 않음")
    public void testNumberIsLessThanFour_Stop() {
        int testNumber = 3;
        boolean result = fwd.isForward(testNumber);
        assertThat(result).isFalse();
    }
}
