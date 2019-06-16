package decorator.condiments;

import decorator.beverages.Beverage;

public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        if (beverage.getSize() == Size.VENTI) {
            return beverage.cost() + .20;
        }

        if (beverage.getSize() == Size.GRANDE) {
            return beverage.cost() + .15;
        }

        return beverage.cost() + .10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
