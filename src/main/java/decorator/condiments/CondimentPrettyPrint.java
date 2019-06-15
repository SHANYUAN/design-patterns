package decorator.condiments;

import decorator.beverages.Beverage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CondimentPrettyPrint extends CondimentDecorator {
    private final Beverage beverage;

    public CondimentPrettyPrint(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost();
    }

    @Override
    public String getDescription() {
        String description = beverage.getDescription();
        List<String> condiments = List.of(description.split(","))
            .stream()
            .map(String::trim)
            .collect(Collectors.toList());

        condiments = replaceDouble(condiments, "Mocha");
        condiments = replaceDouble(condiments, "Whip");
        condiments = replaceDouble(condiments, "Soy");

        String condimentsMiddleString = condiments.stream()
            .skip(1) // skip base beverage
            .limit(condiments.size()-2)
            .collect(Collectors.joining(" "));

        return String.format(
            "%s, %s and %s",
            condiments.get(0),
            condimentsMiddleString,
            condiments.get(condiments.size()-1)
        );
    }

    private List<String> replaceDouble(final List<String> condiments, String name) {
        List<String> result = new ArrayList<>(condiments);

        if (count(result, name) == 2) {
            result = remove(result, name);
            result.add(1, "Double " + name);
        }

        return result;
    }

    private long count(List<String> condiments, String name) {
        return condiments.stream()
            .filter(c -> c.equals(name))
            .count();
    }

    private List<String> remove(List<String> condiments, String name) {
        return condiments.stream()
            .filter(c -> !c.equals(name))
            .collect(Collectors.toList());
    }
}
