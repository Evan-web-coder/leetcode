package ll.com.decorator;

public class Sugar extends CondimentDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + " + 糖";
    }

    public double cost() {
        return beverage.cost() + 2.0;
    }
}