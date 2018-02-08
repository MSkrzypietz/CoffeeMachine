package containers;

public class WaterContainer extends Container {

    public WaterContainer() {
        super(new char[25][20], 500, 'W');
        init();
    }

    public void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

}
