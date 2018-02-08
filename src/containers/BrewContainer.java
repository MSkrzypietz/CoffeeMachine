package containers;

public class BrewContainer extends Container {

    public BrewContainer() {
        super(new char[25][22], 550, 'C');
        init();
    }

    public void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

}
