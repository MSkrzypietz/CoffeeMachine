package containers;

import configuration.Configuration;
import observers.ICoffeeFlourLevelListener;
import observers.WaterTempObserver;

import java.util.ArrayList;

public class WaterContainer extends Container implements ICoffeeFlourLevelListener {

    private WaterTempObserver waterTempObserver = new WaterTempObserver();

    public WaterContainer() {
        super(new char[25][20], 500, 'W');
        init();
    }

    private void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    public void coffeeFlourContainerIsFull() {
        heatUpWater();
    }

    private void heatUpWater() {
        System.out.println("Heating up the water...");
        ArrayList<Integer> waterUnits = new ArrayList<>();
        for (int i = 0; i < 500; i++)
            waterUnits.add(i);
        for (int i = 0; i < 5; i++) {
            sleepThread(1000);
            for (int j = 0; j < 100; j++) {
                int index = waterUnits.remove(Configuration.instance.randomGenerator.nextInt(0, waterUnits.size() - 1));
                matrix[index / matrix[0].length][index % matrix[0].length] = 'H';
            }
            //super.printContainer();
            //System.out.println("############################################################################");
        }
        System.out.println("Water is now hot...");
        waterTempObserver.waterIsHeated();
    }

    private void sleepThread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WaterTempObserver getWaterTempObserver() {
        return waterTempObserver;
    }

}
