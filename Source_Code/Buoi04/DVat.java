package Buoi04;
import java.util.Scanner;
import Exception.*;
public abstract class DVat{

	//Khai báo thuộc tính động vật
	private String giong;
	private String mau;
	private float cannang;

	//Default constructor
	public DVat() {
		giong = new String();
		mau = new String();
		cannang = 0.0f;
	}

	//Coppy constructor
	public DVat(DVat d) {
		giong = new String(d.giong);
		mau = new String(d.mau);
		cannang = d.cannang;
	}

	//Hàm nhập thông tin con vật
	public void read() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap ten giong: ");
		giong = sc.nextLine();
		System.out.print("\nNhap mau: ");
		mau = sc.nextLine();
		System.out.print("\nNhap can nang: ");
		cannang = Float.parseFloat(sc.nextLine());
	}

	//Hàm in thông tin con vật
	public void print() {
		System.out.println("\nTen giong: "+giong);
		System.out.println("\nMau: "+mau);
		System.out.println("\nCan nang: "+cannang);
		System.out.print("\nTieng keu: ");
	}

	//Hàm khai báo phương thức kêu
	//Phương thức trừu tượng chỉ có phần khai báo mà không có phần thực thi
	//Phần thực thi sẽ thực hiện trong các lớp con cháu 
	public abstract void Keu();

	//Hàm nhập danh sách các động vật
	public static void read_List(DVat ds[]){
		Scanner sc = new Scanner(System.in);
		char c;
		System.out.println("\nNhap thong tin cac con vat co trong danh sach");
		for (int i=0;i<ds.length;i++) {
			System.out.println("\nNhap thong tin con vat thu "+(i+1));
			System.out.println("Bo nhap b.\nHeo nhap h.\nDe nhap d.\nGa nhap g.");
			System.out.print("Nhap su lua chon cua ban: "); 	
			c = sc.nextLine().charAt(0);
			if (c == 'b') ds[i] = new Bo();
			else if (c == 'h') ds[i] = new Heo();
			else if (c == 'd') ds[i] = new De();
			else ds[i] = new Ga();
			ds[i].read();
		}
	}

	//Hàm in danh sách các động vật
	public static void print_List(DVat ds[]){
		exception.clear();
		for(int i=0;i<ds.length;i++){
			System.out.println("\nThong tin dong vat thu "+(i+1));
			ds[i].print();
			ds[i].Keu();
		}
	}

	//Hàm chính
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so dong vat: ");
		int n = Integer.parseInt(sc.nextLine());

		DVat ds[] = new DVat[n];

		DVat.read_List(ds);
		
		DVat.print_List(ds);
	}
}