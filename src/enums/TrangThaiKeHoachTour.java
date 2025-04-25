package enums;

public enum TrangThaiKeHoachTour {
    DANG_MO("Đang mở"),
    SAP_KHOI_HANH("Sắp khởi hành"),
    DA_DAY("Đã đầy"),
    DA_KHOI_HANH("Đã khởi hành"),
    DA_KET_THUC("Đã kết thúc"),
    DA_HUY("Đã huỷ"),
    TAM_DUNG("Tạm dừng");

    private final String moTa;

    TrangThaiKeHoachTour(String moTa) {
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    @Override
    public String toString() {
        return moTa;
    }

    public static TrangThaiKeHoachTour fromMoTa(String moTa) {
        for (TrangThaiKeHoachTour trangThai : TrangThaiKeHoachTour.values()) {
            if (trangThai.getMoTa().equalsIgnoreCase(moTa.trim())) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái: " + moTa);
    }
}
