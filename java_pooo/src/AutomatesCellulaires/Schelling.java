import java.util.*;

public class Schelling extends Jeux {

    protected int K; //threshold;
    protected int nb_free_cell;
    Queue<Cellule> free_cell;

    protected Schelling(int nb_couleurs, int K) {
        super(nb_couleurs);
        if(K>=1 && K<=8){
            this.K = K;
        }else{
            throw new IllegalArgumentException("La valeur de K doit être comprise entre 1 et 8");
        }
        this.nb_free_cell = 0;
        this.free_cell = new LinkedList<Cellule>();

        for (int j = Y; j >=1; j--) {
            for (int i = X; i>=1; i--) {
                if (this.initial_state[j][i].cell_state==0) {
                    this.free_cell.add(new Cellule(this.initial_state[j][i]));
                    this.nb_free_cell++;
                }
            }
        }
    }

    public boolean if_need_to_move(int y, int x) {
        int result = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int neighborY = (y + i + Y)%Y +1;
                int neighborX = (x + j + X)%X +1;
                if ((this.save_state[neighborY][neighborX].cell_state!=0) &&
                (this.save_state[neighborY][neighborX].cell_state != this.save_state[y][x].cell_state)) {
                    result++;
                }
            }
        }
        return (result>this.K);
    }

    @Override
    public void update() {
        int all_consumed = this.nb_free_cell;
        for (int j = Y; j >=1; j--) {
            for (int i = X; i>=1; i--) {
                if (all_consumed > 0 && this.save_state[j][i].cell_state!=0 && if_need_to_move(j, i)) {
                        Cellule will_be_colored = this.free_cell.remove();
                        this.current_state[will_be_colored.y][will_be_colored.x].cell_state = this.save_state[j][i].cell_state;
                        this.current_state[j][i].cell_state = 0;
                        Cellule will_be_free = new Cellule(this.current_state[j][i]);
                        this.free_cell.add(will_be_free);
                        all_consumed--;
                }
            }
        }
        //now we save the current state
        this.save();            
    }
        
    @Override
    public void reInit() {
        this.free_cell.clear();
        for (int j = this.Y; j >=1; j--) {
            for (int i = this.Y; i>=1; i--) {
                this.current_state[j][i].cell_state = this.initial_state[j][i].cell_state;
                this.save_state[j][i].cell_state = this.initial_state[j][i].cell_state;
                if (current_state[j][i].cell_state==0) {
                    this.free_cell.add(new Cellule(this.initial_state[j][i]));
                }
            }
        }
    }
}