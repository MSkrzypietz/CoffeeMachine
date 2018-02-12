package filters;

import containers.CoffeeCup;
import containers.Container;

public class CoffeeFilter implements IFilter {

    public Container filterContainer(Container brewContainer) {
        System.out.println("Filtering the coffee...");
        Container coffeeCup = new CoffeeCup();

        for (int i = brewContainer.getMatrix().length - 1; i >= 0; i--) {
            for (int j = 0; j < brewContainer.getMatrix()[i].length; j++) {
                if (brewContainer.getMatrix()[i][j] == '-') break;
                if (brewContainer.getMatrix()[i][j] == 'C') coffeeCup.add(1);
            }
        }

        return coffeeCup;
    }

}
