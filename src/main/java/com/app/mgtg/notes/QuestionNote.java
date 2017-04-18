package com.app.mgtg.notes;

import com.app.mgtg.converter.RomanToDecimalConverter;
import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.Metal;
import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.app.mgtg.constants.Constants.UNKNOWN_ANSWER;

public class QuestionNote implements Note {
    private List<GalacticSymbol> galacticSymbols;
    private List<Metal> metals;
    private String line;
    private static final List<String> KEYWORDS = Arrays.asList("how", "many", "is", "much", "Credits", "?");

    public QuestionNote(String line, List<GalacticSymbol> galacticSymbols, List<Metal> metals) {
        this.galacticSymbols = galacticSymbols;
        this.metals = metals;
        this.line = line;
    }

    @Override
    public void process() {
        final RomanToDecimalConverter converter = new RomanToDecimalConverter();
        String[] tokens = line.split(" ");
        final String[] symbol = {""};
        final StringBuilder sb = new StringBuilder();
        if (line.startsWith("how many")) {
            Arrays.stream(tokens).forEach((token) -> {
                if (!KEYWORDS.contains(token)) {
                    Optional<GalacticSymbol> potentialSymbol = getGalacticSymbol(token);
                    potentialSymbol.ifPresent(gs -> {
                        symbol[0] += gs.getValue().toString();
                        sb.append(gs.getName()).append(" ");
                    });
                    if(!potentialSymbol.isPresent()) {
                        try {
                            int noOfUnits = converter.convert(symbol[0]);
                            sb.append(token).append(" is ");
                            Optional<Metal> metal = getMetalFor(token);
                            if(metal.isPresent()) {
                                sb.append(noOfUnits * metal.get().getValue()).append(" Credits");
                            } else {
                                System.out.println("Invalid metal found: " + token + "\n Exiting..");
                                System.exit(0);
                            }
                            System.out.println(sb.toString());
                        } catch (MerchantsGuideToGalaxyException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Exception occurred, exiting..");
                            System.exit(0);
                        }
                    }
                }
            });
        } else if (line.startsWith("how much is")) {
            Arrays.stream(tokens).forEach(token -> {
                if(!KEYWORDS.contains(token)) {
                    Optional<GalacticSymbol> potentialSymbol = getGalacticSymbol(token);
                    potentialSymbol.ifPresent(gs -> {
                        symbol[0] += gs.getValue().toString();
                        sb.append(gs.getName()).append(" ");
                    });
                }
            });
            try {
                sb.append("is ").append(converter.convert(symbol[0]));
                System.out.println(sb.toString());
            } catch (MerchantsGuideToGalaxyException e) {
                System.out.println(e.getMessage());
                System.out.println("Exception occurred, exiting..");
                System.exit(0);
            }

        } else {
            System.out.println(UNKNOWN_ANSWER);
        }
    }

    private Optional<GalacticSymbol> getGalacticSymbol(String token) {
        return galacticSymbols.stream().filter(symbol -> symbol.getName().equals(token)).findFirst();
    }

    private Optional<Metal> getMetalFor(String token) {
        return metals.stream().filter(metal -> metal.getName().equals(token)).findFirst();
    }
}
