package model;

public class LeTan extends NhanVien {

    public void tiepNhanKhach(){
        System.out.println("Lễ tân đang tiếp nhận khách");
    }

    public void checkIn(){
        System.out.println("Check-in cho khách vào phòng");
    }

    public void checkOut(){
        System.out.println("Check-out khi khách trả phòng");
    }

    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Chức vụ: Lễ tân");
    }
}
