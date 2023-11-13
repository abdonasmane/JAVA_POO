package boids;
import java.awt.Color;

public class Sardine extends Boid {
    protected Sardine(int x, int y, int vx, int vy, int direction) {
        super(x, y, vx, vy, direction);
        this.distance_voisinage = 100;
        this.move_perc = 5;
        this.velo_rate = 8;
        this.color = Color.BLUE;
        this.size = 5;
    }
}
