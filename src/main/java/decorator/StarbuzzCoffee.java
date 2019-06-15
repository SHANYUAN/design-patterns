package decorator;

import decorator.beverages.Beverage;
import decorator.beverages.DarkRoast;
import decorator.beverages.Espresso;
import decorator.beverages.HouseBlend;
import decorator.condiments.CondimentPrettyPrint;
import decorator.condiments.Mocha;
import decorator.condiments.Soy;
import decorator.condiments.Whip;

public class StarbuzzCoffee {

    public static void main(String[] args) {

        // simple espresso
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // dark roast coffee with double mocha and whip
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        // house blend coffee with soy, mocha and whip
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

        // Bonus: pretty print
        beverage2 = new CondimentPrettyPrint(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
