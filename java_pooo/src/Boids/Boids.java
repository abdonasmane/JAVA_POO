package boids;
import java.util.ArrayList;
import java.util.Random;

public class Boids {

    protected int minDistance = 20;
    protected ArrayList<Boid> boidsList;

    protected Boids() {
        this.boidsList = new ArrayList<>();
    }

    protected Boids(int min_distance) {
        this();
        this.minDistance = min_distance;
    }
    
    // Rule 1: Boids try to fly towards the perceived center of other boids
    public Vector rule1(Boid boid) {
        int nb_voisins = 0;
        Vector centre = new Vector();

        for (Boid b : this.boidsList) {
            if (boid.is_voisin(b)) {
                centre.add(b.position);
                nb_voisins++;
            }
        }

        if(nb_voisins!=0) {
            centre.div(nb_voisins);
            double movePercentage = boid.move_perc/100.0;
            return centre.sub(boid.position).mult(movePercentage);
        } else {
            return centre;
        }
    }

    public Vector rule2(Boid boid) {
        Vector res = new Vector();

        for (Boid b : this.boidsList) {
            if (boid.is_voisin(b)) {
                int distance = b.distance(boid);
                if (distance < this.minDistance) {
                    Vector help_me = new Vector(b.position.x - boid.position.x, b.position.y - boid.position.y);
                    res.sub(help_me);
                }
            }
        }
        return res;
    }

    // Rule 3: Boids try to match velocity with near boids
    public Vector rule3(Boid boid) {
        int nb_voisins = 0;
        Vector velo_moyenne = new Vector();

        for (Boid b : boidsList) {
            if (boid.is_voisin(b)) {
                velo_moyenne.add(b.velocity);
                nb_voisins++;
            }
        }
        if (nb_voisins!=0) {
            velo_moyenne.div(nb_voisins);           
            velo_moyenne.sub(boid.velocity);
            return velo_moyenne.div(boid.velo_rate);          
        }
        return velo_moyenne;
    }

    public void initializePositions() {
        boidsList.clear();
        Random random = new Random();
        // Populate the simulation with boids
        for (int i = 0; i < 15; i++) {
            boidsList.add(new Sardine(random.nextInt(500),random.nextInt(500),random.nextInt(5)+1,random.nextInt(5)+1, 1));
        }
        // Populate the simulation with boids
        for (int i = 0; i < 15; i++) {
            boidsList.add(new Shark(random.nextInt(500),random.nextInt(500),random.nextInt(2)+1,random.nextInt(2)+1, 1));
        }

    }

}
