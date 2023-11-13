import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;


public class ConwaySimulator extends JeuxSimulator {

    protected ConwaySimulator() {
        super(new Conway());
    }

}