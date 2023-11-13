import gui.Simulable;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import java.awt.Color;


public class BallsSimulator implements Simulable {

    protected Balls balls;
    protected GUISimulator simulator;

    public BallsSimulator(int nb_points) {
        this.balls = new Balls(nb_points);
        this.simulator = new GUISimulator(this.balls.X, this.balls.Y, Color.WHITE);
    }

    public BallsSimulator() {
        //initialize with 10 random pts if nb_points not specified
        this.balls = new Balls(10);
        this.simulator = new GUISimulator(this.balls.X, this.balls.Y, Color.WHITE);
    }

    @Override
    public void next() {
        //for the next button
        this.simulator.reset();
        //Drawing boards
        this.simulator.addGraphicalElement(
            new Rectangle(
                0,
                0,
                Color.decode("#000000"),
                Color.decode("#000000"),
                3,
                this.balls.Y*2
            )
        );
        this.simulator.addGraphicalElement(
            new Rectangle(
                0,
                0,
                Color.decode("#000000"),
                Color.decode("#000000"),
                this.balls.X*2,
                3
            )
        );
        this.simulator.addGraphicalElement(
            new Rectangle(
                this.balls.X,
                0,
                Color.decode("#000000"),
                Color.decode("#000000"),
                3,
                this.balls.Y*2
            )
        );
        this.simulator.addGraphicalElement(
            new Rectangle(
                0,
                this.balls.Y,
                Color.decode("#000000"),
                Color.decode("#000000"),
                this.balls.X*2,
                3
            )
        );
        for (int i = 0; i < this.balls.nb_points; i++) {
            this.simulator.addGraphicalElement(
                new Oval(
                    this.balls.points[i].x,
                    this.balls.points[i].y,
                    Color.decode("#1f77b4"),
                    Color.decode("#1f77b4"),
                    10
                )
            );
        }
        this.balls.translate();
    }

    @Override
    public void restart() {
        this.balls.reInit();
        this.simulator.reset();
    }

}
