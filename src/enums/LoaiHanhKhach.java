
package enums;
public enum LoaiHanhKhach {
    NGUOI_LON("NguoiLon", "Người lớn"),
    TRE_EM("TreEm", "Trẻ em"),
    TRE_SO_SINH("TreSoSinh", "Trẻ sơ sinh");

    private final String value; // Lưu dưới dạng dữ liệu (số)
    private final String text; // Hiển thị trên giao diện (text)

    LoaiHanhKhach(String value, String text) {
        this.value = value;
        this.text = text;
    }

    // Getter cho value và text
    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    // Tìm kiếm giá trị từ String (dữ liệu)
    public static LoaiHanhKhach fromValue(String value) {
        for (LoaiHanhKhach lh : LoaiHanhKhach.values()) {
            if (lh.getValue() == null ? value == null : lh.getValue().equals(value)) {
                return lh;
            }
        }
        return null; // Hoặc ném exception nếu cần
    }

    // Tìm kiếm giá trị từ String (text)
    public static LoaiHanhKhach fromText(String text) {
        for (LoaiHanhKhach lh : LoaiHanhKhach.values()) {
            if (lh.getText().equalsIgnoreCase(text)) {
                return lh;
            }
        }
        return null; // Hoặc ném exception nếu cần
    }

    @Override
    public String toString() {
        return this.getText();
    }
}

