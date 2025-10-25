package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car {
    private final String carName;
    private int carPosition;
    private final ForwardStrategy forwardStrategy;
    private final NumberGenerator numberGenerator;

    public Car(String carName, ForwardStrategy forwardStrategy, NumberGenerator numberGenerator) {
        this.carName = carName;
        this.carPosition = 0;
        this.forwardStrategy = forwardStrategy;
        this.numberGenerator = numberGenerator;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void move(){
        boolean canMove = forwardStrategy.isForward(numberGenerator.generateNumber());

        if(canMove){
            carPosition++;
        }
    }


}
