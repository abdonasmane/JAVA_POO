package boids;
import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import java.awt.Color;


public  class BoidsSimulator implements Simulable{
    BoidsModel boidsModel;
    protected GUISimulator gui;

    public BoidsSimulator(GUISimulator gui){
        this.gui = gui;
        this.boidsModel = new BoidsModel();
        //associer au gui
        this.gui.setSimulable(this);
        restart();
    }
    public void next(){
        gui.reset();
        boidsModel.move();
        afficher();
    }

    public void restart(){
        gui.reset();

        boidsModel.boids.initializePositions();
        afficher();
    }
    public void afficher() {
        this.gui.addGraphicalElement(
            new Rectangle(
                0,
                0,
                Color.decode("#000000"),
                Color.decode("#000000"),
                3,
                500*2
            )
        );
        this.gui.addGraphicalElement(
            new Rectangle(
                0,
                0,
                Color.decode("#000000"),
                Color.decode("#000000"),
                500*2,
                3
            )
        );
        this.gui.addGraphicalElement(
            new Rectangle(
                500,
                0,
                Color.decode("#000000"),
                Color.decode("#000000"),
                3,
                500*2
            )
        );
        this.gui.addGraphicalElement(
            new Rectangle(
                0,
                500,
                Color.decode("#000000"),
                Color.decode("#000000"),
                500*2,
                3
            )
        );
        for (Boid b : boidsModel.boids.boidsList) {
            Color color = b.color;
            Rectangle boid = new Rectangle(b.position.x, b.position.y, color , color, b.size);
            this.gui.addGraphicalElement(boid);           
        }
    }
}
