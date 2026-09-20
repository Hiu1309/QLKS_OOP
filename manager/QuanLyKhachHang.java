package manager;

import model.KhachHang;
import java.util.Scanner;

public class QuanLyKhachHang {
    private KhachHang[] danhSachKhachHang;

    public QuanLyKhachHang(){
        danhSachKhachHang = new KhachHang[10];
    }

    public void hienThiDanhSachKhachHang(){
        System.out.println("Danh Sách Khách Hàng");
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]!=null){                
                danhSachKhachHang[i].hienThiThongTin();                
            }            
        }
    }

    public void themKhachHang(Scanner sc){        
        boolean full=true;
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]==null){
                full=false;
                break;
            }
        }

        if(full||danhSachKhachHang[danhSachKhachHang.length-1]!=null){
            KhachHang[] danhSachMoi = new KhachHang[danhSachKhachHang.length+1];
            System.arraycopy(danhSachKhachHang, 0, danhSachMoi, 0, danhSachKhachHang.length);
            danhSachKhachHang=danhSachMoi;
        }

        System.out.print("Nhập vị trí khách hàng muốn thêm vào: ");
        int viTri=sc.nextInt();
        if(viTri<1||viTri>danhSachKhachHang.length){
            System.out.println("Vị trí bạn chọn vượt ngoài phạm vi danh sách!");
            return;
        }

        sc.nextLine();
        System.out.print("Nhập thông tin khách hàng thêm vào\nSố cccd: ");
        String cccd = sc.nextLine();
        if(kiemTraTrungCCCD(cccd)){
            System.out.println("CCCD này đã tồn tại!");
            return;
        }
        System.out.print("Họ và tên: ");
        String name = sc.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = sc.nextLine();
        if(kiemTraTrungSDT(phone)){
            System.out.println("Số điện thoại này đã tồn tại!");
            return;
        }
        KhachHang kh = new KhachHang(cccd, name, phone);

        int index=viTri-1;

        System.arraycopy(danhSachKhachHang, index, danhSachKhachHang, index+1, danhSachKhachHang.length-index-1);
        System.out.println("Thêm khách hàng thành công!");
        danhSachKhachHang[index]=kh;        
    }

    public int timKiemKhachHang(String idKH){
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]!=null&&danhSachKhachHang[i].getIdKH().equals(idKH)){
                return i;
            }
        }
        return -1;
    }

    public void suaThongTinKhachHang(String idKH, Scanner sc){
        int index=timKiemKhachHang(idKH);
        if(index==-1){
            System.out.println("Không tìm thấy khách hàng!");
            return;
        }
        KhachHang kh = danhSachKhachHang[index];
        String cccd, name, phone;
        System.out.print("Nhập 1 để sửa toàn bộ thông tin của khách hàng\n"+
            "Nhập 2 để sửa thông tin tùy chọn của khách hàng\nLựa chọn: ");
        int sl=sc.nextInt();
        sc.nextLine();
        if(sl==1){
            System.out.print("Số CCCD: ");
            cccd=sc.nextLine();
            if(kiemTraTrungCCCD(cccd)){
                System.out.println("CCCD này đã tồn tại!");
                return;
            }
            kh.setCCCD(cccd);
            System.out.print("Họ và tên: ");
            name=sc.nextLine();
            kh.setName(name);
            System.out.print("Số điện thoại: ");
            phone=sc.nextLine();
            if(kiemTraTrungSDT(phone)){
                System.out.println("Số điện thoại này đã tồn tại!");
                return;
            }
            kh.setPhone(phone);
        }else if(sl==2){
            System.out.print("Chọn thông tin khách hàng muốn sửa theo các số sau: "+"\n1.Để đổi số cccd"+
                "\n2.Để đổi họ và tên\n3.Để đổi số điện thoại\nLựa chọn: ");
            int c=sc.nextInt();
            sc.nextLine();
            switch(c){
                case 1:
                    System.out.print("Số CCCD: ");
                    cccd=sc.nextLine();
                    if(kiemTraTrungCCCD(cccd)){
                        System.out.println("CCCD này đã tồn tại!");
                        return;
                    }
                    kh.setCCCD(cccd);
                    break;
                case 2:
                    System.out.print("Họ và tên: ");
                    kh.setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Số điện thoại: ");
                    phone=sc.nextLine();
                    if(kiemTraTrungSDT(phone)){
                        System.out.println("Số điện thoại này đã tồn tại!");
                        return;
                    }
                    kh.setPhone(phone);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }else{
            System.out.println("Lựa chọn không hợp lệ!");
        }
        System.out.println("Sửa thông tin khách hàng thành công!");
        danhSachKhachHang[index]=kh;
    }

    public void xoaKhachHang(String idKH){        
        int index = timKiemKhachHang(idKH);
        if(index==-1){
            System.out.println("Không tìm thấy mã khách hàng tương ứng với khách hàng nào!");
            return;
        }
        System.arraycopy(danhSachKhachHang, index+1, danhSachKhachHang, index, danhSachKhachHang.length-index-1);        
        System.out.println("Xóa khách hàng thành công");
        danhSachKhachHang[danhSachKhachHang.length-1]=null;
        KhachHang.giamSoLuong();
    }

    public boolean kiemTraTrungCCCD(String cccd){
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]!=null&&danhSachKhachHang[i].getCCCD().equals(cccd)){
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraTrungSDT(String phone){
        for(int i=0;i<danhSachKhachHang.length;i++){
            if(danhSachKhachHang[i]!=null&&danhSachKhachHang[i].getPhone().equals(phone)){
                return true;
            }
        }
        return false;
    }
}
