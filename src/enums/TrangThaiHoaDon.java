
package enums;

public enum TrangThaiHoaDon {
    CHO_XAC_NHAN("ChoXacNhan", "Chờ xác nhận"),
    DA_THANH_TOAN("DaThanhToan", "Đã thanh toán"),
    HUY("Huy", "Hủy");
    
    private final String value;
    private final String moTa;
    
    TrangThaiHoaDon(String value, String moTa) {
        this.value = value;
        this.moTa = moTa;
    }
    
    public String getValue() {
        return value;
    }

    public String getMoTa() {
        return moTa;
    }

    public static TrangThaiHoaDon fromValue(String value) {
        for (TrangThaiHoaDon t : TrangThaiHoaDon.values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Giá trị trạng thái không hợp lệ: " + value);
    }

    public static TrangThaiHoaDon fromText(String text) {
        for (TrangThaiHoaDon t : TrangThaiHoaDon.values()) {
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
