package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car {
    private final String carName;
    private int carPosition;
    private final ForwardStrategy forwardStrategy;
    private final NumberGenerator numberGenerator;

    //테스트용 생성자
    public Car(String carName, int carPosition){
        this.carName = carName;
        this.carPosition = carPosition;
        this.forwardStrategy = null;
        this.numberGenerator = null;
    }

    public Car(String carName, ForwardStrategy forwardStrategy, NumberGenerator numberGenerator) {
        if(carName.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

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
