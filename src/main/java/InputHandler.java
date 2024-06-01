package main.java;

import java.util.Scanner;

public class InputHandler {
    public InputHandler() {}
    public String getInput(String msg) {
        System.out.print(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.next().toLowerCase();
    }
}
