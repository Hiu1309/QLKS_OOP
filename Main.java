import manager.*;
import model.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        QuanLyKhachHang dsKH = new QuanLyKhachHang();
        dsKH.themKhachHang(sc);
        dsKH.themKhachHang(sc);
        dsKH.hienThiDanhSachKhachHang();
        dsKH.themKhachHang(sc);
        System.out.print("Nhập mã kh muốn sửa tt: ");
        String maKH1 = sc.nextLine();
        dsKH.suaThongTinKhachHang(maKH1, sc);
        dsKH.hienThiDanhSachKhachHang();
        System.out.print("Nhập mã của tk kh muốn xóa: ");
        String maKH2 = sc.nextLine();
        dsKH.xoaKhachHang(maKH2);
        dsKH.hienThiDanhSachKhachHang();
        
    }
}