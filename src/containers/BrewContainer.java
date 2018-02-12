package containers;

import base.CoffeeMachine;
import configuration.Configuration;
import observers.IWaterTempListener;

import java.util.ArrayList;

public class BrewContainer extends Container implements IWaterTempListener {

    private CoffeeMachine coffeeMachine;

    public BrewContainer(CoffeeMachine coffeeMachine) {
        super(new char[25][22], 550, 'C');
        this.coffeeMachine = coffeeMachine;
        init();
    }

    private void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    public void waterIsHeated() {
        combineHotWaterAndCoffeeFlour();
        shuffle();
        createCoffee();
    }

    private void combineHotWaterAndCoffeeFlour() {
        System.out.println("Combining the coffee flour with the hot water in the brew container...");
        sleepThread(1000);

        add(coffeeMachine.getWaterContainer().removeAll(), 'H');
        add(coffeeMachine.getCoffeeFlourContainer().removeAll(), 'F');

        super.printContainer();
    }

    private void shuffle() {
        System.out.println("Shuffling the container...");
        sleepThread(2000);
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                int m = Configuration.instance.randomGenerator.nextInt(0, i);
                int n = Configuration.instance.randomGenerator.nextInt(0, j);

                char temp = matrix[i][j];
                matrix[i][j] = matrix[m][n];
                matrix[m][n] = temp;
            }
        }
        super.printContainer();
        sleepThread(1000);
    }

    private void createCoffee() {
        // With these lists I'm making sure to only use a flour or hot water unit once
        ArrayList<Integer> flourUnits = getUnitsByType('F');
        ArrayList<Integer> hotWaterUnits = getUnitsByType('H');

        while (!flourUnits.isEmpty()) {
            System.out.println("Creating 10 coffee units...");
            flourUnits.remove(Configuration.instance.randomGenerator.nextInt(0, flourUnits.size() - 1));
            sleepThread(1000);
            for (int j = 0; j < 10; j++) {
                int index = hotWaterUnits.remove(Configuration.instance.randomGenerator.nextInt(0, hotWaterUnits.size() - 1));
                matrix[index / matrix[0].length][index % matrix[0].length] = 'C';
            }
            super.printContainer();
        }

        System.out.println("Done brewing the coffee...");
    }

    public ArrayList<Integer> getUnitsByType(char unitType) {
        ArrayList<Integer> units = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == unitType)
                    units.add(i*matrix[i].length + j);
            }
        }
        return units;
    }

    private void sleepThread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
