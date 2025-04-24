package ll.com.decorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + " + 摩卡";
    }

    public double cost() {
        return beverage.cost() + 6.0;
    }
}