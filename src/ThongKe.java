import java.util.*;

public class ThongKe {
    private ChuyenBay[] danhSachChuyenBay;
    private HanhKhach[] danhSachHanhKhach;
    private Ticket[] ticket;

    public ThongKe(ChuyenBay[] danhSachChuyenBay) {
        this.danhSachChuyenBay = danhSachChuyenBay;
    }

    public int soVeDaBanTheoChuyenBay(String maChuyenBay) {
        int soVe = 0;
        for (ChuyenBay chuyenBay : danhSachChuyenBay) {
            if (chuyenBay != null && chuyenBay.getMaChuyenBay().equals(maChuyenBay)) {
                for (Ticket ticket : chuyenBay.getDanhSachVe()) {
                    if (ticket != null && ticket.getTrangThaiVe() == 'B') {
                        soVe++;
                    }
                }
            }
        }
        return soVe;
    }

    public double doanhThuTheoChuyenBay(String maChuyenBay) {
        double doanhThu = 0;
        for (ChuyenBay chuyenBay : danhSachChuyenBay) {
            if (chuyenBay != null && chuyenBay.getMaChuyenBay().equals(maChuyenBay)) {
                for (Ticket ticket : chuyenBay.getDanhSachVe()) {
                    if (ticket != null && ticket.getTrangThaiVe() == 'B') {
                        doanhThu += ticket.getGiaVe();
                    }
                }
            }
        }
        return doanhThu;
    }

}