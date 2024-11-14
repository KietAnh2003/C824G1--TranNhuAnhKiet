package thi.entity;

public class BenhAnThuong extends BenhAn {
    private double phi;

    public BenhAnThuong(int soThuTu, String maBenhAn, String ten, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, double phi) {
        super(soThuTu, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phi = phi;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    @Override
    public String toString() {
        return super.toString() + ", phi=" + phi + '}';
    }
}