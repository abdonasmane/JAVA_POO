import java.awt.Color;

public class TestSchellingSimulator {
    public static void main(String[] args) {
        SchellingSimulator schellingSimul = new SchellingSimulator();
        schellingSimul.simulator.setSimulable(schellingSimul);
    }
}