package containers;

public class CoffeeCup extends Container {

    public CoffeeCup() {
        super(new char[25][20], 500, 'C');
        init();
    }

    private void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

}
