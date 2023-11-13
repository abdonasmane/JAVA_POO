import java.awt.Color;

public class TestConwaySimulator {
    public static void main(String[] args) {
        ConwaySimulator conwaySimul = new ConwaySimulator();
        conwaySimul.simulator.setSimulable(conwaySimul);
    }
}