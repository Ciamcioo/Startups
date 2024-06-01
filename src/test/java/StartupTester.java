package test.java;
import java.util.ArrayList;
import main.java.*;

public class StartupTester {
    Startup startup = new Startup();
    public static void main(String[] args) {
         StartupTester stt = new StartupTester();
         System.out.println(stt.setPositionTest());
         System.out.println(stt.setNameTest());
         System.out.println(stt.checkTest());
    }
    public String setPositionTest() {
        String testResult = "passed" ;
        PositionGenerator positionGenerator = new PositionGenerator();
        ArrayList<String> positions =  positionGenerator.generatePostion(3); 
        startup.setPosition(positions);
        ArrayList<String> setPositions = startup.getPosition(); 
        for (int i = 0; i < positions.size(); i++) 
            if (!positions.get(i).equals(setPositions.get(i)))
                testResult = "failed";
        positions = null;
        startup.setPosition(positions);
        if (positions == startup.getPosition())
            testResult = "failed";
        return testResult; 
    }

    public String setNameTest() {
        String testResult = "passed";
        String name = "Something";
        startup.setName(name);
        String checkName = startup.getName();
        if (!name.equals(checkName))
            testResult = "failed";
        startup.setName(null);
        if (!checkName.equals(startup.getName()))
            testResult = "failed"; 
        startup.setName("");
        if (startup.getName().equals(""))
            testResult = "failed";
        System.out.println(testResult);
        return testResult;
    }
    
    public String checkTest() {
        String testResult = "passed";
        ArrayList<String> positions = new ArrayList<>();
        positions.add("A1");
        positions.add("B1");
        positions.add("C1");
        startup.setPosition(positions);
        String checkResult = startup.check("D1");
        if (!checkResult.equals("missed"))
            testResult = "failed"; 
        checkResult = startup.check("B1");
        if (!checkResult.equals("hit"))
            testResult = "failed";
        checkResult = startup.check("B1");
        if (!checkResult.equals("missed"))
            testResult = "faield";
        checkResult = startup.check("A1");
        if (!checkResult.equals("hit"))
            testResult = "failed";
        checkResult = startup.check("C1");
        if (!checkResult.equals("hit and sank"))
            testResult = "failed";
        return testResult;

    }
}
