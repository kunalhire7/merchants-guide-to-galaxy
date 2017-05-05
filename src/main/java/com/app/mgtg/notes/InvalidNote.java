package com.app.mgtg.notes;

import static com.app.mgtg.constants.Constants.UNKNOWN_ANSWER;

public class InvalidNote implements Note {
    @Override
    public void process(String note) {
        System.out.println(UNKNOWN_ANSWER);
    }
}
