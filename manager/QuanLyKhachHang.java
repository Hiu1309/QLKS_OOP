package manager;

import model.KhachHang;
import java.util.Scanner;

public class QuanLyKhachHang {
    private KhachHang[] danhSachKhachHang;

    public QuanLyKhachHang(){
        danhSachKhachHang = new KhachHang[10];
    }

    public void hienThiDanhSachKhachHang(){
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]!=null){
                System.out.print("Mã khách hàng: KH"+(i+1)+
            " || ");
                danhSachKhachHang[i].hienThiThongTin();
            }            
        }
    }

    public void themKhachHang(KhachHang kh, Scanner sc){        
        boolean full=true;
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]==null){
                full=false;
                break;
            }
        }
        if(full){
            KhachHang[] danhSachMoi = new KhachHang[danhSachKhachHang.length+1];
            System.arraycopy(danhSachKhachHang, 0, danhSachMoi, 0, danhSachKhachHang.length);
            danhSachKhachHang=danhSachMoi;
        }

        System.out.print("Nhập vị trí khách hàng thêm vào: ");
        int viTri=sc.nextInt();

        int index=viTri-1;

        System.arraycopy(danhSachKhachHang, index, danhSachKhachHang, index+1, danhSachKhachHang.length-index-1);
        danhSachKhachHang[index]=kh;
        KhachHang.tangSoLuong();
    }

    public int timKiemKhachHang(String cccd){
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i].getCCCD().equals(cccd)){
                return i;
            }
        }
        return -1;
    }

    public void xoaKhachHang(String cccd){        
        int index = timKiemKhachHang(cccd);
        if(index==-1){
            System.out.println("Không tìm thấy cccd tương ứng với khách hàng nào!");
            return;
        }
        System.arraycopy(danhSachKhachHang, index+1, danhSachKhachHang, index, danhSachKhachHang.length-index-1);        
        danhSachKhachHang[danhSachKhachHang.length-1]=null;
        KhachHang.giamSoLuong();
        
    }
  



}
