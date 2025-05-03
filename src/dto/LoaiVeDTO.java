package dto;

public class LoaiVeDTO {

    private int maLoaiVe;
    private String tenLoaiVe;
    private String dieuKien;

    public LoaiVeDTO() {
    }

    public LoaiVeDTO(int maLoaiVe, String tenLoaiVe, String dieuKien) {
        this.maLoaiVe = maLoaiVe;
        this.tenLoaiVe = tenLoaiVe;
        this.dieuKien = dieuKien;
    }

    public int getMaLoaiVe() {
        return maLoaiVe;
    }

    public void setMaLoaiVe(int maLoaiVe) {
        this.maLoaiVe = maLoaiVe;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public static float getPhanTramGiamGia(int maLoaiVe) {
        switch (maLoaiVe) {
            case 1 -> {
                return (float) 0.5;
            }
            case 2 -> {
                return (float) 0.0;
            }
            default ->
                throw new AssertionError();
        }
    }

    public float getPhanTramGiamGia() {
        switch (maLoaiVe) {
            case 1 -> {
                return (float) 0.5;
            }
            case 2 -> {
                return (float) 0.0;
            }
            default ->
                throw new AssertionError();
        }
    }
}
