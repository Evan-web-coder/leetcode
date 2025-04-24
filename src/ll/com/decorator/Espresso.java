package ll.com.decorator;

public class Espresso implements Beverage {
    public String getDescription() {
        return "浓缩咖啡 Espresso";
    }

    public double cost() {
        return 20.0;
    }
}
