package containers;

public class WasteContainer extends Container {

    public WasteContainer() {
        super(new char[20][10], 200, 'F');
        init();
    }

    private void init() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    public void clean() {
        System.out.println("Cleaning the waste container...");
        super.removeAll();
        super.printContainer();
    }

}
