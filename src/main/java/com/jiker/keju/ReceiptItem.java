package com.jiker.keju;

import java.util.regex.Matcher;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;

public class ReceiptItem {
    private final String line;

    public ReceiptItem(String line) {
        this.line = line;
    }

    public Ride toRide() {
        Matcher matcher = compile("([0-9]+)公里,等待([0-9]+)分钟").matcher(line);
        if(matcher.matches()) {
            return new Ride(parseInt(matcher.group(1)), parseInt(matcher.group(2)));
        }
        throw new InvalidInput(line);
    }

    public String chargeLine() {
        return format("收费%d元", toRide().price());
    }
}
