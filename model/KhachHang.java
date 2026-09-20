package model;

public class KhachHang extends Nguoi {    
    private String idKH;
    private String phone;
    private static int soLuong=0;

    public KhachHang(){}

    public KhachHang(String cccd, String name, String phone){        
        super(cccd,name);
        this.phone=phone;      
        soLuong++;
        idKH=String.format("KH%03d", soLuong);          
    }

    public String getIdKH(){
        return idKH;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    @Override
    public void hienThiThongTin(){        
        System.out.print("Mã khách hàng: "+idKH+" || ");
        super.hienThiThongTin();
        System.out.println(" || Số điện thoại khách hàng: "+phone);
    }

    public static void giamSoLuong(){
        soLuong--;
    }

    public static int demSoLuong(){
        return soLuong;
    }
}
