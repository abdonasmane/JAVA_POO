import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;


public class SchellingSimulator extends JeuxSimulator {

    protected SchellingSimulator() {
        super(new Schelling(4, 3));
    }

}