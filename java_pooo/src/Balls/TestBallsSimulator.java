import java.awt.Color;

public class TestBallsSimulator {
    public static void main(String[] args) {
        BallsSimulator ballsSimul = new BallsSimulator();
        ballsSimul.simulator.setSimulable(ballsSimul) ;
    }
}
