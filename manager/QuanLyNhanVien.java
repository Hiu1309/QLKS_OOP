package manager;

import model.NhanVien;
import java.util.Scanner;

public class QuanLyNhanVien {
    private NhanVien[] danhSachNhanVien;

    public QuanLyNhanVien(){
        danhSachNhanVien = new NhanVien[10];
    }

    public void hienThiNhanVien(){
        for(int i=0;i<danhSachNhanVien.length;i++){
            if(danhSachNhanVien[i]!=null){
                System.out.print("Mã nhân viên: NV"+(i+1)+" || ");
                danhSachNhanVien[i].hienThiThongTin();
            }
        }
    }

    public void themNhanVien(NhanVien nv, Scanner sc){
        boolean full = true;
        for(int i=0;i<danhSachNhanVien.length;i++){
            if(danhSachNhanVien[i]==null){
                full = false;
                break;
            }
        }

        if(full){
            NhanVien[] danhSachMoi = new NhanVien[danhSachNhanVien.length+1];
            System.arraycopy(danhSachNhanVien, 0, danhSachMoi, 0, danhSachNhanVien.length);
            danhSachNhanVien = danhSachMoi;
        }

        System.out.print("Nhập vị trí muốn thêm nhân viên vào: ");
        int viTri = sc.nextInt();
        if(viTri<1||viTri>danhSachNhanVien.length){
            System.out.println("Vị trí bạn chọn vượt ngoài phạm vi danh sách!");
            return;
        }

        int index = viTri-1;
        System.arraycopy(danhSachNhanVien, index, danhSachNhanVien, index+1, danhSachNhanVien.length-index-1);
        danhSachNhanVien[index]=nv;
    }

  

    
}
