import java.util.Random;


public abstract class Jeux {

    protected int nb_states; //Number of possible states
    protected Cellule[][] current_state; //All cells current states
    protected Cellule[][] initial_state; //To save the initial state for restart button
    protected Cellule[][] save_state; //Save state at the iteration T to determine state at T+1

    protected int X = 50; //Grid prameters
    protected int Y = 50;

    protected Jeux(int nb_states) {
        this.nb_states = nb_states;
        Random random = new Random();
        this.current_state = new Cellule[Y+1][X+1];
        this.save_state = new Cellule[Y+1][X+1];
        this.initial_state = new Cellule[Y+1][X+1];
        for (int j = Y; j >=0; j--) {
            for (int i = X; i>=0; i--) {
                this.initial_state[j][i] = new Cellule(random.nextInt(nb_states), i, j);
                this.current_state[j][i] = new Cellule(initial_state[j][i]);
                this.save_state[j][i] = new Cellule(initial_state[j][i]);
            }
        }
    }

    protected int neighbors_count(int y, int x, int state) {
        int result = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int neighborY = (y + i + Y)%Y + 1;
                int neighborX = (x + j + X)%X + 1;
                if (this.save_state[neighborY][neighborX].cell_state==state) result++;
            }
        }
        return result;
    }

    protected void save() {
        //saving the current state
        for (int j = Y; j >=1; j--) {
            for (int i = X; i>=1; i--) {
                this.save_state[j][i].cell_state = this.current_state[j][i].cell_state;
            }
        }
    }

    protected void reInit() {
        for (int j = this.Y; j >=1; j--) {
            for (int i = this.Y; i>=1; i--) {
                this.current_state[j][i].cell_state = this.initial_state[j][i].cell_state;
                this.save_state[j][i].cell_state = this.initial_state[j][i].cell_state;
            }
        }
    }

    protected abstract void update();
}