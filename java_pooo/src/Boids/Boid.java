package boids;
import java.awt.Color;

public abstract class Boid {
    protected Vector position;
    protected Vector velocity;
    protected int direction; //0: tanslation(+,+) | 1: tanslation(-,+) | 
                            //2: tanslation(-,-) | 3: tanslation(+,-) 
    protected Color color; 
    protected int distance_voisinage;
    protected int move_perc;
    protected int velo_rate;
    protected int size;

    public Boid(int x, int y, int vx, int vy, int direction) {
        this.direction = direction;
        this.position = new Vector(x, y);
        this.velocity = new Vector(vx, vy);
    }

    protected void updateVelocity(Vector v1, Vector v2, Vector v3){
        // Sum the velocities to get the updated velocity
        this.velocity.add(v1);
        this.velocity.add(v2);
        this.velocity.add(v3);
    }

    protected void updatePosition(Vector v1, Vector v2, Vector v3){
        updateVelocity(v1, v2, v3);
        this.position.add(this.velocity);
    }

    protected int distance(Boid b){
        return this.position.distance(b.position);
    }

    protected boolean is_voisin(Boid boid){
        if(this.getClass()==boid.getClass() && this != boid && (this.distance(boid)<this.distance_voisinage)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.position.toString();
    }
}
