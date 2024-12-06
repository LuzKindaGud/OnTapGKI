import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private String maVe;
    private String maChuyenBay;
    private String maGhe;
    private char hangGhe;
    private double giaVe;
    private char trangThaiVe;
    private HanhKhach hanhKhach;
    private String ngayDatVe;
    private ChuyenBay chuyenBay;
    private boolean isCanceled;

    public Ticket(String maVe, String maChuyenBay, String maGhe, char hangGhe, double giaVe, HanhKhach hanhKhach) {
        this.maVe = maVe;
        this.maChuyenBay = maChuyenBay;
        this.maGhe = maGhe;
        this.hangGhe = hangGhe;
        this.giaVe = giaVe;
        this.trangThaiVe = 'B'; // B - Booked
        this.hanhKhach = hanhKhach;
        this.ngayDatVe = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
    }

    // Getter và Setter

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public char getHangGhe() {
        return hangGhe;
    }

    public void setHangGhe(char hangGhe) {
        this.hangGhe = hangGhe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public char getTrangThaiVe() {
        return trangThaiVe;
    }

    public void setTrangThaiVe(char trangThaiVe) {
        this.trangThaiVe = trangThaiVe;
    }

    public HanhKhach getHanhKhach() {
        return hanhKhach;
    }

    public void setHanhKhach(HanhKhach hanhKhach) {
        this.hanhKhach = hanhKhach;
    }

    public String getNgayDatVe() {
        return ngayDatVe;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public void setChuyenBay(ChuyenBay chuyenBay) {
        this.chuyenBay = chuyenBay;
    }

    public HanhKhach getHangKhach() {
        return hanhKhach;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void cancel() {
        this.isCanceled = true;
    }

    public double tinhGiaVe(char hangGhe, char hangTheThanhVien) {
        double giaCoBan = 0;
        switch (hangGhe) {
            case 'Y':
                giaCoBan = 1000000;
                break;
            case 'B':
                giaCoBan = 3000000;
                break;
            case 'F':
                giaCoBan = 5000000;
                break;
        }

        // Kiểm tra xem có phải cuối tuần không
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String dayOfWeek = sdf.format(new Date());
        if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday")) {
            giaCoBan *= 1.1; // Phụ thu cuối tuần 10%
        }

        // Giảm giá theo hạng thẻ
        double giamGia = 0;
        switch (hangTheThanhVien) {
            case 'S':
                giamGia = 0.05; // 5%
                break;
            case 'G':
                giamGia = 0.10; // 10%
                break;
        }

        return giaCoBan * (1 - giamGia);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "maVe='" + maVe + '\'' +
                ", maChuyenBay='" + maChuyenBay + '\'' +
                ", maGhe='" + maGhe + '\'' +
                ", hangGhe=" + hangGhe +
                ", giaVe=" + giaVe +
                ", trangThaiVe=" + trangThaiVe +
                ", hanhKhach=" + hanhKhach +
                ", ngayDatVe='" + ngayDatVe + '\'' +
                '}';
    }
}