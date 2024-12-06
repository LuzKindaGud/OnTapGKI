
import java.util.Arrays;
import java.util.Comparator;

public class HangBay {
    private String id;
    private String tenHangBay;
    private ChuyenBay[] danhSachChuyenBay;
    private HanhKhach[] danhSachHanhKhach;
    private double[] bangGiaCoBan;

    public HangBay(String id, String tenHangBay) {
        this.id = id;
        this.tenHangBay = tenHangBay;
        this.danhSachChuyenBay = new ChuyenBay[10]; // Giả sử tối đa 10 chuyến bay
        this.danhSachHanhKhach = new HanhKhach[100]; // Giả sử tối đa 100 hành khách
    }

    // Getter và Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenHangBay() {
        return tenHangBay;
    }

    public void setTenHangBay(String tenHangBay) {
        this.tenHangBay = tenHangBay;
    }

    public ChuyenBay[] getDanhSachChuyenBay() {
        return danhSachChuyenBay;
    }

    public void setDanhSachChuyenBay(ChuyenBay[] danhSachChuyenBay) {
        this.danhSachChuyenBay = danhSachChuyenBay;
    }

    public HanhKhach[] getDanhSachHanhKhach() {
        return danhSachHanhKhach;
    }

    public void setDanhSachHanhKhach(HanhKhach[] danhSachHanhKhach) {
        this.danhSachHanhKhach = danhSachHanhKhach;
    }

    public double[] getBangGiaCoBan() {
        return bangGiaCoBan;
    }

    public void setBangGiaCoBan(double[] bangGiaCoBan) {
        this.bangGiaCoBan = bangGiaCoBan;
    }

    public void themChuyenBay(ChuyenBay chuyenBay) {
        for (int i = 0; i < danhSachChuyenBay.length; i++) {
            if (danhSachChuyenBay[i] == null) {
                danhSachChuyenBay[i] = chuyenBay;
                System.out.println("Thêm chuyến bay thành công.");
                return;
            }
        }
        System.out.println("Danh sách chuyến bay đã đầy.");
    }

    public void xoaChuyenBay(String maChuyenBay) {
        for (int i = 0; i < danhSachChuyenBay.length; i++) {
            if (danhSachChuyenBay[i] != null && danhSachChuyenBay[i].getMaChuyenBay().equals(maChuyenBay)) {
                danhSachChuyenBay[i] = null;
                System.out.println("Xóa chuyến bay thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chuyến bay để xóa.");
    }

    public ChuyenBay timChuyenBay(String maChuyenBay) {
        for (ChuyenBay chuyenBay : danhSachChuyenBay) {
            if (chuyenBay != null && chuyenBay.getMaChuyenBay().equals(maChuyenBay)) {
                return chuyenBay;
            }
        }
        return null; // Không tìm thấy chuyến bay
    }

    public void themHanhKhach(HanhKhach hanhKhach) {
        for (int i = 0; i < danhSachHanhKhach.length; i++) {
            if (danhSachHanhKhach[i] == null) {
                danhSachHanhKhach[i] = hanhKhach;
                System.out.println("Thêm hành khách thành công.");
                return;
            }
        }
        System.out.println("Danh sách hành khách đã đầy.");
    }

    public void xoaHanhKhach(String idHanhKhach) {
        for (int i = 0; i < danhSachHanhKhach.length; i++) {
            if (danhSachHanhKhach[i] != null && danhSachHanhKhach[i].getId().equals(idHanhKhach)) {
                danhSachHanhKhach[i] = null;
                System.out.println("Xóa hành khách thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hành khách để xóa.");
    }

    public HanhKhach timHanhKhach(String idHanhKhach) {
        for ( HanhKhach hanhKhach : danhSachHanhKhach) {
            if (hanhKhach != null && hanhKhach.getId().equals(idHanhKhach)) {
                return hanhKhach;
            }
        }
        return null; // Không tìm thấy hành khách
    }

    public double tinhTongDoanhThu() {
        double tongDoanhThu = 0;
        for (ChuyenBay chuyenBay : danhSachChuyenBay) {
            if (chuyenBay != null) {
                for (Ticket ticket : chuyenBay.getDanhSachVe()) {
                    if (ticket != null && ticket.getTrangThaiVe() == 'B') {
                        tongDoanhThu += ticket.getGiaVe();
                    }
                }
            }
        }
        return tongDoanhThu;
    }

    public void sapXepHanhKhachTheoDamBay() {
        Arrays.sort(danhSachHanhKhach, new Comparator<HanhKhach>() {
            @Override
            public int compare(HanhKhach h1, HanhKhach h2) {
                return Double.compare(h2.getSoDamBayTichLuy(), h1.getSoDamBayTichLuy()); // Giảm dần
            }
        });
    }

    public void sapXepHanhKhachTheoTen() {
        Arrays.sort(danhSachHanhKhach, new Comparator<HanhKhach>() {
            @Override
            public int compare(HanhKhach h1, HanhKhach h2) {
                return h1.getTenHanhKhach().compareTo(h2.getTenHanhKhach()); // Tăng dần
            }
        });
    }

    public ChuyenBay timChuyenBayTheoMa(String maChuyenBay) {
        for (ChuyenBay chuyenBay : danhSachChuyenBay) {
            if (chuyenBay != null && chuyenBay.getMaChuyenBay().equals(maChuyenBay)) {
                return chuyenBay;
            }
        }
        return null; // Không tìm thấy chuyến bay
    }

    public ChuyenBay[] timChuyenBayTheoNgayVaDiaDiem(String ngayBay, String sanBayDi, String sanBayDen) {
        ChuyenBay[] ketQua = new ChuyenBay[10]; // Giả sử tối đa 10 chuyến bay tìm được
        int index = 0;
        for (ChuyenBay chuyenBay : danhSachChuyenBay) {
            if (chuyenBay != null && chuyenBay.getNgayBay().equals(ngayBay) &&
                    chuyenBay.getSanBayDi().equals(sanBayDi) && chuyenBay.getSanBayDen().equals(sanBayDen)) {
                if (index < ketQua.length) {
                    ketQua[index++] = chuyenBay;
                }
            }
        }
        return Arrays.copyOf(ketQua, index); // Trả về danh sách chuyến bay tìm được
    }

    public static HangBay[] taoDuLieuMau() {
        HangBay[] hangBays = new HangBay[3];
        // Tạo dữ liệu mẫu cho các hãng bay và chuyến bay
        HangBay hangBay1 = new HangBay("VNG01", "BamBoo Airline");
        hangBay1.themChuyenBay(new ChuyenBay("CB001", "SGN", "HN", "2023-10-01", 1, 1723));
        hangBay1.themChuyenBay(new ChuyenBay("CB002", "SGN", "DN", "2023-10-02", 1, 958));
        hangBays[0] = hangBay1;

        HangBay hangBay2 = new HangBay("VNG02", "KhaBanh Airline");
        hangBay2.themChuyenBay(new ChuyenBay("CB003", "HN", "SGN", "2023-10-03", 1, 1723));
        hangBay2.themChuyenBay(new ChuyenBay("CB004", "DN", "SGN", "2023-10-04", 1, 958));
        hangBays[1] = hangBay2;

        HangBay hangBay3 = new HangBay("VNG03", "DangCap Airline");
        hangBay3.themChuyenBay(new ChuyenBay("CB005", "SGN", "PQC", "2023-10-05", 1, 395));
        hangBay3.themChuyenBay(new ChuyenBay("CB006", "HN", "PQC", "2023-10-06", 2, 2087));
        hangBays[2] = hangBay3;

        return hangBays;
    }

    @Override
    public String toString() {
        return "HangBay{" +
                "id='" + id + '\'' +
                ", tenHangBay='" + tenHangBay + '\'' +
                '}';
    }
}