package ll.com.decorator;

public class Main {
    public static void main(String[] args) {
        // 点一杯浓缩咖啡
        Beverage espresso = new Espresso();

        // 加牛奶
        espresso = new Milk(espresso);

        // 再加糖
        espresso = new Sugar(espresso);

        System.out.println("订单: " + espresso.getDescription());
        System.out.println("总价: ¥" + espresso.cost());
    }
}
