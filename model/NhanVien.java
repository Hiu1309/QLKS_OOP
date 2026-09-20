package model;

public class NhanVien extends Nguoi{
    private float luong;
    private static int soLuong=0;

    public NhanVien(){}

    public NhanVien(String cccd, String name, float luong){
        super(cccd,name);
        this.luong=luong;
    }

    public float getLuong(){
        return luong;
    }

    public void setLuong(float luong){
        this.luong=luong;
    }

    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.print(" || Lương của nhân viên: "+luong);
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
