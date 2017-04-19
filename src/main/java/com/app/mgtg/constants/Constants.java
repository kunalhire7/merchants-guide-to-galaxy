package com.app.mgtg.constants;

import java.util.Arrays;
import java.util.List;

public final class Constants {
    public static final String[] VALID_SYMBOLS = {"I", "V", "X", "L", "C", "D", "M"};
    public static final String[] REPEATABLE_SYMBOLS = {"I", "X", "C", "M"};
    public static final String[] NON_REPEATABLE_SYMBOLS = {"D", "L", "V"};

    public static final int MAX_ALLOWED_REPETITIONS = 3;

    public static final String UNKNOWN_ANSWER = "I have no idea what you are talking about";

    public static final List<String> KEYWORDS = Arrays.asList("how", "many", "is", "much", "Credits", "?");
}
