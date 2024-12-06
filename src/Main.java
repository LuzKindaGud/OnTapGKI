import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HangBay[] hangBays;

    public static void main(String[] args) {
        hangBays = HangBay.taoDuLieuMau(); // Tạo dữ liệu mẫu
        int choice;

        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    themChuyenBay();
                    break;
                case 2:
                    xoaChuyenBay();
                    break;
                case 3:
                    timChuyenBay();
                    break;
                case 4:
                    datVe();
                    break;
                case 5:
                    huyVe();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n==================== MENU ====================");
        System.out.println("1. Thêm chuyến bay");
        System.out.println("2. Xóa chuyến bay");
        System.out.println("3. Tìm chuyến bay");
        System.out.println("4. Đặt vé");
        System.out.println("5. Hủy vé");
        System.out.println("0. Thoát");
        System.out.println("===============================================");
    }

    private static int getUserChoice() {
        System.out.print("Vui lòng chọn một tùy chọn: ");
        return scanner.nextInt();
    }

    private static void themChuyenBay() {
        System.out.print("Nhập mã chuyến bay: ");
        String maChuyenBay = scanner.next();
        System.out.print("Nhập sân bay đi: ");
        String sanBayDi = scanner.next();
        System.out.print("Nhập sân bay đến: ");
        String sanBayDen = scanner.next();
        System.out.print("Nhập ngày bay (YYYY-MM-DD): ");
        String ngayBay = scanner.next();
        System.out.print("Nhập giờ bay: ");
        int gioBay = scanner.nextInt();
        System.out.print("Nhập khoảng cách bay (km): ");
        double khoangCachBay = scanner.nextDouble();

        ChuyenBay chuyenBay = new ChuyenBay(maChuyenBay, sanBayDi, sanBayDen, ngayBay, gioBay, khoangCachBay);
        hangBays[0].themChuyenBay(chuyenBay); // Thêm vào hãng bay đầu tiên
        System.out.println("Chuyến bay đã được thêm thành công.");
    }

    private static void xoaChuyenBay() {
        System.out.print("Nhập mã chuyến bay cần xóa: ");
        String maChuyenBay = scanner.next();
        hangBays[0].xoaChuyenBay(maChuyenBay); // Xóa chuyến bay trong hãng bay đầu tiên
    }

    private static void timChuyenBay() {
        System.out.print("Nhập mã chuyến bay cần tìm: ");
        String maChuyenBay = scanner.next();
        ChuyenBay chuyenBay = hangBays[0].timChuyenBay(maChuyenBay); // Tìm chuyến bay trong hãng bay đầu tiên

        if (chuyenBay != null) {
            System.out.println("Thông tin chuyến bay:");
            System.out.println(chuyenBay);
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
        }
    }

    private static void datVe() {
        System.out.print("Nhập mã chuyến bay để đặt vé: ");
        String maChuyenBay = scanner.next();
        ChuyenBay chuyenBay = hangBays[0].timChuyenBay(maChuyenBay);

        if (chuyenBay != null) {
            System.out.print("Nhập mã ghế: ");
            String maGhe = scanner.next();
            // Giả sử có một hành khách đã được tạo sẵn
            HanhKhach hanhKhach = new HanhKhach("HK001", "Nguyen Van A", 2024, "ASHB1245","DangCap Airline", 'G', "DaNang ");
            chuyenBay.datGhe(maGhe); // Đặt ghế
            System.out.println ("Đặt vé thành công cho hành khách: " + hanhKhach.getTenHanhKhach());
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
        }
    }

    private static void huyVe() {
        System.out.print("Nhập mã chuyến bay để hủy vé: ");
        String maChuyenBay = scanner.next();
        ChuyenBay chuyenBay = hangBays[0].timChuyenBay(maChuyenBay);

        if (chuyenBay != null) {
            System.out.print("Nhập mã ghế để hủy: ");
            String maGhe = scanner.next();
            chuyenBay.huyGhe(maGhe); // Hủy ghế
            System.out.println("Hủy vé thành công.");
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
        }
    }

}
