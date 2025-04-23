package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Lớp tiện ích đơn giản để chuyển đổi giữa Date và String
 */
public class FormatDate {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /**
     * Chuyển Date thành String với định dạng mặc định yyyy-MM-dd
     * 
     * @param date Ngày cần chuyển đổi
     * @return Chuỗi ngày tháng hoặc chuỗi rỗng nếu date là null
     */
    public static String toString(Date date) {
        return toString(date, DEFAULT_PATTERN);
    }

    /**
     * Chuyển Date thành String với định dạng tùy chọn
     * 
     * @param date    Ngày cần chuyển đổi
     * @param pattern Mẫu định dạng (VD: "dd/MM/yyyy", "yyyy-MM-dd", "HH:mm:ss")
     * @return Chuỗi ngày tháng hoặc chuỗi rỗng nếu date là null
     */
    public static String toString(Date date, String pattern) {
        if (date == null) {
            return "";
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Chuyển String thành Date với định dạng mặc định yyyy-MM-dd
     * 
     * @param dateStr Chuỗi ngày tháng cần chuyển đổi
     * @return Đối tượng Date hoặc null nếu không thể chuyển đổi
     */
    public static Date toDate(String dateStr) {
        return toDate(dateStr, DEFAULT_PATTERN);
    }

    /**
     * Chuyển String thành Date với định dạng tùy chọn
     * 
     * @param dateStr Chuỗi ngày tháng cần chuyển đổi
     * @param pattern Mẫu định dạng (VD: "dd/MM/yyyy", "yyyy-MM-dd", "HH:mm:ss")
     * @return Đối tượng Date hoặc null nếu không thể chuyển đổi
     */
    public static Date toDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Định dạng lại Date thành một Date khác với các thành phần thời gian đã được
     * điều chỉnh
     * Phương thức này giúp loại bỏ các thành phần thời gian không mong muốn
     * 
     * @param date Ngày gốc cần chuyển đổi
     * @return Date mới chỉ giữ lại phần ngày (không có giờ, phút, giây)
     */
    public static Date format(Date date) {
        // Mặc định sẽ chỉ giữ lại phần ngày, bỏ giờ phút giây
        return format(date, DEFAULT_PATTERN);
    }

    /**
     * Định dạng lại Date thành một Date khác với các thành phần thời gian
     * được xác định bởi pattern
     * 
     * @param date    Ngày gốc cần chuyển đổi
     * @param pattern Mẫu định dạng để xác định thành phần cần giữ lại
     * @return Date mới với các thành phần thời gian đã được điều chỉnh
     */
    public static Date format(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        try {
            String dateStr = toString(date, pattern);
            return toDate(dateStr, pattern);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
