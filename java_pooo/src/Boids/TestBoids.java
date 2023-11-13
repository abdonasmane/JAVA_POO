package boids;
import gui.GUISimulator;
import java.awt.Color;

public class TestBoids {
    public static void main(String[] args) {
            // crée la fenêtre graphique dans laquelle dessiner
        GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);   
        BoidsSimulator bSimulator = new BoidsSimulator(gui);
    }
}
