package model;

public class KhachHang extends Nguoi {
    private String phone;
    private static int soLuong=0;

    public KhachHang(){}

    public KhachHang(String id, String name, String phone){
        super(id,name);
        this.phone=phone;
        soLuong++;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Số điện thoại khách hàng: "+phone);
    }

    public static int demSoLuong(){
        return soLuong;
    }
}
