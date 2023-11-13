import java.awt.Color;

public class Cellule {
    protected int cell_state; // State of the cell

    //in schelling, we will need to remember the position of the cellule
    protected int x;
    protected int y;


    protected Cellule(int cell_state, int x, int y){
        this.cell_state = cell_state;
        this.x = x;
        this.y = y;
    }

    //We will need this constructor to deep_copy a cell 
    protected Cellule(Cellule copied_cell){
        this.cell_state = copied_cell.cell_state;
        this.x = copied_cell.x;
        this.y = copied_cell.y;
    }

    public String toString(){
        return "ETAT["+this.cell_state+"]";
    }
}
