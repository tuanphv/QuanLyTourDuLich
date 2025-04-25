package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Lớp tiện ích để xử lý và chuyển đổi định dạng ngày tháng sử dụng LocalDateTime
 */
public class FormatDate {

    // Định dạng mặc định
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /**
     * Chuyển LocalDate thành String theo định dạng mặc định
     * @param date Thời gian cần chuyển đổi
     * @return Chuỗi ngày tháng hoặc chuỗi rỗng nếu date là null
     */
    public static String toString(LocalDate date) {
        return toString(date, DEFAULT_PATTERN);
    }

    /**
     * Chuyển LocalDateTime thành String theo định dạng tùy chỉnh
     * @param dateTime Thời gian cần chuyển đổi
     * @param pattern Mẫu định dạng (VD: "dd/MM/yyyy", "yyyy-MM-dd HH:mm:ss")
     * @return Chuỗi ngày tháng hoặc chuỗi rỗng nếu dateTime là null
     */
    public static String toString(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return "";
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return dateTime.format(formatter);
        } catch (Exception e) {
            System.err.println("Lỗi khi chuyển LocalDateTime sang String: " + e.getMessage());
            return "";
        }
    }
    
    /**
     * Chuyển LocalDate thành String theo định dạng tùy chỉnh
     * @param date Ngày cần chuyển đổi
     * @param pattern Mẫu định dạng (VD: "dd/MM/yyyy", "yyyy-MM-dd")
     * @return Chuỗi ngày tháng hoặc chuỗi rỗng nếu date là null
     */
    public static String toString(LocalDate date, String pattern) {
        if (date == null) {
            return "";
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return date.format(formatter);
        } catch (Exception e) {
            System.err.println("Lỗi khi chuyển LocalDate sang String: " + e.getMessage());
            return "";
        }
    }

    /**
     * Chuyển String thành LocalDateTime theo định dạng mặc định
     * @param dateTimeStr Chuỗi ngày tháng cần chuyển đổi
     * @return LocalDateTime hoặc null nếu không thể chuyển đổi
     */
    public static LocalDateTime toDateTime(String dateTimeStr) {
        return toDateTime(dateTimeStr, DEFAULT_PATTERN);
    }

    /**
     * Chuyển String thành LocalDateTime theo định dạng tùy chỉnh
     * @param dateTimeStr Chuỗi ngày tháng cần chuyển đổi
     * @param pattern Mẫu định dạng (VD: "dd/MM/yyyy", "yyyy-MM-dd HH:mm:ss")
     * @return LocalDateTime hoặc null nếu không thể chuyển đổi
     */
    public static LocalDateTime toDateTime(String dateTimeStr, String pattern) {
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            
            // Nếu pattern chỉ có phần ngày, thêm phần thời gian 00:00
            if (!pattern.contains("H") && !pattern.contains("h")) {
                return LocalDate.parse(dateTimeStr, formatter).atStartOfDay();
            } else {
                return LocalDateTime.parse(dateTimeStr, formatter);
            }
        } catch (DateTimeParseException e) {
            System.err.println("Lỗi khi chuyển String sang LocalDateTime: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Chuyển String thành LocalDate theo định dạng mặc định
     * @param dateStr Chuỗi ngày cần chuyển đổi 
     * @return LocalDate hoặc null nếu không thể chuyển đổi
     */
    public static LocalDate toDate(String dateStr) {
        return toDate(dateStr, DEFAULT_PATTERN);
    }
    
    /**
     * Chuyển String thành LocalDate theo định dạng tùy chỉnh
     * @param dateStr Chuỗi ngày cần chuyển đổi
     * @param pattern Mẫu định dạng (VD: "dd/MM/yyyy", "yyyy-MM-dd")
     * @return LocalDate hoặc null nếu không thể chuyển đổi
     */
    public static LocalDate toDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Lỗi khi chuyển String sang LocalDate: " + e.getMessage());
            return null;
        }
    }

    /**
     * Cắt bỏ phần thời gian, chỉ giữ lại phần ngày
     * @param dateTime Thời gian cần xử lý
     * @return LocalDate chỉ chứa phần ngày
     */
    public static LocalDate getDateOnly(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toLocalDate();
    }

    /**
     * Đặt giờ, phút, giây cho một LocalDateTime
     * @param dateTime Thời gian gốc
     * @param hour Giờ (0-23)
     * @param minute Phút (0-59)
     * @param second Giây (0-59)
     * @return LocalDateTime mới với giờ, phút, giây đã được đặt
     */
    public static LocalDateTime setTime(LocalDateTime dateTime, int hour, int minute, int second) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.withHour(hour).withMinute(minute).withSecond(second).withNano(0);
    }
    
    /**
     * Đặt giờ, phút, giây cho một LocalDate
     * @param date Ngày gốc
     * @param hour Giờ (0-23)
     * @param minute Phút (0-59)
     * @param second Giây (0-59)
     * @return LocalDateTime với giờ, phút, giây đã được đặt
     */
    public static LocalDateTime setTime(LocalDate date, int hour, int minute, int second) {
        if (date == null) {
            return null;
        }
        return date.atTime(hour, minute, second);
    }

    /**
     * Lấy thời điểm bắt đầu của ngày (00:00:00)
     * @param dateTime Thời gian bất kỳ
     * @return LocalDateTime với thời gian 00:00:00
     */
    public static LocalDateTime startOfDay(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toLocalDate().atStartOfDay();
    }
    
    /**
     * Lấy thời điểm cuối ngày (23:59:59)
     * @param dateTime Thời gian bất kỳ
     * @return LocalDateTime với thời gian 23:59:59.999999999
     */
    public static LocalDateTime endOfDay(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }
    
    /**
     * Lấy ngày đầu tiên của tháng
     * @param dateTime Thời gian bất kỳ
     * @return LocalDateTime đầu tiên của tháng
     */
    public static LocalDateTime firstDayOfMonth(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.withDayOfMonth(1).toLocalDate().atStartOfDay();
    }
    
    /**
     * Lấy ngày cuối cùng của tháng
     * @param dateTime Thời gian bất kỳ
     * @return LocalDateTime cuối cùng của tháng
     */
    public static LocalDateTime lastDayOfMonth(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.toLocalDate().withDayOfMonth(
                dateTime.toLocalDate().lengthOfMonth()).atTime(LocalTime.MAX);
    }
    
    // Các phương thức tiện ích chuyển đổi giữa Date cũ và LocalDateTime
    
    /**
     * Chuyển Date thành LocalDateTime
     * @param date Date cần chuyển đổi
     * @return LocalDateTime tương ứng
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Chuyển Date thành LocalDateTime
     * @param date Date cần chuyển đổi
     * @return LocalDate tương ứng
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return dateToLocalDateTime(date).toLocalDate();
    }
    
    /**
     * Chuyển LocalDateTime thành Date
     * @param dateTime LocalDateTime cần chuyển đổi
     * @return Date tương ứng
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * Chuyển LocalDate thành Date
     * @param date LocalDate cần chuyển đổi
     * @return Date tương ứng (thời gian sẽ là 00:00:00)
     */
    public static Date localDateToDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
