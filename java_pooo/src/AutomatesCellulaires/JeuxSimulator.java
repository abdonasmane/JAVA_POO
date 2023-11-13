import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;

public abstract class JeuxSimulator implements Simulable {

    protected GUISimulator simulator;
    protected Jeux jeux;
    protected int square_size;

    protected Color[] Colors = {
                Color.WHITE, Color.BLUE, Color.RED, Color.GREEN,
                Color.BLACK,Color.YELLOW, Color.CYAN,
                Color.MAGENTA, Color.ORANGE, Color.PINK, Color.GRAY,
                Color.LIGHT_GRAY, Color.DARK_GRAY, Color.CYAN.darker(),
                Color.MAGENTA.darker()};

    protected int GridX = 500;
    protected int GridY = 500;

    protected JeuxSimulator(Jeux jeux) {
        this.simulator = new GUISimulator(GridY, GridX, Color.WHITE);
        this.jeux = jeux;
        this.square_size = (this.GridX/this.jeux.X);
    }

    @Override
    public void next() {
        this.simulator.reset();
        for (int j = 1; j <= this.jeux.Y; j++) {
            for (int i = 1; i <= this.jeux.X; i++) {
                this.simulator.addGraphicalElement(
                    new Rectangle(
                        i*this.square_size,
                        j*this.square_size,
                        Color.decode("#000000"), //Black
                        this.Colors[this.jeux.current_state[j][i].cell_state],
                        this.square_size
                    )
                );
            }
        }
        this.jeux.update();
    }

    @Override
    public void restart() {
        this.jeux.reInit();
        this.simulator.reset();
    }
}
