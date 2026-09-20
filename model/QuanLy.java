package model;

public class QuanLy extends NhanVien {

    public QuanLy(){}

    public QuanLy(String cccd, String name, float luong){
        super(cccd, name, luong);
    }
    
    public void xemBaoCao(){
        System.out.println("Báo cáo");
    }

    public void quanLyNhanVien(){
        System.out.println("Xem nhân viên");
    }

    public void quanLyKhachHang(){
        System.out.println("Xem khách hàng");
    }

    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println(" || Chức vụ: Quản lý");
    }


}
