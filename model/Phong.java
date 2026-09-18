package model;

public class Phong {
    private String id;
    private int soPhong;
    private LoaiPhong loaiPhong;
    private boolean dangThue;

    public Phong(){}

    public Phong(String id, int soPhong, LoaiPhong loaiPhong, boolean dangThue){
        this.id=id;
        this.soPhong=soPhong;
        this.loaiPhong=loaiPhong;
        this.dangThue=dangThue;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public int getSoPhong(){
        return soPhong;
    }

    public void setSoPhong(int soPhong){
        this.soPhong=soPhong;
    }

    public LoaiPhong getLoaiPhong(){
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong){
        this.loaiPhong=loaiPhong;
    }

    public boolean getDangThue(){
        return dangThue;
    }
    
    public void setDangThue(boolean dangThue){
        this.dangThue=dangThue;
    }

    public String kiemTraTrong(boolean dangThue){
        if(dangThue){
            return "Đã có người đặt";
        }else
            return "Còn trống";
    }

    public void hienThiThongTinPhong(){
        System.out.println("Mã phòng: "+id+"\nSố phòng: "+soPhong+"\nTình trạng phòng: "+kiemTraTrong(dangThue));
        loaiPhong.hienThiThongTinLoaiPhong();
    }
}
