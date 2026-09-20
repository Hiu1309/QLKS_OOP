import manager.QuanLyKhachHang;
import model.KhachHang;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        QuanLyKhachHang dsKH = new QuanLyKhachHang();
        Scanner sc = new Scanner(System.in);
        KhachHang kh = new KhachHang("079", "hiu", "010");
        dsKH.themKhachHang(kh,sc);
        dsKH.hienThiDanhSachKhachHang();
        dsKH.suaThongTinKhachHang(kh.getCCCD(), sc);
        dsKH.hienThiDanhSachKhachHang();
        dsKH.xoaKhachHang(kh.getCCCD());
        KhachHang kh2 = new KhachHang("089", "tai", "0123");
        dsKH.themKhachHang(kh2,sc);
        dsKH.hienThiDanhSachKhachHang();
       
       
    }
}