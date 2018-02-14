package tests;

import base.CoffeeMachine;
import containers.BrewContainer;
import containers.Container;
import filters.FlourFilter;
import filters.IFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlourFilterTest {
    
    @Test
    void testFilterContainer() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Container brewContainer = new BrewContainer(coffeeMachine);
        brewContainer.add(25, 'F');
        brewContainer.add(100, 'C');
        brewContainer.add(25, 'F');
        brewContainer.add(400, 'C');

        IFilter flourFilter = new FlourFilter();
        Container filteredFlour = flourFilter.filterContainer(brewContainer);

        for (int i = 0; i < filteredFlour.getMatrix().length; i++) {
            for (int j = 0; j < filteredFlour.getMatrix()[i].length; j++) {
                assertTrue(filteredFlour.getMatrix()[i][j] == 'F' || filteredFlour.getMatrix()[i][j] == '-');
            }
        }
        assertEquals(50, filteredFlour.removeAll());
    }
    
}
