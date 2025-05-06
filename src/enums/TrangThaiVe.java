
package enums;

public enum TrangThaiVe {
    DA_PHAT_HANH("DaPhatHanh", "Đã phát hành"),
    SU_DUNG("SuDung", "Sử dụng"),
    DA_HUY("DaHuy", "Đã hủy");
    
    private final String value;
    private final String moTa;
    
    TrangThaiVe(String value, String moTa) {
        this.value = value;
        this.moTa = moTa;
    }
    
    public String getValue() {
        return value;
    }

    public String getMoTa() {
        return moTa;
    }

    public static TrangThaiVe fromValue(String value) {
        for (TrangThaiVe t : TrangThaiVe.values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Giá trị trạng thái không hợp lệ: " + value);
    }

    public static TrangThaiVe fromText(String text) {
        for (TrangThaiVe t : TrangThaiVe.values()) {
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
