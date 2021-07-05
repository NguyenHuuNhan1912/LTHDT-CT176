import java.util.Scanner;

public class CNguoi{

	//Thuoc tinh cua doi tuong con nguoi
	private String id;
	private String hoten;
	private String ngay;
	private char phai;

	//Default constructor
	public CNguoi(){
		id = new String();
		hoten = new String();
		ngay = new String();
		phai = 'M';
	}

	//Coppy constructor
	public CNguoi(CNguoi cn){
		id = new String(cn.id);
		hoten = new String(cn.hoten);
		ngay = new String(cn.ngay);
		phai = cn.phai;
	}

	//Ham nhap
	public void read(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap so chung minh nhan dan: ");
		id = sc.nextLine();
		System.out.print("\nNhap ho va ten: ");
		hoten = sc.nextLine();
		System.out.print("\nNhap ngay thang nam sinh: ");
		ngay = sc.nextLine();
		System.out.print("\nNhap phai(M -> Nam, F -> Nu): ");
		phai = sc.nextLine().charAt(0);
	}

	//Ham in
	public void print(){
		System.out.println("\nSo CMND: "+id);
		System.out.println("\nHo va ten: "+hoten);
		System.out.println("\nNgay thang nam sinh: "+ngay);
		if(phai=='M') System.out.println("\nPhai: nam");
		else System.out.println("\nPhai: nu");
	}

	public long tinhLuong(){
		return -1;
	}

	public String getFullName(){
		return hoten;
	}
	public int get_Age(){
		String date = new String(ngay);
		date = date.trim();
		date = date.substring(date.lastIndexOf("-")+1);
		return Integer.parseInt(date);
	}
	//Main
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		CNguoi c1 = new CNguoi();
		System.out.println("\nNhap thong tin cho doi tuong c1");
		c1.read();
		System.out.println("\nThong tin doi tuong vua nhap");
		c1.print();
		CNguoi c2 = new CNguoi(c1);
		System.out.println("\nDoi tuong c2 vua coppy tu c1");
		c2.print();
	}
}
