
public class Driver {
    public static final int SIZE = 9;
    public static final int SMALLSIZE = 3;
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.acceptInput();
        Solver solver = new Solver();
        GUI gui = new GUI(grid, solver.getSolution());
        solver.solve(grid);
        System.out.println("Number of solutions is "+ solver.getSolution().size());
        System.out.println("Close the GUI to exit.");
        gui.updateGUI(1);
    }
}
