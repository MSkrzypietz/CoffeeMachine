package filters;

import containers.Container;
import containers.WasteContainer;

public class FlourFilter implements IFilter {

    public Container filterContainer(Container brewContainer) {
        System.out.println("Filtering the coffee grounds...");
        Container wasteContainer = new WasteContainer();

        for (int i = brewContainer.getMatrix().length - 1; i >= 0; i--) {
            for (int j = 0; j < brewContainer.getMatrix()[i].length; j++) {
                if (brewContainer.getMatrix()[i][j] == '-') break;
                if (brewContainer.getMatrix()[i][j] == 'F') wasteContainer.add(1);
            }
        }

        return wasteContainer;
    }

}
