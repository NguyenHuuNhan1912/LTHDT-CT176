package Buoi05;
import java.util.Scanner;
public class KhachHangVIP extends KhachHang {

    //Thêm phương thức tỉ lệ giảm giá 
    private float tile;

    //Default constructor
    public KhachHangVIP(){
        super();
        tile = 0.0f;
    }

    //Coppy constructor 
    public KhachHangVIP(KhachHangVIP khv){
        super(khv);
        tile = khv.tile;
    }

    //Hàm nhập thông tin khách hàng VIP
    public void read(){
        super.read();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ti le giam gia cho khach hang VIP: ");
        tile = sc.nextFloat(); 
    }  

    //Hàm in thông tin khách hàng VIP 
    public void print(){
        super.print();
        System.out.println("Ti le giam gia cua khach hang vip la: " + tile);
    }
}
