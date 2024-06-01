package main.java;
import java.util.ArrayList;
import java.util.Random;

public class PositionGenerator {
    private static final String LETTER_SET = "ABCDEFG";
    private static final int DECREMENT = -1, INCREMENT = 1,  WIDTH = 7,  MAP_SIZE = 49, TRAIL_LIMIT = 200;
    private static final char HORIZONTAL = 'h', VERTICAL = 'v';

    private ArrayList<ArrayList<String>> startupPostions = new ArrayList<>();
    private int takenSlots = 0;
    private Random rand = new Random();

    public ArrayList<String> generatePostion(int startupSize) {
        if (startupSize < 1 || startupSize  > 7 || MAP_SIZE - takenSlots < startupSize)
            return null;
        ArrayList<String> currentPositions = placingStartup(startupSize);
        startupPostions.addLast(currentPositions);
        return currentPositions;
    }

    public ArrayList<String>  placingStartup(int startupSize) {
        ArrayList<String> positions= new ArrayList<>();
        int x = 0, y = 0, trailCounter = 0, incrementValue = 0;
        char plane;
        boolean validationResult = false;
        do {
            trailCounter++;
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
            plane =  rand.nextBoolean() ? HORIZONTAL : VERTICAL; 
            if (plane == HORIZONTAL)
                incrementValue = generateIncrementValue(x, startupSize);
            else
                incrementValue = generateIncrementValue(y, startupSize);
            positions = generatePostionArray(x, y, startupSize,  plane, incrementValue);
            for (String position : positions) {
                validationResult = validPosition(position);
                if (!validationResult)
                    break;
            }
        } while(trailCounter < TRAIL_LIMIT && !validationResult);
        if (trailCounter == TRAIL_LIMIT) {
            positions = null;
            System.out.println(trailCounter);
        } 
        return positions; 
   }

   public char converToLetter(int x) {
        return LETTER_SET.charAt(x);
   }

   public boolean validPosition(String positionToValid) {
        for (ArrayList<String> startup : startupPostions) {
            for (String position : startup) {
                if (position.equals(positionToValid))
                    return false;
            }
        }
        return true;
   }
   public ArrayList <String> generatePostionArray(int x, int y, int size, char plane, int i ){
      ArrayList<String> placment = new ArrayList<>();
      if (plane == HORIZONTAL){
        for (int j = 0; j < size; j++) { 
            placment.add(new StringBuilder().append(converToLetter(x)).append(y+1).toString());
            x += i;
        }
      }
      else {
        for (int j = 0; j < size; j++) {
            placment.add(new StringBuilder().append(converToLetter(x)).append(y+1).toString());
            y += i;
        }
      }
      return placment;
   }
   public int generateIncrementValue(int planeCordinate, int size) {
        if ( planeCordinate+1 - size >= 0 && planeCordinate+1 + size <= WIDTH)
            return rand.nextBoolean() ? INCREMENT : DECREMENT;
        if ( planeCordinate+1 + size <= WIDTH)
            return INCREMENT;
        if ( planeCordinate+1 - size >= 0)
            return DECREMENT; 
        return 0;
   }
   
}
