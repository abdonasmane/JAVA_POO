import java.awt.Point;
import java.util.Random;

public class Balls {

    protected int nb_points;
    protected Point[] points;
    protected Point[] points_initial;//initial state (helpful for the restart button)
    protected int[] points_direction;//0: tanslation(10,10) | 1: tanslation(-10,10) | 
                                    //2: tanslation(-10,-10) | 3: tanslation(10,-10) 

    protected int X = 500;// Grid parameters
    protected int Y = 500;
    protected int x_translate = 10;//translation parameters
    protected int y_translate = 10;

    public Balls(int nb_points) {
        Random random = new Random();// To generate points randomly
        this.nb_points = nb_points;
        this.points = new Point[nb_points];
        this.points_initial = new Point[nb_points];
        this.points_direction = new int[nb_points];
        for (int i = 0; i < nb_points; i++) {
            this.points_initial[i] = new Point(random.nextInt(X + 1),random.nextInt(Y + 1));
            this.points[i] = new Point(this.points_initial[i]); // To save the initial state
            this.points_direction[i] = 0; // In the beginning, all points will move in the same direction
        }
    }

    public void translate(int dx, int dy) {
        //Translating all points by (dx,dy)
        for (int i = 0; i < this.nb_points; i++) {
            this.points[i].translate(dx, dy);
        }
    }

    public void translate() {
        //Translating all points by (x_translate,y_translate)
        //and handling rebounds
        for (int i = 0; i < this.nb_points; i++) {
            int ancien_mvt = this.points_direction[i];
            if (ancien_mvt==0) { this.points[i].translate(x_translate, y_translate);
            } else if (ancien_mvt==1) {this.points[i].translate(x_translate, -y_translate);
            } else if (ancien_mvt==2) {this.points[i].translate(-x_translate, -y_translate);
            } else {this.points[i].translate(-x_translate, y_translate);}


            if (this.points[i].y > Y) {
                this.points[i].y = Y-1;
                if (ancien_mvt == 0) {
                    this.points_direction[i] = 1;
                } else {
                    this.points_direction[i] = 2;
                }
            } else if (this.points[i].y < 0) {
                this.points[i].y = 1;
                if (ancien_mvt == 1) {
                    this.points_direction[i] = 0;
                } else {
                    this.points_direction[i] = 3;
                }
            }

            if (this.points[i].x > X) {
                this.points[i].x = X-1;
                if (ancien_mvt == 0) {
                    this.points_direction[i] = 3;
                } else {
                    this.points_direction[i] = 2;
                }
            } else if (this.points[i].x < 0) {
                this.points[i].x = 1;
                if (ancien_mvt == 3) {
                    this.points_direction[i] = 0;
                } else {
                    this.points_direction[i] = 1;
                }
            }

        }
    }

    public void reInit() {
        //For the restart button
        for (int i = 0; i < this.nb_points; i++) {
            this.points[i] = new Point(this.points_initial[i]);
            this.points_direction[i] = 0;
        }
    }

    @Override
    public String toString() {
        String s  = new String("");
        for (int i = 0; i < this.nb_points; i++) {
            s += this.points[i].toString()+"\n";
        }
        return s;
    }
}
