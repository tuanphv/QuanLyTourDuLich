package utils;

import java.text.DecimalFormat;
import java.text.Normalizer;

public class TextUtils {
    public static String formatCurrency(float amount) {
        return new DecimalFormat("#,###").format(amount);
    }
    
    public static String removeDiacritics(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("đ", "d")
                .replaceAll("Đ", "D");
    }
}
