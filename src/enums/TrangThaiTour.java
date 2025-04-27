package enums;

import java.util.Arrays;

public enum TrangThaiTour {
    DANG_MO("Đang mở"),
    TAM_DUNG("Tạm dừng"),
    DA_DONG("Đã đóng"),
    HUY("Đã huỷ"),
    DA_XOA("Đã xóa");

    private final String moTa;

    TrangThaiTour(String moTa) {
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public static TrangThaiTour fromMoTa(String moTa) {
        for (TrangThaiTour t : values()) {
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

    public static TrangThaiTour[] getTrangThaiTours() {
        return Arrays.stream(values())
                .filter(tt -> tt != DA_XOA)
                .toArray(TrangThaiTour[]::new);
    }
}
