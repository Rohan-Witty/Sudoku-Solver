import java.util.*;

public class Solver {
    private ArrayList<Grid> solution;
    public Solver(){
        solution = new ArrayList<>();
    }
    public boolean solve(Grid grid){
        Cell current = null;
        boolean grid_filled = true;
        for (ArrayList<Cell> row : grid.gridOfRows) {
            for (Cell cell : row) {
                if(!cell.isFilled){
                    current = cell;
                    grid_filled = false;
                }
            }
        }
        if(grid_filled){
            Grid solved = new Grid(grid);
            solution.add(solved);
            return false;
            //Returning false to get all possible solutions.
            //Will get single solution if returned true.
        }
        for(int i = 1; i<=Driver.SIZE; i++){
            if(grid.isSafe(i, current)){
                current.setCell(i);
            
            try{
                if(solve(grid)){
                    return true;
                }
                else{
                current.unsetCell();
            }
            }
            catch(Exception e){
                System.out.println(e);
                System.exit(1);
            }
            }            
        }
        return false;

    }
    public List<Grid> getSolution() {
        return solution;
    }
}