package com.app.mgtg.main;

import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.Metal;
import com.app.mgtg.notes.factory.NotesFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MerchantsGuideToGalaxy {

    public static void main(String[] args) {
        List<GalacticSymbol> galacticSymbols = new ArrayList<>();
        List<Metal> metals = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the input file:");
        String inputFilePath = scanner.nextLine();
        try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {

            stream.forEach(line -> NotesFactory.getNote(line, galacticSymbols, metals).process());

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage() + "\nExiting..");
            System.exit(0);
        }
    }
}
