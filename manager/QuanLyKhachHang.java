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
                System.out.println();
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

        System.out.print("Nhập vị trí khách hàng muốn thêm vào: ");
        int viTri=sc.nextInt();
        if(viTri<0||viTri>danhSachKhachHang.length)
            return;

        int index=viTri-1;

        System.arraycopy(danhSachKhachHang, index, danhSachKhachHang, index+1, danhSachKhachHang.length-index-1);
        danhSachKhachHang[index]=kh;
        KhachHang.tangSoLuong();
    }

    public int timKiemKhachHang(String cccd){
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]!=null&&danhSachKhachHang[i].getCCCD().equals(cccd)){
                return i;
            }
        }
        return -1;
    }

    public void suaThongTinKhachHang(String cccd, Scanner sc){
        int index=timKiemKhachHang(cccd);
        if(index==-1){
            System.out.println("Không tìm thấy khách hàng!");
            return;
        }
        KhachHang kh = danhSachKhachHang[index];
        System.out.print("Nhập 1 để sửa toàn bộ thông tin của khách hàng\n"+
            "Nhập 2 để sửa thông tin tùy chọn của khách hàng\nLựa chọn: ");
        int sl=sc.nextInt();
        sc.nextLine();
        if(sl==1){
            System.out.print("Số CCCD: ");
            kh.setCCCD(sc.nextLine());
            System.out.print("Họ và tên: ");
            kh.setName(sc.nextLine());
            System.out.print("Số điện thoại: ");
            kh.setPhone(sc.nextLine());
        }else if(sl==2){
            System.out.print("Chọn thông tin khách hàng muốn sửa theo các số sau: "+"\n1.Để đổi số cccd"+
                "\n2.Để đổi họ và tên\n3.Để đổi số điện thoại\nLựa chọn: ");
            int c=sc.nextInt();
            sc.nextLine();
            switch(c){
                case 1:
                    System.out.print("Số CCCD: ");
                    kh.setCCCD(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Họ và tên: ");
                    kh.setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Số điện thoại: ");
                    kh.setPhone(sc.nextLine());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }else{
            System.out.println("Lựa chọn không hợp lệ!");
        }
        danhSachKhachHang[index]=kh;
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
