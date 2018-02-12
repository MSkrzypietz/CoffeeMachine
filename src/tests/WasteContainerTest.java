package tests;

import containers.Container;
import containers.WasteContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WasteContainerTest {

    @Test
    void testClean() {
        Container wasteContainer = new WasteContainer();
        wasteContainer.add(30);
        ((WasteContainer) wasteContainer).clean();
        assertEquals(0, wasteContainer.removeAll());
    }

}
