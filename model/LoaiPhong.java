package model;

public class LoaiPhong {
    private String type;
    private double price;
    private int bed, maxPerson;

    public LoaiPhong(){}

    public LoaiPhong(String type, double price, int bed, int maxPerson){
        this.type=type;
        this.price=price;
        this.bed=bed;
        this.maxPerson=maxPerson;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public int getBed(){
        return bed;
    }

    public void setBed(int bed){
        this.bed=bed;
    }

    public int getMaxPerson(){
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson){
        this.maxPerson=maxPerson;
    }

    public  void hienThiThongTinLoaiPhong(){
        System.out.println("Phòng hạng: "+type+"\nGiá phòng: "+price+"\nSố giường: "+bed+"\nSố người tối đa: "+maxPerson);
    }
    
}
