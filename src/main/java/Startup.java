package main.java;

import java.util.ArrayList;

public class Startup {
     private String name = "default";
     private ArrayList<String> positions = new ArrayList<>();

     public String check(String userPosition) {
        String hitResult = "missed";
        int index = positions.indexOf(userPosition);
        if (index >= 0) {
            positions.remove(index);
            if (positions.isEmpty()) { 
                hitResult = "hit and sank";
                System.out.println("You have hit and sank " +  name);
            }
            else
                hitResult = "hit";
        }
        return hitResult;
     }
     public ArrayList<String> getPosition() {
        return positions;
     }
     public void setPosition(ArrayList<String>  positions) {
        if (positions != null)
             this.positions = positions;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
        if (name != null && !(name.equals(""))) {
            this.name = name;
        }
     }

}

