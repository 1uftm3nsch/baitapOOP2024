import java.util.ArrayList;

public class bai3 {

    static class HoaDon {
        private int hoaDonID;
        private KhachHang kh;
        private String ngayBan;
        private float tongTien;
        private static ArrayList<HoaDon> hoaDon = new ArrayList<>();

        public HoaDon(int hoaDonID, KhachHang kh, String ngayBan, float tongTien) {
            this.hoaDonID = hoaDonID;
            this.kh = kh;
            this.ngayBan = ngayBan;
            this.tongTien = tongTien;
        }

        public void setTongTien(float tongTien) {
            this.tongTien = tongTien;
        }

        public float getTongTien() {
            return tongTien;
        }

        public KhachHang getKh() {
            return kh;
        }

        public void InHoaDon() {
            System.out.println("Hoa Don ID: " + hoaDonID);
            System.out.println("Khach Hang: " + kh.getTenKH());
            System.out.println("Ngay Ban: " + ngayBan);
            System.out.println("Tong Tien: " + tongTien);
        }

        public void ThemHoaDon(HoaDon hd) {
            hoaDon.add(hd);
        }
    }

    static class KhachHang {
        private String diaChi, tenKH;
        private int KhachHangID;

        public KhachHang(String diaChi, String tenKH, int KhachHangID) {
            this.diaChi = diaChi;
            this.tenKH = tenKH;
            this.KhachHangID = KhachHangID;
        }

        public String getTenKH() {
            return tenKH;
        }
    }

    static class MatHang {
        private float gia;
        private int matHangID, soLuong;
        private String tenMatHang;
        private static ArrayList<MatHang> kho = new ArrayList<>();

        public MatHang(float gia, int matHangID, int soLuong, String tenMatHang) {
            this.gia = gia;
            this.matHangID = matHangID;
            this.soLuong = soLuong;
            this.tenMatHang = tenMatHang;
        }

        public float getGia() {
            return gia;
        }

        public String getTenMatHang() {
            return tenMatHang;
        }

        public static void ThemMatHangVaoKho(MatHang matHang) {
            kho.add(matHang);
        }
    }

    static class MatHangMua {
        private HoaDon hd;
        private int matHangMuaID;
        private MatHang mh;
        private int soLuong;
        private static ArrayList<MatHangMua> matHangMua = new ArrayList<>();

        public MatHangMua(HoaDon hd, int matHangMuaID, MatHang mh, int soLuong) {
            this.hd = hd;
            this.matHangMuaID = matHangMuaID;
            this.mh = mh;
            this.soLuong = soLuong;
        }

        public HoaDon getHd() {
            return hd;
        }

        public MatHang getMh() {
            return mh;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public static ArrayList<MatHangMua> getMatHangMua() {
            return matHangMua;
        }

        public void ThemMatHangMuaCuaHoaDon() {
            matHangMua.add(new MatHangMua(hd, matHangMuaID, mh, soLuong));
        }
    }

    public static void main(String[] args) {
        MatHang itemX = new MatHang(100000, 1, 10, "X");
        MatHang itemY = new MatHang(120000, 2, 20, "Y");
        MatHang itemZ = new MatHang(150000, 3, 30, "Z");
        MatHang.ThemMatHangVaoKho(itemX);
        MatHang.ThemMatHangVaoKho(itemY);
        MatHang.ThemMatHangVaoKho(itemZ);

        KhachHang khachHang = new KhachHang("Hanoi", "Nguyen Van A", 1);

        HoaDon hoaDon = new HoaDon(1001, khachHang, "2024-11-12", 0);
        hoaDon.ThemHoaDon(hoaDon);

        MatHangMua matHangMuaX = new MatHangMua(hoaDon, 1, itemX, 2);
        MatHangMua matHangMuaY = new MatHangMua(hoaDon, 2, itemY, 3);
        matHangMuaX.ThemMatHangMuaCuaHoaDon();
        matHangMuaY.ThemMatHangMuaCuaHoaDon();

        hoaDon.setTongTien((itemX.getGia() * 2) + (itemY.getGia() * 3));

        hoaDon.InHoaDon();
        System.out.println("Mat Hang Da Mua:");
        for (MatHangMua mh : MatHangMua.getMatHangMua()) {
            if (mh.getHd() == hoaDon) {
                System.out.println("Mat Hang: " + mh.getMh().getTenMatHang() + ", So Luong: " + mh.getSoLuong() + ", Gia: " + mh.getMh().getGia());
            }
        }
    }
}

