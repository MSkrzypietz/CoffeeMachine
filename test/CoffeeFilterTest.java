package tests;

import base.CoffeeMachine;
import containers.BrewContainer;
import containers.Container;
import filters.CoffeeFilter;
import filters.IFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeFilterTest {

    @Test
    void testFilterContainer() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Container brewContainer = new BrewContainer(coffeeMachine);
        brewContainer.add(25, 'F');
        brewContainer.add(100, 'C');
        brewContainer.add(25, 'F');
        brewContainer.add(400, 'C');

        IFilter coffeeFilter = new CoffeeFilter();
        Container filteredCoffee = coffeeFilter.filterContainer(brewContainer);

        for (int i = 0; i < filteredCoffee.getMatrix().length; i++) {
            for (int j = 0; j < filteredCoffee.getMatrix()[i].length; j++) {
                assertEquals('C', filteredCoffee.getMatrix()[i][j]);
            }
        }
        assertEquals(500, filteredCoffee.removeAll());
    }

}
