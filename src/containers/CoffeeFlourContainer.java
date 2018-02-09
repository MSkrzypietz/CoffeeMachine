package containers;

import observers.CoffeeFlourLevelObserver;

public class CoffeeFlourContainer extends Container {

    private CoffeeFlourLevelObserver coffeeFlourLevelObserver = new CoffeeFlourLevelObserver();

    public CoffeeFlourContainer() {
        super(new char[5][10], 50, 'F');
        init();
    }

    public void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    public CoffeeFlourLevelObserver getCoffeeFlourLevelObserver() {
        return coffeeFlourLevelObserver;
    }

    public void checkIfFullToHeatWater() {
        if (currentAmount >= capacity)
            coffeeFlourLevelObserver.coffeeFlourContainerIsFull();
    }

}
