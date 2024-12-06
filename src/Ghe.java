public class Ghe {
    private String maGhe;
    private char hangGhe;
    private boolean trangThai; // true - trống, false - đã đặt
    private double giaCoBan;

    public Ghe(String maGhe, char hangGhe, double giaCoBan) {
        this.maGhe = maGhe;
        this.hangGhe = hangGhe;
        this.trangThai = true; // Mới tạo thì ghế trống
        this.giaCoBan = giaCoBan;
    }

    // Getter và Setter

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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaCoBan() {
        return giaCoBan;
    }

    public void setGiaCoBan(double giaCoBan) {
        this.giaCoBan = giaCoBan;
    }

    @Override
    public String toString() {
        return "Ghe{" +
                "maGhe='" + maGhe + '\'' +
                ", hangGhe=" + hangGhe +
                ", trangThai=" + trangThai +
                ", giaCoBan=" + giaCoBan +
                '}';
    }
}