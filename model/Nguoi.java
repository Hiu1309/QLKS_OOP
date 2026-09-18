package model;

public abstract class Nguoi {
    private String id, name;
    
    public Nguoi(){}

    public Nguoi(String id, String name){
        this.id=id;
        this.name=name;        
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void hienThiThongTin(){
        System.out.println("Mã cccd: "+id+"\nHọ và tên: "+name);
    }

    


}
