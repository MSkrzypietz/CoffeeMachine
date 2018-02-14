package tests;

import base.CoffeeMachine;
import containers.BrewContainer;
import containers.Container;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrewContainerTest {

    @Test
    void testGetUnitsByType() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Container testContainer = new BrewContainer(coffeeMachine);
        testContainer.add(10, 'F');
        testContainer.add(30, 'H');
        testContainer.add(20, 'F');
        testContainer.add(5, 'H');
        testContainer.add(40, 'F');
        testContainer.add(15, 'H');

        assertEquals(70, ((BrewContainer) testContainer).getUnitsByType('F').size());
        assertEquals(50, ((BrewContainer) testContainer).getUnitsByType('H').size());
    }

}
