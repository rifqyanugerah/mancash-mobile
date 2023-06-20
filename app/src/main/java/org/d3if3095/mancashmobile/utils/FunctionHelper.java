package org.d3if3095.mancashmobile.utils;

import java.text.DecimalFormat;

public class FunctionHelper {

    public static String rupiahFormat(int price) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return "Rp " + formatter.format(price).replaceAll(",", ".");
    }
}
