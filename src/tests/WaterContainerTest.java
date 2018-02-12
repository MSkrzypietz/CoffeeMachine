package tests;

import containers.Container;
import containers.WaterContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterContainerTest {

    @Test
    void testHeatUpWater() {
        Container waterContainer = new WaterContainer();
        waterContainer.fillUp();
        ((WaterContainer) waterContainer).coffeeFlourContainerIsFull();

        for (int i = 0; i < waterContainer.getMatrix().length; i++) {
            for (int j = 0; j < waterContainer.getMatrix()[i].length; j++) {
                assertEquals('H', waterContainer.getMatrix()[i][j]);
            }
        }
    }

}
