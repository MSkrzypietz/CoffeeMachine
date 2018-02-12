package tests;

import base.CoffeeMachine;
import containers.BrewContainer;
import containers.Container;
import containers.WaterContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerTest {

    @Test
    void testAddAndRemove() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Container testContainer = new BrewContainer(coffeeMachine);
        testContainer.add(10);
        testContainer.add(35);
        testContainer.remove(20);
        testContainer.add(1);

        assertEquals(26, testContainer.removeAll());
    }

    @Test
    void testFillUp() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Container testContainer = new BrewContainer(coffeeMachine);

        testContainer.fillUp();
        assertEquals(550, testContainer.removeAll());

        testContainer.add(20);
        testContainer.fillUp();
        assertEquals(550, testContainer.removeAll());


        testContainer = new WaterContainer();

        testContainer.fillUp();
        assertEquals(500, testContainer.removeAll());

        testContainer.add(20);
        testContainer.fillUp();
        assertEquals(500, testContainer.removeAll());
    }

}
