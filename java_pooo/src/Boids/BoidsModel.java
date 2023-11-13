package boids;
import java.util.ArrayList;

    
public class BoidsModel {

    protected Boids boids;

    protected BoidsModel() {
        boids = new Boids();
        // Add some boids to the simulation
        boids.initializePositions();

    }

    protected void move() {
        for (Boid b : boids.boidsList) {
            Vector v1 = boids.rule1(b); // Apply Rule 1
            Vector v2 = boids.rule2(b); // Apply Rule 2
            Vector v3 = boids.rule3(b); // Apply Rule 3
            b.updatePosition(v1, v2, v3);
            if (b.position.y > 500) {
                b.position.y = 499;
                if (b.direction == 0) {
                    b.direction = 1;
                    b.velocity.x = Math.abs(b.velocity.x);
                    b.velocity.y = -Math.abs(b.velocity.y);
                } else {
                    b.direction = 2;
                    b.velocity.x = -Math.abs(b.velocity.x);
                    b.velocity.y = -Math.abs(b.velocity.y);
                }
            } else if (b.position.y < 0) {
                b.position.y = 1;
                if (b.direction == 1) {
                    b.direction = 0;
                    b.velocity.x = Math.abs(b.velocity.x);
                    b.velocity.y = Math.abs(b.velocity.y);
                } else {
                    b.direction = 3;
                    b.velocity.x = -Math.abs(b.velocity.x);
                    b.velocity.y = Math.abs(b.velocity.y);
                }
            }

            if (b.position.x > 500) {
                b.position.x = 499;
                if (b.direction == 0) {
                    b.direction = 3;
                    b.velocity.x = -Math.abs(b.velocity.x);
                    b.velocity.y = Math.abs(b.velocity.y);
                } else {
                    b.direction = 2;
                    b.velocity.x = -Math.abs(b.velocity.x);
                    b.velocity.y = -Math.abs(b.velocity.y);
                }
            } else if (b.position.x < 0) {
                b.position.x = 1;
                if (b.direction == 3) {
                    b.direction = 0;
                    b.velocity.x = Math.abs(b.velocity.x);
                    b.velocity.y = Math.abs(b.velocity.y);
                } else {
                    b.direction = 1;
                    b.velocity.x = Math.abs(b.velocity.x);
                    b.velocity.y = -Math.abs(b.velocity.y);
                }
            }
        }
    }




}
    

