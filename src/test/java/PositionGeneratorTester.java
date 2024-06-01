package test.java;
import java.util.ArrayList;
import main.java.PositionGenerator;

public class PositionGeneratorTester {
    private static final int LENGTH_LETTER_SET = 7, MAP_ROWS = 7;
    private PositionGenerator positionGenerator = new PositionGenerator();
    
    public static void main(String[] args){
        PositionGeneratorTester pgt = new PositionGeneratorTester();
        System.out.println(pgt.generatePositionTester()); 
        System.out.println(pgt.converToLetterTest());
        System.out.println(pgt.validPositionTest());
        System.out.println(pgt.generatePostionArrayTest());
        System.out.println(pgt.generateIncrementValueTest());

    } 
    
    public String generatePositionTester() {
        String testResult = "passed";
        ArrayList<String> geneartionResult = positionGenerator.generatePostion(8);
        if (geneartionResult != null)
             testResult = "failed";
        geneartionResult = positionGenerator.generatePostion(0);
        if (geneartionResult != null)
             testResult = "failed";
        geneartionResult = positionGenerator.generatePostion(-1);
        if (geneartionResult != null)
             testResult = "failed";
        return testResult;
    } 
    public String placingStartupTest() {
        String testResult = "passed";
        PositionGenerator positionGenerator = new PositionGenerator(); 
        for (int i = 0; i < MAP_ROWS; i++) {
           ArrayList<String> positions = positionGenerator.generatePostion(MAP_ROWS); 
           if (i == 0 && positions == null)
              testResult = "failed"; 
        }  
        ArrayList<String> positions = positionGenerator.generatePostion(MAP_ROWS);
        if (positions != null)
            testResult = "faield";
        return testResult;
    }
    public String converToLetterTest() {
        String testResult = "passed";
        for (int i = 0; i < LENGTH_LETTER_SET; i++) {
            char resultLetter = positionGenerator.converToLetter(i);
            if (resultLetter != 'A' + i)
                testResult = "failed";
        } 
        return testResult;
    }
    public String validPositionTest() {
        String testResult = "passed";
        ArrayList<String> positions = positionGenerator.generatePostion(3);
        for (String position : positions) {
            if (positionGenerator.validPosition(position))
               testResult = "failed";
        } 
        if (!positionGenerator.validPosition("test_value"))
            testResult = "faield";
        return testResult;
    }
    public String generatePostionArrayTest() {
        String testResult = "passed";
        ArrayList<String> positions = positionGenerator.generatePostionArray(0,0, 3, 'h', 1);
        if (!positions.get(0).equals("A1") || !positions.get(1).equals("B1") || !positions.get(2).equals("C1"))
            testResult = "failed";
        positions = positionGenerator.generatePostionArray(6, 6, 2, 'h', -1);
        if (!positions.get(0).equals("G7") || !positions.get(1).equals("F7"))
            testResult = "failed";
        positions = positionGenerator.generatePostionArray(0, 0, 4, 'v', 1);
        if (!positions.get(0).equals("A1") || !positions.get(1).equals("A2") || !positions.get(2).equals("A3") || !positions.get(3).equals("A4"))
            testResult = "failed";
        positions = positionGenerator.generatePostionArray(1, 6, 3, 'v', -1);
        if (!positions.get(0).equals("B7") || !positions.get(1).equals("B6") || !positions.get(2).equals("B5"))
            testResult = "failed";
        return testResult;
    }
    public String generateIncrementValueTest() {
        String testResult = "passed"; 
        if (-1 != positionGenerator.generateIncrementValue(3, 4))
            testResult = "failed";
        if (0 == positionGenerator.generateIncrementValue(1, 2))
            testResult = "faield";
        if (1 != positionGenerator.generateIncrementValue(1, 5))
            testResult = "failed";
        return testResult; 
    }
}
    

