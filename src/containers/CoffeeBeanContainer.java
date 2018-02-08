package containers;

public class CoffeeBeanContainer extends Container {

    public CoffeeBeanContainer() {
        super(new char[20][5], 100, 'B');
        init();
    }

    public void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    public void grindCoffeeBeans(int amount) {
        System.out.println("Grinding coffee beans...");
    }

}
