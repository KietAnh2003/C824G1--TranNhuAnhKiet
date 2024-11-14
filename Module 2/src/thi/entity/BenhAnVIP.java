package thi.entity;

public class BenhAnVIP extends BenhAn {
    private String loaiVip;

    public BenhAnVIP(int soThuTu, String maBenhAn, String ten, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String loaiVip) {
        super(soThuTu, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVip = loaiVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    @Override
    public String toString() {
        return super.toString() + ", loaiVip='" + loaiVip + '\'' + '}';
    }
}
