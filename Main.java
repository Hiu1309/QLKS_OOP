import manager.*;
import model.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        NhanVien nv1 = new NhanVien("a", "a", 200);
        NhanVien nv2 = nv1;
        nv2 = new QuanLy("b", "b", 3);
        nv1=nv2;
        
    }
}