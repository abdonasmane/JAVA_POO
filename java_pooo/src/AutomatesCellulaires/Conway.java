public class Conway extends Jeux {

    protected Conway() {
        super(2);
    }

    @Override
    protected void update() {
        for (int j = this.Y; j >=1; j--) {
            for (int i = this.X; i>=1; i--) {
                if (this.current_state[j][i].cell_state==0) {
                    if (neighbors_count(j, i, 1)==3) {
                        this.current_state[j][i].cell_state = 1;
                    }
                } else {
                    if (neighbors_count(j, i, 0)==2 || neighbors_count(j, i, 0)==3) {
                        this.current_state[j][i].cell_state = 0;
                    }
                }
            }
        }

        //now we save the current state
        this.save();
    }
}