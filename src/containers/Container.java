package containers;

public abstract class Container {

    protected final char[][] matrix;
    protected final int capacity;
    protected final char unit;

    protected int currentAmount = 0;

    private int currentRowIndex;
    private int currentColIndex;

    public Container(char[][] matrix, int capacity, char unit) {
        this.matrix = matrix;
        this.capacity = capacity;
        this.unit = unit;
        currentRowIndex = matrix.length - 1;
        currentColIndex = 0;
    }

    public void add(int amount) {
        add(amount, unit);
    }

    public void add(int amount, char unit) {
        if (amount <= 0) return;
        for (int i = currentRowIndex; i >= 0; i--) {
            for (int j = currentColIndex; j < matrix[i].length; j++) {
                currentColIndex = 0;
                matrix[i][j] = unit;
                currentAmount++;
                if (--amount == 0) {
                    if (j == matrix[i].length - 1) {
                        currentRowIndex = i - 1;
                        currentColIndex = 0;
                    } else {
                        currentRowIndex = i;
                        currentColIndex = j + 1;
                    }
                    return;
                }
            }
        }
    }

    public void remove(int amount) {
        if (amount <= 0) return;
        if (currentColIndex == 0) {
            currentColIndex = matrix[currentColIndex].length - 1;
            currentRowIndex++;
        } else {
            currentColIndex--;
        }
        for (int i = currentRowIndex; i < matrix.length; i++) {
            for (int j = currentColIndex; j >= 0; j--) {
                currentColIndex = matrix[i].length - 1;
                matrix[i][j] = '-';
                currentAmount--;
                if (--amount == 0) {
                    if (j == matrix[i].length) {
                        currentRowIndex = i - 1;
                        currentColIndex = 0;
                    } else {
                        currentRowIndex = i;
                        currentColIndex = j;
                    }
                    return;
                }
            }
        }
    }

    public int removeAll() {
        int temp = currentAmount;
        remove(currentAmount);
        return temp;
    }

    public void fillUp() {
        add(capacity);
    }

    public void printContainer() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public char[][] getMatrix() {
        return matrix;
    }
    
}
