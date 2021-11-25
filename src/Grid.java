import java.util.*;

public class Grid {
    ArrayList<ArrayList<Cell>> gridOfRows;

    Grid() {
        gridOfRows = new ArrayList<>();
        for (int i = 0; i < Driver.SIZE; i++) {
            ArrayList<Cell> r1 = new ArrayList<>();
            for (int j = 0; j < Driver.SIZE; j++) {
                r1.add(new Cell(i + 1, j + 1));
            }
            gridOfRows.add(r1);
        }
    }

    public Grid(Grid grid) {
        this();
        for (ArrayList<Cell> row : gridOfRows) {
            for (Cell cell : row) {
                if (grid.gridOfRows.get(cell.row - 1).get(cell.column - 1).isFilled) {
                    cell.setCell(grid.gridOfRows.get(cell.row - 1).get(cell.column - 1).getValue());
                }
            }
        }
    }

    public void printGrid() {
        for (ArrayList<Cell> row : gridOfRows) {
            System.out.println(row);
        }

    }

    public void acceptInput() {
        try {
            int n;
            System.out.println("Enter number of elements");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            System.out.println("Input " + n + " elements in the form:");
            System.out.println("row column digit");
            for (int i = 0; i < n; i++) {
                int row = in.nextInt();
                int col = in.nextInt();
                gridOfRows.get(row - 1).set(col - 1, new Cell(row, col, in.nextInt()));
            }
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("Enter valid input.");
            System.exit(1);
        }
    }

    public boolean isSafe(int value, Cell cell) {
        for (ArrayList<Cell> row : gridOfRows) {
            Cell current = row.get(cell.column - 1);
            if (current.isFilled && current.getValue() == value) {
                return false;
            }
        }
        for (Cell current : gridOfRows.get(cell.row - 1)) {
            if (current.isFilled && current.getValue() == value) {
                return false;
            }
        }
        for (int i = Driver.SMALLSIZE * ((cell.row - 1) / Driver.SMALLSIZE); i < Driver.SMALLSIZE
                * ((cell.row - 1) / Driver.SMALLSIZE + 1); i++) {
            for (int j = Driver.SMALLSIZE * ((cell.column - 1) / Driver.SMALLSIZE); j < Driver.SMALLSIZE
                    * ((cell.column - 1) / Driver.SMALLSIZE + 1); j++) {
                Cell current = gridOfRows.get(i).get(j);
                if (current.getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
