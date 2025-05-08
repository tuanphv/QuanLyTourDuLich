package utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {
    public static String formatCurrency(float amount) {
        return new DecimalFormat("#,###").format(amount);
    }
    
    /**
     * Trích xuất tất cả các số nguyên từ chuỗi đầu vào.
     * 
     * @param input Chuỗi có thể chứa ký tự và số lẫn lộn
     * @return Danh sách các số nguyên tìm được (theo thứ tự xuất hiện)
     */
    public static List<Integer> extractIntegers(String input) {
        List<Integer> numbers = new ArrayList<>();
        // Biểu thức: \d+ khớp với một hoặc nhiều chữ số
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);
        while (m.find()) {
            // m.group() là chuỗi các chữ số; parse về Integer
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
    }

    /**
     * Lấy số nguyên đầu tiên xuất hiện trong chuỗi.
     *
     * @param input Chuỗi có thể chứa ký tự và số lẫn lộn
     * @return Giá trị số (kiểu long) tìm được đầu tiên
     * @throws IllegalArgumentException nếu không tìm thấy bất kỳ chữ số nào
     */
    public static long getFirstNumber(String input) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);
        if (m.find()) {
            return Long.parseLong(m.group());
        } else {
            throw new IllegalArgumentException("Không tìm thấy số nào trong chuỗi: " + input);
        }
    }
}
