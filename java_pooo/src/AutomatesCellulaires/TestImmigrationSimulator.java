import java.awt.Color;

public class TestImmigrationSimulator {
    public static void main(String[] args) {
        ImmigrationSimulator immigrationSimul = new ImmigrationSimulator();
        immigrationSimul.simulator.setSimulable(immigrationSimul) ;
    }
}
