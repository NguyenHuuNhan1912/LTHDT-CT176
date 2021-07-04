package Buoi05;
import java.util.Scanner;
public class HangHoa {

    //Khai báo thuộc tính
    private String mshh,tenhh,namsx;

    //Default constructor
    public HangHoa(){
        mshh = new String();
        tenhh = new String();
        namsx = new String();
    }

    //Coppy constructor
    public HangHoa(HangHoa hh){
        mshh = new String(hh.mshh);
        tenhh = new String(hh.tenhh);
        namsx = new String(hh.namsx);
    }

    //Hàm nhập thông tin hàng hóa 
    public void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mshh: ");
        mshh = sc.nextLine();
        System.out.print("Nhap ten hang hoa: ");
        tenhh = sc.nextLine();
        System.out.print("Nhap nam san xuat hang hoa: ");
        namsx = sc.nextLine();
    }

    //Hàm in thông tin hàng hóa 
    public void print(){
        System.out.println("Ma so hang hoa: " + mshh);
        System.out.println("Ten hang hoa: " + tenhh);
        System.out.println("Nam san xuat hang hoa " + tenhh + " : " + namsx);
    }
}
