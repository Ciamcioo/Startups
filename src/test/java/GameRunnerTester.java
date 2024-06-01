package test.java;

import java.util.ArrayList;

import main.java.*;

public class GameRunnerTester {
    private static final int startupsNumber = 3;
    private static final String neutralMsg = "Every single startups is sank!\nYour move counter: ", positiveMsg = "Wow! That's a good result\n", negativeMsg = "Well... Try harder!\n"; 
    private GameRunner gameRunner = new GameRunner();

    public static void main(String[] args) {
        GameRunnerTester grt = new GameRunnerTester();     
        grt.runTests();
    }
    
    public void runTests() {
        System.out.println(setUpGameTest());
        System.out.println(finishGameTest());
    }

   public String setUpGameTest() {
        String testResult = "passed";
        gameRunner.setUpGame();
        InputHandler inputHandler = gameRunner.getInputHandler();
        PositionGenerator positionGenerator = gameRunner.getPositionGenerator();
        if (!(positionGenerator instanceof PositionGenerator) || positionGenerator == null)
            testResult = "failed";
        if (!(inputHandler instanceof InputHandler) || inputHandler == null)
            testResult = "failed";
        ArrayList<Startup> startups = gameRunner.getStartups();
        if (startups.size() != GameRunnerTester.startupsNumber)      
            testResult = "failed";
        for (Startup startup : startups) {
           if (startup.getPosition().isEmpty() || startup.getName().equals(null))
               testResult = "failed";
        }
        return testResult;
   }

   public String finishGameTest() {
       String testResult = "passed";
       gameRunner.setMoveCounter(10); 
       String result = gameRunner.finishGame();
       if (!result.equals(neutralMsg + 10 + '\n' + positiveMsg)) 
           testResult = "failed"; 
      gameRunner.setMoveCounter(40); 
      result = gameRunner.finishGame();
      if (!result.equals(neutralMsg + 40 + '\n' + negativeMsg))
           testResult = "failed";
      return testResult;
   }


    
}
