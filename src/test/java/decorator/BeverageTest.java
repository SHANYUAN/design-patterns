package decorator;

import decorator.beverages.*;
import decorator.condiments.CondimentPrettyPrint;
import decorator.condiments.Mocha;
import decorator.condiments.Soy;
import decorator.condiments.Whip;
import org.junit.Test;

import static decorator.beverages.Beverage.Size.GRANDE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BeverageTest {

    @Test
    public void espresso() {
        Espresso espresso = new Espresso();

        assertThat(espresso.getDescription(), is("Espresso"));
        assertThat(espresso.cost(), is(1.99));
    }

    @Test
    public void houseBlend() {
        HouseBlend houseBlend = new HouseBlend();

        assertThat(houseBlend.getDescription(), is("House Blend Coffee"));
        assertThat(houseBlend.cost(), is(.89));
    }

    @Test
    public void darkRoast() {
        DarkRoast darkRoast = new DarkRoast();

        assertThat(darkRoast.getDescription(), is("Dark Roast Coffee"));
        assertThat(darkRoast.cost(), is(.99));
    }

    @Test
    public void decaf() {
        Decaf decaf = new Decaf();

        assertThat(decaf.getDescription(), is("Decaf Coffee"));
        assertThat(decaf.cost(), is(1.05));
    }

    @Test
    public void darkRoastWithMocha() {
        DarkRoast darkRoast = new DarkRoast();
        Mocha darkRoastWithMocha = new Mocha(darkRoast);

        assertThat(darkRoastWithMocha.getDescription(), is("Dark Roast Coffee, Mocha"));
        assertThat(darkRoastWithMocha.cost(), is(1.19));
    }

    @Test
    public void darkRoastWithSoy() {
        DarkRoast darkRoast = new DarkRoast();
        Soy darkRoastWithSoy = new Soy(darkRoast);

        assertThat(darkRoastWithSoy.getDescription(), is("Dark Roast Coffee, Soy"));
        assertThat(darkRoastWithSoy.cost(), is(1.09));
    }

    @Test
    public void darkRoastWithWhip() {
        DarkRoast darkRoast = new DarkRoast();
        Whip darkRoastWithWhip = new Whip(darkRoast);

        assertThat(darkRoastWithWhip.getDescription(), is("Dark Roast Coffee, Whip"));
        assertThat(darkRoastWithWhip.cost(), is(1.09));
    }

    @Test
    public void darkRoastWithDoubleMochaAndWhip() {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        assertThat(beverage.getDescription(), is("Dark Roast Coffee, Mocha, Mocha, Whip"));
        assertThat(beverage.cost(), is(1.49));
    }

    @Test
    public void darkRoastWithDoubleMochaAndWhip_prettyPrinted() {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        beverage = new CondimentPrettyPrint(beverage);

        assertThat(beverage.getDescription(), is("Dark Roast Coffee, Double Mocha and Whip"));
    }

    @Test
    public void grandeDecafWithSoy() {
        Beverage beverage = new Decaf();
        beverage.setSize(GRANDE);
        beverage = new Soy(beverage);

        assertThat(beverage.cost(), is(1.05 + .15));
    }
}
