
import java.util.Arrays;

public class ChuyenBay {
    private String maChuyenBay;
    private String sanBayDi;
    private String sanBayDen;
    private String ngayBay;
    private int gioBay;
    private int soGheEconomy;
    private int soGheBusiness;
    private int soGheFirst;
    private Ghe[] danhSachGhe;
    private char trangThai;
    private Ticket[] danhSachVe;
    private double khoangCachBay;
    private int tongSoGhe;
    private int soGheDaDat;

    public ChuyenBay(String maChuyenBay, String sanBayDi, String sanBayDen, String ngayBay, int gioBay, double khoangCachBay) {
        this.maChuyenBay = maChuyenBay;
        this.sanBayDi = sanBayDi;
        this.sanBayDen = sanBayDen;
        this.ngayBay = ngayBay;
        this.gioBay = gioBay;
        this.khoangCachBay = khoangCachBay;
        this.soGheEconomy = 120; // 20 dãy x 6 ghế
        this.soGheBusiness = 40; // 10 dãy x 4 ghế
        this.soGheFirst = 10; // 5 dãy x 2 ghế
        this.danhSachGhe = new Ghe[soGheEconomy + soGheBusiness + soGheFirst];
        this.trangThai = 'S'; // S - Scheduled
        this.danhSachVe = new Ticket[100]; // Giả sử tối đa 100 vé
    }

    // Getter và Setter
    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getSanBayDi() {
        return sanBayDi;
    }

    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public String getSanBayDen() {
        return sanBayDen;
    }

    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

    public String getNgayBay() {
        return ngayBay;
    }

    public void setNgayBay(String ngayBay) {
        this.ngayBay = ngayBay;
    }

    public int getGioBay() {
        return gioBay;
    }

    public void setGioBay(int gioBay) {
        this.gioBay = gioBay;
    }

    public int getSoGheEconomy() {
        return soGheEconomy;
    }

    public void setSoGheEconomy(int soGheEconomy) {
        this.soGheEconomy = soGheEconomy;
    }

    public int getSoGheBusiness() {
        return soGheBusiness;
    }

    public void setSoGheBusiness(int soGheBusiness) {
        this.soGheBusiness = soGheBusiness;
    }

    public int getSoGheFirst() {
        return soGheFirst;
    }

    public void setSoGheFirst(int soGheFirst) {
        this.soGheFirst = soGheFirst;
    }

    public Ghe[] getDanhSachGhe() {
        return danhSachGhe;
    }

    public void setDanhSachGhe(Ghe[] danhSachGhe) {
        this.danhSachGhe = danhSachGhe;
    }

    public char getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(char trangThai) {
        this.trangThai = trangThai;
    }

    public void setDanhSachVe(Ticket[] danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public int getTongSoGhe() {
        return tongSoGhe;
    }

    public int getSoGheDaDat() {
        return soGheDaDat;
    }

    public Ticket[] getDanhSachVe() {
        return danhSachVe;
    }

    public double getKhoangCachBay() {
        return khoangCachBay;
    }

    public void setKhoangCachBay(double khoangCachBay) {
        this.khoangCachBay = khoangCachBay;
    }

    public void datGhe(String maGhe) {
        if (kiemTraSoGheConTrong()) {
            soGheDaDat++;
            // Cập nhật trạng thái ghế
        } else {
            System.out.println("Không còn ghế trống để đặt.");
        }
    }

    public void huyGhe(String maGhe) {
        if (soGheDaDat > 0) {
            soGheDaDat--;
            // Cập nhật trạng thái ghế
        } else {
            System.out.println("Không có ghế nào đã đặt để hủy.");
        }
    }

    // Kiểm tra số ghế còn trống
    public boolean kiemTraSoGheConTrong() {
        return soGheDaDat < tongSoGhe;
    }

    public static ChuyenBay timChuyenBayTheoMa(ChuyenBay[] danhSach, String maChuyenBay) {
        for (ChuyenBay cb : danhSach) {
            if (cb != null && cb.getMaChuyenBay().equals(maChuyenBay)) {
                return cb;
            }
        }
        return null;
    }

    public static ChuyenBay[] timChuyenBayTheoNgay(ChuyenBay[] danhSach, String ngayBay) {
        ChuyenBay[] ketQua = new ChuyenBay[10]; // Giả sử tối đa 10 chuyến bay tìm được
        int index = 0;
        for (ChuyenBay cb : danhSach) {
            if (cb != null && cb.getNgayBay().equals(ngayBay)) {
                if (index < ketQua.length) {
                    ketQua[index++] = cb;
                }
            }
        }
        return Arrays.copyOf(ketQua, index);
    }

    public static ChuyenBay[] timChuyenBayTheoTuyenBay(ChuyenBay[] danhSach, String sanBayDi, String sanBayDen) {
        ChuyenBay[] ketQua = new ChuyenBay[10]; // Giả sử tối đa 10 chuyến bay tìm được
        int index = 0;
        for (ChuyenBay cb : danhSach) {
            if (cb != null && cb.getSanBayDi().equals(sanBayDi) && cb.getSanBayDen().equals(sanBayDen)) {
                if (index < ketQua.length) {
                    ketQua[index++] = cb;
                }
            }
        }
        return Arrays.copyOf(ketQua, index);
    }

    @Override
    public String toString() {
        return "ChuyenBay{" +
                "maChuyenBay='" + maChuyenBay + '\'' +
                ", sanBayDi='" + sanBayDi + '\'' +
                ", sanBayDen='" + sanBayDen + '\'' +
                ", ngayBay='" + ngayBay + '\'' +
                ", gioBay=" + gioBay +
                ", soGheEconomy=" + soGheEconomy +
                ", soGheBusiness=" + soGheBusiness +
                ", soGheFirst=" + soGheFirst +
                ", trangThai=" + trangThai +
                ", khoangCachBay=" + khoangCachBay +
                '}';
    }
}