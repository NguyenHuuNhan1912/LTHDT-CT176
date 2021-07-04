package Buoi05;
import java.util.Scanner;

public class SDHoaDon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDanh sach cua ban co bao nhieu hoa don: ");

        int n = Integer.parseInt(sc.nextLine());
        HoaDon ds[] = new HoaDon[n];

        //Nhập danh sách các hóa đơn 
        System.out.println("\nNhap thong tin cac hoa don");
        for(int i=0;i<n;i++) {
        	System.out.println("\n---Nhap thong tin hoa don thu " + (i+1));
        	ds[i] = new HoaDon();
        	ds[i].read();
        }

        //Hàm in thông tin các hóa đơn
        System.out.println("\nThong tin cac hoa don vua nhap");
        for(int i=0;i<n;i++) {
        	System.out.println("\nThong tin hoa don thu " + (i+1));
        	ds[i].print();
        }
    }
}
