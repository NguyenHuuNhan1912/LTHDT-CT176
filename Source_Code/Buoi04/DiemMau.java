package Buoi04;
import java.util.Scanner;
import Buoi02.Diem;
import Exception.*;

public class DiemMau extends Diem{

	//Thêm thuộc tính màu 
	private String mau;

	//Phương thức xây dựng mặc nhiên của DiemMau
	public DiemMau(){
		super();
		mau = new String();
	}

	//Phương thức xây dựng có 3 tham số của DiemMau
	public DiemMau(int a, int b, String m){
		super(a,b);
		mau = new String(m);
	}

	//Coppy constructor DiemMau 
	public DiemMau(DiemMau dm){
		super((Diem)dm);
		mau = new String(dm.mau);
	}

	//Hàm nhập thông tin của DiemMau 
	public void read(){
		super.read();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap mau cua diem: ");
		mau = sc.nextLine();
	}

	//Hàm in thông tin của DiemMau
	public void print(){
		super.print();
		System.out.println("\nMau: "+mau);
	}

	//Hàm in thông tin DiemMau có kiểu trả về 
	public String toString(){
	 	return super.toString() + ("\n\nDiem co mau: " + mau) ;
	}

	//Hàm gán màu 
	public void gan(String m){
	 	mau = new String(m);
	}

	//Hàm nhập danh sách các điểm(bao gồm Diem hoặc DiemMau)
	public static void read_List(Diem ds[]){
		Scanner sc = new Scanner(System.in);
		char c;
		System.out.println("\nNhap danh sach cac diem");
		for(int i=0;i<ds.length;i++){
			System.out.print("\nBan chon nhap diem(nhap d) hay diem mau (nhap m): ");
			c = sc.nextLine().charAt(0);
			if(c=='d')	ds[i] = new Diem();
			else if(c=='m')	ds[i] = new DiemMau();
			ds[i].read();
		}
	}

	//Hàm in danh sách các điểm(bao gom Diem hoac DiemMau) 
	public static void print_List(Diem ds[]){
		for(int i=0;i<ds.length;i++){
			System.out.println("\nThong tin diem thu " + (i+1));
			System.out.println("\nds[" +(i+1)+ "] = " + ds[i].toString());
		}
	}

	//Hàm chính 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		DiemMau a = new DiemMau(5,10,"Trang");
		System.out.print("\nThong tin diem a vua khoi tao\n");
		System.out.println("\nDiem a = " + a.toString());

		DiemMau b = new DiemMau();
		System.out.println("\nNhap thong tin cho diem b");
		b.read();
		b.tinhTien(10,8);
		b.gan("Vang");
		System.out.println("\nThong tin diem b vua tinh tien va gan mau");
		System.out.println("\nDiem b = " + b.toString());

		System.out.print("\nDanh sach cua ban co tat ca bao nhieu diem: ");
		int  n = Integer.parseInt(sc.nextLine());

		//Nhập danh sách 
		Diem ds[] = new Diem[n];
		DiemMau.read_List(ds);

		//In danh sách 
		System.out.println("\nDanh sach vua nhap");
		exception.clear();
		DiemMau.print_List(ds);

		//sử dụng phương thức clear(xóa màn hình) trong gói Exception của lớp exception
	}
}