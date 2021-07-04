package Buoi05;
import java.util.Scanner;
public class KhachHang {

    //Khai báo thuộc tính khách hàng
    private String hoten,diachi;
    private Boolean gioitinh;
    private Date ngaysinh;

    //Default constructor 
    public KhachHang(){
        hoten = new String();
        diachi = new String();
        gioitinh = true;   
        ngaysinh = new Date();
    }

    //Coppy constructor 
    public KhachHang(KhachHang kh){
        hoten = new String(kh.hoten);
        diachi = new String(kh.diachi);
        gioitinh = kh.gioitinh; 
        ngaysinh = new Date(kh.ngaysinh);  
    }

    //Hàm nhập thông tin khách hàng 
    public void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten khach hang: ");
        hoten = sc.nextLine();
        System.out.print("Nhap dia chi khach hang: ");
        diachi = sc.nextLine();
        System.out.print("Nhap gioi tinh khach hang (true = name),(false = nu): ");
        gioitinh = sc.nextBoolean();
        System.out.print("Nhap ngay thang nam sinh khach hang\n");
        ngaysinh.read();
    } 

    //Hàm in thông tin khách hàng 
    public void print(){
        System.out.println("Ten: " + hoten);
        System.out.println("Dia chi: " + diachi);
        if(gioitinh = true)  System.out.println("Gioi tinh: Nam");
        else System.out.println("Gioi tinh: Nu");
        System.out.println("Ngay thang nam sinh: " + ngaysinh.toString());
    }
}
