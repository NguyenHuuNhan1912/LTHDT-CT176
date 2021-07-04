package Buoi05;
import java.util.Scanner;
public class ChiTietHH {

    //Khai báo thuộc tính 
    private int sl,dg;
    private HangHoa h;
    
    //Default constructor 
    public ChiTietHH(){
        sl = 0;
        dg = 0;
        h = new HangHoa();
    }

    //Coppy constructor 
    public ChiTietHH(ChiTietHH hh){
        sl = hh.sl;
        dg = hh.dg;
        h = new HangHoa(hh.h);
    }

    //Hàm nhập thông tin hàng hóa 
    public void read(){
        Scanner sc = new Scanner(System.in);
        h.read();
        System.out.print("Nhap so luong can mua hang hoa: ");
        sl = sc.nextInt();
        System.out.print("Nhap don gia cua hang hoa do: ");
        dg = sc.nextInt();
    }

    //Hàm in thông tin 
    public void print(){
        h.print();
        System.out.println("So luong: " + sl);
        System.out.println("Gia tien: " + dg);
    }
}
