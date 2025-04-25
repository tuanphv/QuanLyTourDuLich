package enums;

public enum TinhTrangTour {
    DANG_MO("Đang mở"),
    TAM_DUNG("Tạm dừng"),
    DA_DONG("Đã đóng"),
    HUY("Đã huỷ");

    private final String moTa;

    TinhTrangTour(String moTa) {
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public static TinhTrangTour fromMoTa(String moTa) {
        for (TinhTrangTour t : values()) {
            if (t.moTa.equalsIgnoreCase(moTa.trim())) {
                return t;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái: " + moTa);
    }

    @Override
    public String toString() {
        return moTa;
    }
}
