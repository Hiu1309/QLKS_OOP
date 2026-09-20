package model;

public abstract class Nguoi {
    private String cccd, name;
    
    public Nguoi(){}

    public Nguoi(String cccd, String name){
        this.cccd=cccd;
        this.name=name;        
    }

    public String getCCCD(){
        return cccd;
    }

    public String getName(){
        return name;
    }

    public void setCCCD(String cccd){
        this.cccd=cccd;
    }

    public void setName(String name){
        this.name=name;
    }

    public void hienThiThongTin(){
        System.out.print("Mã cccd: "+cccd+" || Họ và tên: "+name);
    }

    


}
