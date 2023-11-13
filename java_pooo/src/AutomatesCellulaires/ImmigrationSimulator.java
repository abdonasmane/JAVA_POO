import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;


public class ImmigrationSimulator extends JeuxSimulator {

    protected ImmigrationSimulator() {
        super(new Immigration(4));
    }

}