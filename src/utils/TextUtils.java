package utils;

import java.text.DecimalFormat;

public class TextUtils {
    public static String formatCurrency(float amount) {
        return new DecimalFormat("#,###").format(amount);
    }
}
