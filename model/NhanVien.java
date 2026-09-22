package model;

public class NhanVien extends Nguoi{
    private String maNV;
    private float luong;
    private static int soLuong=0;

    public NhanVien(){}

    public NhanVien(String cccd, String name, float luong){
        super(cccd,name);
        this.luong=luong;
        soLuong++;
        maNV=String.format("NV%03d",soLuong);
    }

    public String getMaNV(){
        return maNV;
    }
    public float getLuong(){
        return luong;
    }

    public void setLuong(float luong){
        this.luong=luong;
    }

    @Override
    public void hienThiThongTin(){
        System.out.print("Mã nhân viên: "+maNV+" || ")
        super.hienThiThongTin();
        System.out.print(" || Lương của nhân viên: "+luong);
    }

    public static void giamSoLuong(){
        soLuong--;
    }

    public static int demSoLuong(){
        return soLuong;
    }

}
