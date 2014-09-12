package com.reddit.dailyprogrammer.hughwphamill.greyscale;

import java.io.IOException;
import java.util.*;

public class CommandMenu {
    private final SortedMap<Integer, Converter> converterMap;

    private List<String> yes = Arrays.asList("yes", "Yes", "YES", "y", "Y", "ye", "Ye", "YE", "sure", "ok");
    private List<String> no = Arrays.asList("no", "No", "NO", "n", "N", "NOPE", "exit", "Exit");

    public CommandMenu(SortedMap<Integer, Converter> converterMap) {
        this.converterMap = converterMap;
    }

    public boolean askForExit() {
        System.out.println("Do you want to process another image?\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (yes.contains(input)) {
            return false;
        } else if (no.contains(input)) {
            return true;
        } else {
            System.out.println("I couldn't understand.");
            return askForExit();
        }
    }

    public String getInputFile() {
        System.out.println("What image file would you like me to process?\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void outputError(IOException e) {
        System.out.println("File Error: " + e.getLocalizedMessage());
    }

    public Converter selectConversion() {
        System.out.println("What conversion method would you like to use?");
        for (Map.Entry<Integer, Converter> entry : converterMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().description());
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            if (!converterMap.containsKey(Integer.parseInt(input))) {
                System.out.println("That's not a choice I gave you.");
                return selectConversion();
            } else {
                return converterMap.get(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
            System.out.println("That's not a number!");
            return selectConversion();
        }
    }
}
