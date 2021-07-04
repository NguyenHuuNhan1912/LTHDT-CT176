package Buoi04;
import java.util.Scanner;
import Buoi03.SinhVien;
import Exception.*;
public class SinhVienCNTT extends SinhVien{

	//Thêm các thuộc tính
	private String user;	
	private String password;
	private String email;

	//Default constructor
	public SinhVienCNTT(){
		super();
		user = new String();
		password = new String();
		email = new String();
	}

	//Coppy constructor
	public SinhVienCNTT(SinhVienCNTT sv){
		super((SinhVien)sv);
		user = new String(sv.user);
		password = new String(sv.password);
		email = new String(sv.email);
	}

	//Nhập thông tin sinh viên CNTT 
	public void read(){
		super.read();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap tai khoan: ");
		user=sc.nextLine();
		System.out.print("\nNhap mat khau: ");
		password=sc.nextLine();
		System.out.print("\nNhap dia chi email: ");
		email=sc.nextLine();
	}

	//In thông tin sinh viên CNTT 
	public void print(){
		super.print();
		System.out.println("\nTen tai khoan: "+user);
		System.out.println("\nMat khau: "+password);
		System.out.println("\nDia chi email: "+email);
	}

	//Hàm đổi mật khẩu 
	public void doimat_Khau(String newpass){
		password = new String(newpass);
	}

	//Hàm nhập danh sách sinh viên(Bao gồm sinh viên khoa CNTT hoặc khoa khác) 
	public static void read_List(SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		char c;
		for(int i=0;i<ds.length;i++){
			System.out.println("\n---Sinh vien thu "+(i+1)+" thuoc khoa nao");
			System.out.println("\nNhap 1 ---> Khoa cong nghe thong tin");
			System.out.println("\nNhap 2 ---> Khoa khac");
			System.out.print("\n---Nhap lua chon cua ban: ");
			c = sc.nextLine().charAt(0);
			if(c=='1') ds[i] = new SinhVienCNTT();
			else ds[i] = new SinhVien();
			ds[i].read();
			exception.clear();
		}
	}

	//Hàm in danh sách sinh viên(Bao gồm sinh viên khoa CNTT hoặc khoa khác) 
	public static void print_List(SinhVien ds[]){
		for(int i=0;i<ds.length;i++){
			System.out.println("\n--Thong tin sinh vien thu "+(i+1));
			ds[i].print();
		}
	}

	//Hàm lấy email
	public String get_Email(){
		return email;
	}

	//Hàm lấy tên tài khoản
	public String get_User(){
		return user;
	}  

	//Hàm lấy password 
	public String get_passWord(){
		return password;
	}

	//Hàm chính 
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in);

		System.out.print("\nDanh sach ban co bao nhieu sinh vien: ");
		int n = Integer.parseInt(sc.nextLine());
		SinhVien ds[] = new SinhVien[n];

		//Nhập danh sách 
		System.out.println("\nNhap thong tin cac sinh vien co trong danh sach");
		SinhVienCNTT.read_List(ds);

		//In danh sách
		System.out.println("\nThong tin cac sinh vien vua nhap");
		SinhVienCNTT.print_List(ds);

		System.out.print("\nNhap email cua sinh vien can tim kiem: ");
		String read_email = sc.nextLine();

		//In thông tin sinh viên có email đã nhập 
		for(int i=0;i<ds.length;i++){
			if(ds[i].get_Email().equals(read_email)){
				System.out.println("\nThong tin sinh vien can tim");
				System.out.println("\nTen sinh vien: " + ds[i].get_fullName());
				System.out.println("\nGmail: " + ds[i].get_Email());
				System.out.println("\nTen tai khoan elcit: " + ds[i].get_User());
				System.out.println("\nMat khau tai khoan: " + ds[i].get_passWord());
				System.out.println("\nDiem trung binh tich luy trong hoc ki: " + ds[i].tich_Luy());
				break;
			}
		}
		
	}
}