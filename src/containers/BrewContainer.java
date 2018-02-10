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

        coffeeMachine.getCoffeeFlourContainer().remove(50);
        coffeeMachine.getWaterContainer().remove(500);

        add(500, 'H');
        add(50, 'F');
    }

    private void shuffle() {
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                int m = Configuration.instance.randomGenerator.nextInt(0, i);
                int n = Configuration.instance.randomGenerator.nextInt(0, j);

                char temp = matrix[i][j];
                matrix[i][j] = matrix[m][n];
                matrix[m][n] = temp;
            }
        }
    }

    private void createCoffee() {
        ArrayList<Integer> hotWaterUnits = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'H')
                    hotWaterUnits.add(i*matrix[i].length + j);
            }
        }
        for (int i = 0; i < 50; i++) {
            System.out.println("Creating 10 coffee units...");
            //sleepThread(1000);
            for (int j = 0; j < 10; j++) {
                int index = hotWaterUnits.remove(Configuration.instance.randomGenerator.nextInt(0, hotWaterUnits.size() - 1));
                matrix[index / matrix[0].length][index % matrix[0].length] = 'C';
            }
        }
    }

    private void sleepThread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
