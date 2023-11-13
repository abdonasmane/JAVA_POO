package boids;
import java.awt.Color;

public class Shark extends Boid {
    protected Shark(int x, int y, int vx, int vy, int direction){
        super(x, y, vx, vy, direction);
        this.distance_voisinage = 100;
        this.move_perc = 3;
        this.velo_rate = 6;
        this.color = Color.RED;
        this.size = 10;
    }
}
