package containers;

public abstract class Container {

    protected final char[][] matrix;
    protected final int capacity;
    protected final char unit;

    private int currentRowIndex;
    private int currentColIndex;

    public Container(char[][] matrix, int capacity, char unit) {
        this.matrix = matrix;
        this.capacity = capacity;
        this.unit = unit;
        currentRowIndex = matrix.length - 1;
        currentColIndex = 0;
    }

    public void printContainer() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public void add(int amount) {
        if (amount <= 0) return;
        for (int i = currentRowIndex; i > 0; i--) {
            for (int j = currentColIndex; j < matrix[i].length; j++) {
                currentColIndex = 0;
                matrix[i][j] = unit;
                if (--amount == 0) {
                    //if (currentRowIndex )
                    currentRowIndex = i;
                    currentColIndex = j;
                    return;
                }
            }
        }
    }

    public void remove(int amount) {
        if (amount <= 0) return;
        for (int i = currentRowIndex; i < matrix.length - 1; i++) {
            for (int j = currentColIndex - 1; j >= 0; j--) {
                currentColIndex = matrix[i].length;
                if (amount == 0) {
                    currentRowIndex = i;
                    currentColIndex = j;
                    return;
                }
                matrix[i][j] = '-';
                amount--;
            }
        }
    }

}
