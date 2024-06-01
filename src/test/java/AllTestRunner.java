package test.java;

public class AllTestRunner {
    public static void main(String[] args) {
        GameRunnerTester grt = new GameRunnerTester();     
        StartupTester stt = new StartupTester();
        PositionGeneratorTester pgt = new PositionGeneratorTester();
        grt.runTests();
        stt.runTests();
        pgt.runTests();
    }
}
