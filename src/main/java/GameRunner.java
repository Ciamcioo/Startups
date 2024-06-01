package main.java;

import java.util.ArrayList;


public class GameRunner {
    private InputHandler inputHandler;
    private PositionGenerator positionGenerator;
    private ArrayList<Startup> startups = new ArrayList<>();
    private int moveCounter = 0;
    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.setUpGame();
        gameRunner.runGame();
    }
    
    /**
     * Method is seting up the game unites in case to work poperly
     */
    public void setUpGame() {
        inputHandler = new InputHandler();
        positionGenerator = new PositionGenerator();

        Startup firstStartup = new Startup();
        firstStartup.setName("First Startup");
        startups.add(firstStartup);
        
        Startup secondStartup = new Startup();
        secondStartup.setName("Second Stratup");
        startups.add(secondStartup);

        Startup thirdStartup = new Startup();
        thirdStartup.setName("Third Startup");
        startups.add(thirdStartup);

        System.out.println("Your goal is to sank every startup and make as little moves as possible.");
        System.out.println("Currently there are 3 startups on the 7x7 map.");
        System.out.println("Have fun!");
        
        for (Startup startup : startups) 
            startup.setPosition(positionGenerator.generatePostion(3));
        

    }

    public void runGame() {
        while(!startups.isEmpty()) {
            String userPosition = inputHandler.getInput("Your position: ");
            checkUserMove(userPosition.toUpperCase());
        }
        System.out.println(finishGame());
    }
    public boolean checkUserMove(String userPosition){
        boolean hitResult = false;
        Startup sankStartup = null;
        String userResult = "missed";

        moveCounter++;
        for (Startup startup : startups) {
            userResult = startup.check(userPosition);
            if (userResult.equals("hit")) {
                hitResult = true;
                break;
            }
            if (userResult.equals("hit and sank")) {
                hitResult = true;
                sankStartup = startup;
                break;
            }
        }
         
        if (sankStartup != null)
            startups.remove(sankStartup);
        System.out.println(userResult);
        return hitResult;
    } 

    public String finishGame() {
        String msgToUser = "Every single startups is sank!\nYour move counter: " + moveCounter + '\n';
        if (moveCounter < 20)
            msgToUser += "Wow! That's a good result\n"; 
        else
            msgToUser += "Well... Try harder!\n";;
        return msgToUser;
    }

    public ArrayList<Startup> getStartups() {
        return startups;
    }
    public InputHandler getInputHandler() {
        return inputHandler;
    }
    public PositionGenerator getPositionGenerator() {
        return positionGenerator;
    }
    public void setMoveCounter(int moveCounter) {
        if (moveCounter >= 0) {
            this.moveCounter = moveCounter;
        }
    }
}
