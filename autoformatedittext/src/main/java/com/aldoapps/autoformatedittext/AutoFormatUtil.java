package com.aldoapps.autoformatedittext;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by aldo on 21/08/16.
 */
public class AutoFormatUtil {

    private static final String FORMAT_NO_DECIMAL = "###,###";

    private static final String FORMAT_WITH_DECIMAL = "###,###.###";

    private static int getCharOccurrence(String input, char c) {
        int occurrence = 0;
        char[] chars = input.toCharArray();
        for (char thisChar : chars) {
            if (thisChar == c) {
                occurrence++;
            }
        }
        return occurrence;
    }

    public static int getCommaOccurrence(String input) {
        return getCharOccurrence(input, ',');
    }

    public static String extractDigits(String input) {
        return input.replaceAll("\\D+", "");
    }

    private static String formatToStringWithoutDecimal(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        NumberFormat formatter = new DecimalFormat(FORMAT_NO_DECIMAL, symbols);
        return formatter.format(value);
    }

    static String formatToStringWithoutDecimal(String value) {
        return formatToStringWithoutDecimal(Double.parseDouble(value));
    }

    static String formatWithDecimal(String price) {
        return formatWithDecimal(Double.parseDouble(price));
    }

    private static String formatWithDecimal(double price) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        NumberFormat formatter = new DecimalFormat(FORMAT_WITH_DECIMAL, symbols);
        return formatter.format(price);
    }
}
