package containers;

public class WasteContainer extends Container {

    public WasteContainer() {
        super(new char[50][4], 200, 'F');
        init();
    }

    public void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

}
