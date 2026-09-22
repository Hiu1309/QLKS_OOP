package manager;

import model.*;
import java.util.Scanner;

public class QuanLyNhanVien {
    private NhanVien[] danhSachNhanVien;

    public QuanLyNhanVien(){
        danhSachNhanVien = new NhanVien[10];
    }

    public void hienThiNhanVien(){
        System.out.println("Danh Sách Nhân Viên")
        for(int i=0;i<danhSachNhanVien.length;i++){
            if(danhSachNhanVien[i]!=null){
                danhSachNhanVien[i].hienThiThongTin();
            }
        }
        System.out.println();
    }

    public void themNhanVien(Scanner sc){
        boolean full = true;
        for(int i=0;i<danhSachNhanVien.length;i++){
            if(danhSachNhanVien[i]==null){
                full = false;
                break;
            }
        }

        if(full||danhSachNhanVien[danhSachNhanVien.length-1]!=null){
            NhanVien[] danhSachMoi = new NhanVien[danhSachNhanVien.length+1];
            System.arraycopy(danhSachNhanVien, 0, danhSachMoi, 0, danhSachNhanVien.length);
            danhSachNhanVien = danhSachMoi;
        }

        System.out.print("Nhập vị trí muốn thêm nhân viên vào: ");
        int viTri = sc.nextInt();
        sc.nextLine();
        if(viTri<1||viTri>danhSachNhanVien.length){
            System.out.println("Vị trí bạn chọn vượt ngoài phạm vi danh sách!");
            return;
        }
        NhanVien nv;
        String cccd, name, chucVu; float luong;
        System.out.print("Nhập thông tin nhân viên\nSố cccd: ");
        cccd=sc.nextLine();
        if(kiemTraTrungCCCD(cccd)){
            System.out.println("CCCD này đã tồn tại!");
            return;
        }
        System.out.print("Nhập họ và tên: ");
        name=sc.nextLine();
        System.out.print("Nhập chức vụ: ");
        chucVu=sc.nextLine();
        System.out.print("Nhập mức lương: ");
        luong=sc.nextFloat();
        if(chucVu.toLowerCase().contains("Quản Lý".toLowerCase())){
            nv=new QuanLy(cccd, name, luong);
        }else if(chucVu.toLowerCase().contains("Lễ Tân".toLowerCase())){
            nv=new LeTan(cccd, name, luong);
        }else{
            System.out.print("Chức vụ không tồn tại chỉ gồm 2 chức vụ là quản lý và lễ tân!");
            return;
        }
        
        int index = viTri-1;
        System.arraycopy(danhSachNhanVien, index, danhSachNhanVien, index+1, danhSachNhanVien.length-index-1);
        danhSachNhanVien[index]=nv;
        System.out.println("Thêm nhân viên thành công!");
    }

    public void suaThongTinNhanVien(String maNV, Scanner sc){
        int index=timKiemTheoMaNV(maNV);
        if(index==-1){
            System.out.println("Không tìm thấy nhân viên có mã tương ứng!");
            return;
        }

        int lc;
        System.out.print("Nhập các số ứng với lựa chọn muốn thay đổi\n1.Sửa toàn bộ thông tin\n2.Sửa từng thông tin");
        lc=sc.nextInt();
        sc.nextLine();

        NhanVien nv = danhSachNhanVien[index];
        String cccd, name, chucVu;
        float luong;

        if(lc==1){
            System.out.print("Nhập thông tin mới\nCCCD: ");
            cccd=sc.nextLine();
            if(kiemTraTrungCCCD(cccd)){
                System.out.print("CCCD này đã tồn tại!");
                return;
            }

            System.out.print("Họ và tên: ");
            name=sc.nextLine();
            System.out.print("Chức vụ: ");
            chucVu=sc.nextLine();
            System.out.print("Nhập lương: ");
            luong=sc.nextFloat();
            if(chucVu.toLowerCase().contains("Quản Lý".toLowerCase())){
                nv = new QuanLy(cccd, name, luong);
                NhanVien.giamSoLuong();
            }else if(chucVu.toLowerCase().contains("Lễ Tân".toLowerCase())){
                nv = new LeTan(cccd, name, luong);
                NhanVien.giamSoLuong();
            }else{
                System.out.println("Chức vụ không tồn tại chỉ gồm 2 chức vụ là quản lý và lễ tân!");
                return;
            }
        }else if(lc==2){
            System.out.print("Chọn thông tin nhân viên muốn sửa\n1.Số cccd"+
            "\n2.Họ và tên\n3.Chức vụ\n4.Lương\nNhập lựa chọn: ");
            int c=sc.nextInt();
            sc.nextLine();

            switch(c){
                case 1:
                    System.out.print("Số cccd: ");
                    cccd=sc.nextLine();
                    if(kiemTraTrungCCCD(cccd)){
                        System.out.println("CCCD này đã tồn tại!");
                        return;
                    }
                    nv.setCCCD(cccd);
                    break;

                case 2:
                    System.out.print("Họ và tên: ");
                    name=sc.nextLine();
                    nv.setName(name);
                    break;

                case 3:
                    System.out.print("Chức vụ: ");
                    chucVu=sc.nextLine();
                    if(chucVu.toLowerCase().contains("quản lí")){
                        nv=new QuanLy(nv.getCCCD(), nv.getName(), nv.getLuong());
                        NhanVien.giamSoLuong();
                    }else if(chucVu.toLowerCase().contains("lễ tân")){
                        nv=new LeTan(nv.getCCCD(), nv.getName(), nv.getLuong());
                        NhanVien.giamSoLuong();
                    }else{
                        System.out.print("Chức vụ nhập vào không hợp lệ!");
                        return;
                    }
                    break;

                case 4:
                    System.out.print("Mức lương: ");
                    luong=sc.nextFloat();
                    nv.setLuong(luong);
                    break;

                default:
                    System.out.println("Lựa chọn kh hợp lệ!");
                    return;
            }
        
        danhSachNhanVien[index]=nv;
        System.out.println("Sửa thông tin nhân viên thành công");
    }

    public void xoaNhanVien(String maNV){
        int index = timKiemTheoMaNV(maNV);
        if(index==-1){
            System.out.println("Kh tìm thấy nhân viên có mã tương ứng");
        }

        System.arraycopy(danhSachNhanVien, index+1, danhSachNhanVien, index, danhSachNhanVien.length-index);
        danhSachNhanVien[danhSachNhanVien.length-1]=null;
        NhanVien.giamSoLuong();
        System.out.println("Xóa nhân viên thành công");
    }

    public int timKiemTheoMaNV(String maNV){
        for(int i=0;i<danhSachNhanVien.length;i++){
            if(danhSachNhanVien[i]!=null&&danhSachNhanVien[i].getMaNV().equals(maNV)){
                return i;
            }
        }
        return -1;
    }

    public boolean kiemTraTrungCCCD(String cccd){
        for(int i=0;i<danhSachNhanVien.length;i++){
            if(danhSachNhanVien[i]!=null&&danhSachNhanVien[i].getCCCD().equals(cccd)){
                return true;
            }
        }
        return false;
    }

  

    
}
