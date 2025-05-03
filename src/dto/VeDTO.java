
package dto;

public class VeDTO {
    private int maVe;
    private int loaiVe;
    private int maKHTour;
    private float giaVe;

    public VeDTO() {
    }

    public VeDTO(int maVe, int loaiVe, int maKHTour, float giaVe) {
        this.maVe = maVe;
        this.loaiVe = loaiVe;
        this.maKHTour = maKHTour;
        this.giaVe = giaVe;
    }
    
    public VeDTO(int loaiVe, int maKHTour, float giaVe) {
        this.loaiVe = loaiVe;
        this.maKHTour = maKHTour;
        this.giaVe = giaVe;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public int getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(int loaiVe) {
        this.loaiVe = loaiVe;
    }

    public int getMaKHTour() {
        return maKHTour;
    }

    public void setMaKHTour(int maKHTour) {
        this.maKHTour = maKHTour;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }
    
    
}
