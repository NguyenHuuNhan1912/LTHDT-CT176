package Buoi05;
import java.util.Scanner;
import Exception.*;
public class HoaDon {

    //Khai báo thuộc tính của hóa đơn
    private KhachHang kh;
    private KhachHangVIP khv;
    private String mshd;
    private Date ngaylap;
    private ChiTietHH ct[];
    private int n;
    final int max = 50;

    //Default constructor
    public HoaDon(){
        kh = new KhachHang();
        khv = new KhachHangVIP();
        mshd = new String();
        ngaylap = new Date();
        ct = new ChiTietHH[max];
        n = 0;
    }
    
    //Coppy constructor 
    public HoaDon(HoaDon hd){
        kh = new KhachHang(hd.kh);
        khv = new KhachHangVIP(hd.khv);
        mshd = new String(hd.mshd);
        ngaylap = new Date(hd.ngaylap);
        ct = new ChiTietHH[max];
        n = hd.n;
        for(int i=0;i<n;i++){
            ct[i] = new ChiTietHH(hd.ct[i]);
        }
    }

    //Hàm nhập thông tin hóa đơn 
    public void read(){
        Scanner sc = new Scanner(System.in);
        exception.clear(); 
        System.out.print("Chon 1 neu khach hang la KHVIP\n");
        System.out.print("Chon 2 neu khach hang la khach hang binh thuong\n");
        char key;
        System.out.print("\nNhap su lua chon cua ban: ");
        key = sc.nextLine().charAt(0);
        if(key=='1')	kh = new KhachHangVIP();
        else if(key =='2') kh = new KhachHang();
        kh.read();
        System.out.print("Nhap ma so hoa don: ");
        mshd = sc.nextLine();
        System.out.print("Nhap ngay lap hoa don\n");
        ngaylap.read();
        System.out.print("Nhap so luong hang hoa can phai mua: ");
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
        	System.out.println("Nhap thong tin hang hoa thu " + (i+1));
        	ct[i] = new ChiTietHH();
        	ct[i].read();
        }
    }

    //Hàm in thông tin hóa đơn 
    public void print() {
        exception.clear();
    	System.out.print("_____________________________________________________________________________________\n");
    	System.out.println("Thong tin khach hang");
    	kh.print();
    	System.out.println("Thong tin hoa don cua khach hang");
    	System.out.println("Ma so hoa don: " + mshd);
    	System.out.println("Ngay thanh lap hoa don: " + ngaylap.toString());
    	System.out.println("So luong hang hoa can mua cua khach hang la: " + n);
    	for(int i=0;i<n;i++) {
    		System.out.println("Thong tin hang hoa thu " + (i+1));
    		ct[i].print();
    	}
    	System.out.print("_____________________________________________________________________________________");
    }
}
