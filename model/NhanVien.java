package model;

public class NhanVien extends Nguoi{
    private float luong;
    private static int soLuong=0;

    public NhanVien(){}

    public NhanVien(String id, String name, float luong){
        super(id,name);
        this.luong=luong;
        soLuong++;
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
        System.out.println("Lương của nhân viên: "+luong);
    }

    public static int demSoLuong(){
        return soLuong;
    }

}
