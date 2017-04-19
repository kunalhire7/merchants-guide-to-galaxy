package com.app.mgtg.util;

import static java.lang.Integer.parseInt;

public class MgtgUtility {

    public static boolean isNumeric(String token) {
        try {
            parseInt(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
