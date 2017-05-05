package com.app.mgtg.main;

import com.app.mgtg.domain.GalacticSymbols;
import com.app.mgtg.domain.Metals;
import com.app.mgtg.notes.factory.NotesFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class MerchantsGuideToGalaxy {

    public static void main(String[] args) {
        GalacticSymbols galacticSymbols = new GalacticSymbols();
        Metals metals = new Metals();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the input file:");
        String inputFilePath = scanner.nextLine();
        try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {

            stream.forEach(note -> NotesFactory.getNote(note, galacticSymbols, metals).process(note));

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage() + "\nExiting..");
            System.exit(0);
        }
    }
}
