package model;

public class KhachHang extends Nguoi {    
    private String phone;
    private static int soLuong=0;

    public KhachHang(){}

    public KhachHang(String cccd, String name, String phone){        
        super(cccd,name);
        this.phone=phone;                
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
        System.out.print("|| Số điện thoại khách hàng: "+phone);
    }

    public static void tangSoLuong(){
        soLuong++;
    }

    public static void giamSoLuong(){
        soLuong--;
    }

    public static int demSoLuong(){
        return soLuong;
    }
}
