import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class HanhKhach implements IHanhKhach {
    private String id;
    private String tenHanhKhach;
    private int namSinh;
    private String soHoChieu;
    private String idHangBay;
    private double soDamBayTichLuy;
    private char hangTheThanhVien;
    private Ticket[] danhSachVe = new Ticket[5];
    private String diaChi;
    private Date ngaySinh;
    private String maHanhKhach;

    public HanhKhach(String id, String tenHanhKhach, int namSinh, String soHoChieu, String idHangBay, char hangTheThanhVien, String diaChi) {
        this.id = id;
        this.tenHanhKhach = tenHanhKhach;
        this.namSinh = namSinh;
        this.soHoChieu = soHoChieu;
        this.idHangBay = idHangBay;
        this.hangTheThanhVien = hangTheThanhVien;
        this.diaChi = diaChi;
        this.soDamBayTichLuy = 0;
    }

    // Getter và Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoHoChieu() {
        return soHoChieu;
    }

    public void setSoHoChieu(String soHoChieu) {
        this.soHoChieu = soHoChieu;
    }

    public String getIdHangBay() {
        return idHangBay;
    }

    public void setIdHangBay(String idHangBay) {
        this.idHangBay = idHangBay;
    }

    public double getSoDamBayTichLuy() {
        return soDamBayTichLuy;
    }

    public void setSoDamBayTichLuy(double soDamBayTichLuy) {
        this.soDamBayTichLuy = soDamBayTichLuy;
    }

    public char getHangTheThanhVien() {
        return hangTheThanhVien;
    }

    public void setHangTheThanhVien(char hangTheThanhVien) {
        this.hangTheThanhVien = hangTheThanhVien;
    }

    public void setDanhSachVe(Ticket[] danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Ticket[] getDanhSachVe() {
        return danhSachVe;
    }

    @Override
    public void datVe(String maChuyenBay, char hangGhe) {
        // Logic để đặt vé
    }

    @Override
    public void huyVe(String maVe) {
        // Logic để hủy vé
    }

    @Override
    public void doiVe(String maVeCu, String maChuyenBayMoi) {
        // Logic để đổi vé
    }

    @Override
    public String kiemTraTrangThaiVe(String maVe) {
        for (Ticket ticket : danhSachVe) {
            if (ticket != null && ticket.getMaVe().equals(maVe)) {
                return "Trạng thái vé: " + ticket.getTrangThaiVe();
            }
        }
        return "Không tìm thấy vé.";
    }

    @Override
    public void tichLuyDamBay(double km) {
        this.soDamBayTichLuy += km;
    }

    // Kiểm tra tuổi hành khách
    public boolean kiemTraTuoi() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngaySinh);
        int tuoi = Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        return tuoi > 18;
    }

    // Kiểm tra trùng lịch bay
    public boolean kiemTraTrungLichBay(ChuyenBay chuyenBay) {
        for (Ticket ticket : danhSachVe) {
            if (ticket != null && ticket.getChuyenBay().getNgayBay().equals(chuyenBay.getNgayBay())) {
                return true; // Có lịch bay trùng
            }
        }
        return false; // Không có lịch bay trùng
    }

    public String getMaHanhKhach() {
        return maHanhKhach;
    }

//    public void themVe(Ticket ticket) {
//        danhSachVe.add(ticket);
//    }
//
//    public void xoaVe(Ticket ticket) {
//        danhSachVe.remove(ticket);
//    }
//
//    public boolean coVeDangDat() {
//        return !danhSachVe.isEmpty();
//    }

    public void capNhatThongTin(String tenHanhKhach, Date ngaySinh, char hangTheThanhVien) {
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.hangTheThanhVien = hangTheThanhVien;
    }

    // Tìm kiếm
    public static HanhKhach timHanhKhachTheoMa(List<HanhKhach> danhSach, String maHanhKhach) {
        for (HanhKhach h : danhSach) {
            if (h.getMaHanhKhach().equals(maHanhKhach)) {
                return h;
            }
        }
        return null;
    }

    public static List<HanhKhach> timHanhKhachTheoTen(List<HanhKhach> danhSach, String tenHanhKhach) {
        List<HanhKhach> ketQua = new ArrayList<>();
        for (HanhKhach h : danhSach) {
            if (h.getTenHanhKhach().toLowerCase().contains(tenHanhKhach.toLowerCase())) {
                ketQua.add(h);
            }
        }
        return ketQua;
    }

//    public static List<HanhKhach> timHanhKhachTheoHangThe(List<HanhKhach> danhSach, String hangThe) {
//        List<HanhKhach> ketQua = new ArrayList<>();
//        for (HanhKhach h : danhSach) {
//            if (h.hangTheThanhVien.equals(hangThe)) {
//                ketQua.add(h);
//            }
//        }
//        return ketQua;
//    }

    @Override
    public String toString() {
        return "HanhKhach{" +
                "id='" + id + '\'' +
                ", tenHanhKhach='" + tenHanhKhach + '\'' +
                ", namSinh=" + namSinh +
                ", soHoChieu='" + soHoChieu + '\'' +
                ", idHangBay='" + idHangBay + '\'' +
                ", soDamBayTichLuy=" + soDamBayTichLuy +
                ", hangTheThanhVien=" + hangTheThanhVien +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }


}