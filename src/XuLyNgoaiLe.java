import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class XuLyNgoaiLe {

    private ChuyenBay[] chuyenBay;

    public boolean kiemTraDinhDangMa(String ma) {
        return ma.matches("^[A-Z]{2}\\d{3}$"); // Ví dụ: AB123
    }

    public boolean kiemTraNgayGioHopLe(String ngayGio) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setLenient(false);
        try {
            sdf.parse(ngayGio);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean kiemTraTuoiHanhKhach(Date ngaySinh) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngaySinh);
        int tuoi = Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        return tuoi > 18;
    }

    public boolean kiemTraSoGheConTrong(ChuyenBay chuyenBay) {
        return chuyenBay.getSoGheDaDat() < chuyenBay.getTongSoGhe();
    }

    public boolean kiemTraTrungLapDatVe(Ticket ticket) {
        for (Ticket existingTicket : ticket.getChuyenBay().getDanhSachVe()) {
            if (existingTicket != null && existingTicket.getHanhKhach().equals(ticket.getHanhKhach()) &&
                    existingTicket.getChuyenBay().equals(ticket.getChuyenBay())) {
                return true; // Có vé trùng lặp
            }
        }
        return false; // Không có vé trùng lặp
    }

    public boolean kiemTraTrungLichBay(HanhKhach hanhKhach, ChuyenBay chuyenBay) {
        for (Ticket ticket : hanhKhach.getDanhSachVe()) {
            if (ticket != null && ticket.getChuyenBay().getNgayBay().equals(chuyenBay.getNgayBay())) {
                return true; // Có lịch bay trùng
            }
        }
        return false; // Không có lịch bay trùng
    }
}