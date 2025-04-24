package ll.com.decorator;

public class HouseBlend implements Beverage {
    public String getDescription() {
        return "House Blend 咖啡";
    }

    public double cost() {
        return 15.0;
    }
}