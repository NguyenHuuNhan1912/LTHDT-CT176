package Buoi03;
import Buoi02.Date;
import java.util.Scanner;

public class SinhVien{

	//Khai báo thuộc tính 
	private String MSSV;
	private String fullname;
	private Date ngaysinh;
	private int sl;
	private String tenhp[];
	private String diemhp[];
	private int sotc[];
	private final int MAX = 50;

	//Default constructor 
	public SinhVien(){
		MSSV = new String();
		fullname = new String();
		ngaysinh = new Date();
		sl = 0;
		tenhp = new String[MAX];
		diemhp = new String[MAX];
		sotc = new int[MAX];
	}

	//Coppy Constructor
	public SinhVien(SinhVien sv){
		MSSV = new String(sv.MSSV);
		fullname = new String(sv.fullname);
		ngaysinh = new Date(sv.ngaysinh);
		sl = sv.sl;
		tenhp = new String[MAX];
		diemhp = new String[MAX];
		sotc = new int[MAX];

		for(int i=0;i<sv.sl;i++){
			tenhp[i] = new String(sv.tenhp[i]);
			diemhp[i] = new String(sv.diemhp[i]);
			sotc[i] = sv.sotc[i];
		}

	}	

	//Hàm nhập thông tin sinh viên
	public void read(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap mssv: ");
		MSSV = sc.nextLine();
		System.out.print("\nNhap ten sinh vien: ");
		fullname = sc.nextLine();
		System.out.println("\nNhap ngay thang nam sinh");
		ngaysinh.read(sc);
		System.out.print("\nHoc ki nay sinh vien " + fullname + " hoc bao nhieu hoc phan: ");
		sl = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<sl;i++){
			System.out.println("\nNhap thong tin hoc phan thu " + (i+1));
			System.out.print("\nNhap ten hoc phan thu " + (i+1) + ": ");
			tenhp[i] = sc.nextLine();
			System.out.print("\nNhap diem(Diem chu) cua hoc phan thu " + tenhp[i] + ": ");
			diemhp[i] = sc.nextLine();
			System.out.print("\nNhap so tin chi cua hoc phan " + tenhp[i] + ": ");
			sotc[i] = check_exception(sc);
		}

	}

	//Hàm in thông tin sinh viên
	public void print(){
		System.out.println("\nTen sinh vien: "+fullname);
		System.out.println("\nMSSV: "+MSSV);
		System.out.println("\nNgay thang nam sinh: "+ngaysinh.toString());
		System.out.println("\nHoc ki nay sinh vien " + fullname + " hoc " + sl + " hoc phan");
		for(int i=0;i<sl;i++){
			System.out.println("\nThong tin hoc phan thu " + (i+1));
			System.out.println("\nTen hoc phan: "+tenhp[i]);
			System.out.println("\nDiem hoc phan " + tenhp[i] + ": " + diemhp[i]);
			System.out.println("\nSo tin chi hoc phan " + tenhp[i] + ": " + sotc[i]);
		}
	}

	//Hàm xử lí ngoại lệ
	public static int check_exception(Scanner sc){
		String s;
		int n;
		do{	
			s = sc.nextLine();
			try{n = Integer.parseInt(s);}
			catch(NumberFormatException e){
				n = Integer.MAX_VALUE;
				System.out.print("\nSai dinh dang, nhap lai: ");
			}
		}while(n==Integer.MAX_VALUE);
		return n;
	}

	//Hàm xóa màn hình 
	public static void clear(){
		try{
			if(System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		}catch(Exception ex) {}
	}

	//Thêm học phần vào cuối danh sách 
	public void addLast_HP(String tenhp1, int stc, String diem){
		tenhp[sl] = new String(tenhp1);
		diemhp[sl] = new String(diem);
		sotc[sl] = stc;
		sl++;
	}

	//Thêm n học phần vào cuối danh sách
	public void dangkythem_HP(Scanner sc){
		System.out.print("Nhap vao so luong hoc phan muon dang ky them: ");
		int n = Integer.parseInt(sc.nextLine());
		int k = sl;
		sl = sl + n;
		for (int i = k; i < sl; i++){
			System.out.print("Nhap hoc phan thu " + (i+1) + " can dang ki: ");
			tenhp[i] = sc.nextLine();
			System.out.print("\nNhap diem chu cua hoc phan " + tenhp[i] + " : ");
			diemhp[i] = sc.nextLine();
			System.out.print("\nNhap STC cua hoc phan " + tenhp[i] + " : ");
			sotc[i] = Integer.parseInt(sc.nextLine());
		}
	}

	//Hàm xóa học phần
	public void delete_HP(String key){
		int pos = -1;
		for(int i=0;i<sl;i++){
			if(tenhp[i].equals(key)){
				pos = i;
				break;
			}
		}
		if(pos!=-1){
			for(int i=pos;i<sl;i++){
				tenhp[i] = tenhp[i+1];
				diemhp[i] = diemhp[i+1];
				sotc[i] = sotc[i+1];
				sl--;
			}
		}
	}

	//Hàm đổi điểm chữ sang điểm số (theo thang điểm 4)
	public double doi_Diem(String s){
		if(s.equals("A"))	return 4;
		else if(s.equals("B+"))	return 3.5;
		else if(s.equals("B")) return 3;
		else if(s.equals("C+"))	return 2.5;
		else if(s.equals("C")) return 2;
		else if(s.equals("D+")) return 1.5;
		else if(s.equals("D")) return 1;
		else return 0;
	}

	//Hàm tính điểm trung bình tích lũy 
	public double tich_Luy() {
		double total = 0;
		int count = 0;
		String s;
		for(int i = 0;i<sl;i++) {
			count += sotc[i];
			s = new String(diemhp[i]);
			total += (sotc[i] * doi_Diem(s));
		}
		return (double)total/count;
	}

	//Hàm lấy tên
	public String get_Name(){
		String get_Name = new String(fullname);
		get_Name = get_Name.trim();
		return get_Name.substring(get_Name.lastIndexOf(" ")+1);
	}

	//Hàm lấy họ tên 
	public String get_fullName(){
		return fullname;
	}

	//Thuật toán sắp xếp chọn, sắp xếp tên theo Alphabet của tên 
	public static void selection_Sort(SinhVien ds[]){
		for(int i=0;i<ds.length-1;i++){
			for(int j=i+1;j<ds.length;j++){
				if(ds[i].get_Name().compareTo(ds[j].get_Name())>0){
					SinhVien t = ds[i];
							ds[i] = ds[j];
							ds[j]=t;
				}
			}
		}
	}

	//Hàm nhập thông tin toàn bộ sinh viên
	public static void read_List(SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<ds.length;i++){
			System.out.println("\nNhap thong tin sinh vien thu " + (i+1));
			ds[i] = new SinhVien();
			ds[i].read();
		}
	}

	//Hàm in thông tin toàn bộ sinh viên 
	public static void print_List(SinhVien ds[]){
		for(int i=0;i<ds.length;i++){
			System.out.println("\n--Thong tin sinh vien thu " + (i+1));
			ds[i].print();  
		}
	}

	//In thông tin sinh viên theo họ tên đã được sắp xếp 
	public static void print_Sort_Name(SinhVien ds[]){
		for(int i=0;i<ds.length;i++){
			System.out.println((i+1)+". " + ds[i].get_fullName());
		}
	}

	//Hàm in thông tin sinh viên bị cảnh cáo học vụ 
	public static void print_Warning_Study(SinhVien ds[]){
		for(int i=0;i<ds.length;i++){
			if(ds[i].tich_Luy() <  1.0){
				System.out.println((i+1)+". "+ds[i].get_fullName());
			}
		}
	}

	//Hàm in kết quả điểm tích lũy của tất cả sinh viên
	public static void print_KQ_DiemTL(SinhVien ds[]){
		for(int i=0;i<ds.length;i++){
			System.out.println((i+1)+". "+ds[i].get_fullName()+" "+ds[i].tich_Luy());
		}
	}

	//Hàm lấy email, user, password sẽ được giải đáp trong buổi 4(Kế thừa trong java)
	public String get_Email(){
		return "";
	}
	public String get_User(){
		return "";
	}
	public String get_passWord(){
		return "";
	}

	//Hàm chính
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		SinhVien Nhan = new SinhVien();

		Nhan.read(sc);
		Nhan.addLast_HP("LTHDT",3,"A");
		System.out.println("\nThong tin cua sinh vien Nhan");
		Nhan.print();

		Nhan.dangkythem_HP(sc);
		System.out.println("\nUPDATE 1");
		Nhan.print();

		System.out.print("\nNhap ten hoc phan can xoa: ");
		String name_delete = sc.nextLine();
		Nhan.delete_HP(name_delete);
		System.out.println("\nUPDATE 2");
		Nhan.print();
		
		System.out.print("\nDanh sach cua ban co bao nhieu sinh vien: ");
		int n = Integer.parseInt(sc.nextLine());
		SinhVien ds[] = new SinhVien[n];

		/*
		Note 1: Hàm tỉnh có thể gọi hàm tỉnh và không tỉnh
		Note 2: Hàm không tỉnh chỉ được phép gọi hàm không tỉnh 
		Note 3: Cách gọi một hàm không tỉnh ---> Gọi thông qua đối tượng hoặc tên lớp
		Note 4: Cách gọi một hàm tỉnh ---> Chỉ được gọi thông qua đối tượng
		*/

		//Nhập danh sách sinh viên ---> gọi theo note 3 
		System.out.println("\nNhap thong tin cac sinh vien trong danh sach");
		SinhVien.read_List(ds);

		/*Nhập danh sách sinh viên ---> gọi theo note 2 
		read_List();*/

		//In danh sách tất cả sinh viên 
		System.out.println("\nThong tin cac sinh vien vua nhap");
		clear();
		SinhVien.print_List(ds);

		//Danh sách sinh viên sắp xếp theo tên
		System.out.println("\nDanh sach da sap xep theo ten");
		SinhVien.selection_Sort(ds);
		SinhVien.print_Sort_Name(ds);

		//Danh sách điểm tích lũy sinh 
		System.out.println("\nDanh sach diem tich luy cua toan bo sinh vien");
		SinhVien.print_KQ_DiemTL(ds);

		//Danh sách sinh viên bị cảnh cáo học vụ 
		System.out.println("\nDanh sach sinh vien bi canh cao hoc vu");
		SinhVien.print_Warning_Study(ds);

	}
}