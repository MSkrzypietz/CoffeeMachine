package containers;

import observers.ICoffeeFlourLevelListener;

public class WaterContainer extends Container implements ICoffeeFlourLevelListener {

    public WaterContainer() {
        super(new char[25][20], 500, 'W');
        init();
    }

    public void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    public void coffeeFlourContainerIsFull() {
        heatUpWater();
    }

    private void heatUpWater() {
        System.out.println("Heating up the water...");
    }

}
