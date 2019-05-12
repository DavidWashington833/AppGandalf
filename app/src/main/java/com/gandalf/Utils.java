package com.gandalf;

import java.text.DecimalFormat;

public class Utils {
    public static String formatPrice(String price) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(Double.parseDouble(price)).replace(".", ",");
    }
}
