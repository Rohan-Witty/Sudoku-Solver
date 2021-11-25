import java.util.*;

public class Cell {
    private boolean[] value;
    boolean isFilled;
    int row;
    int column;
    public Cell(int row, int column){
        value = new boolean[Driver.SIZE];
        isFilled = false;
        this.row = row;
        this.column = column;
    }
    public Cell(int row, int column, int n){
        this(row, column);
        try{
            value[n-1] = true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter row, column and value <= "+ Driver.SIZE + " and >=1.");
            System.exit(0); 
        }
        isFilled = true;
    }
    public void setCell(int n){
        Arrays.fill(value, false);
        value[n-1] = true;
        isFilled = true;
    }
    public void unsetCell(){
        Arrays.fill(value, false);
        isFilled = false;
    }
    public int getValue(){
        for(int i = 0; i<Driver.SIZE; i++){
            if(value[i])
                return i+1;
        }
        return 0;
    }
    @Override
    public String toString(){
        if(isFilled){
            return Integer.toString(getValue());
        }
        return "_";

    }
}