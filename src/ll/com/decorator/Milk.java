package ll.com.decorator;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + " + 牛奶";
    }

    public double cost() {
        return beverage.cost() + 5.0;
    }
}
