public class Immigration extends Jeux {

    protected Immigration(int nb_states) {
        super(nb_states);
    }


    @Override
    protected void update() {
        for (int j = Y; j >=1; j--) {
            for (int i = X; i>=1; i--) {
                if (neighbors_count(j, i, (this.current_state[j][i].cell_state+1)%this.nb_states) >= 3) this.current_state[j][i].cell_state = (this.current_state[j][i].cell_state+1)%this.nb_states;
            }
        }

        //now we save the current state
        this.save();
    }
}