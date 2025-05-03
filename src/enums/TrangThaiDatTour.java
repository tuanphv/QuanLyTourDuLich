package enums;

public enum TrangThaiDatTour {
    CHO_THANH_TOAN("ChoThanhToan", "Chờ thanh toán"),
    DA_THANH_TOAN("DaThanhToan", "Đã thanh toán"),
    DA_HUY("DaHuy", "Đã hủy");

    private final String value;
    private final String moTa;

    TrangThaiDatTour(String value, String moTa) {
        this.value = value;
        this.moTa = moTa;
    }

    public String getValue() {
        return value;
    }

    public String getMoTa() {
        return moTa;
    }

    public static TrangThaiDatTour fromValue(String value) {
        for (TrangThaiDatTour t : TrangThaiDatTour.values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Giá trị trạng thái không hợp lệ: " + value);
    }

    public static TrangThaiDatTour fromText(String text) {
        for (TrangThaiDatTour t : TrangThaiDatTour.values()) {
            if (t.moTa.equalsIgnoreCase(text)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Mô tả trạng thái không hợp lệ: " + text);
    }

    @Override
    public String toString() {
        return getMoTa();
    }
    
}
