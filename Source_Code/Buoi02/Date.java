package Buoi02;
import java.util.Scanner;

public class Date{

	//Khai báo thuộc tính
	private int day,month,year;

	//Phương thức xây dựng mặc nhiên(Default constructor)
	public Date(){
		day = 19;
		month = 12;
		year = 2001;
	}

	//Phương thức xây dựng có 3 tham số
	public Date(int a, int b, int c){
		day = a;
		month = b;
		year = c;
	}

	//Phương thức xây dựng sao chép(Coppy constructor)
	public Date(Date d){
		day = d.day;
		month = d.month;
		year = d.year;
	}

	//Hàm kiểm tra năm nhuận
	public boolean leapYear(){
		if((year%400==0) || (year%4==0 && year%100!=0))
			return true;
		return false;
	}
	
	//Hàm kiểm tra dữ liệu có hợp lệ hay không
	public boolean hople(){
		int arr[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(leapYear()) arr[2] = 29;
		if(day>0 && (month>0 && month<13) && year>0){
			if(day<=arr[month]){
				return true;
			}
		}
		return false;
	}

	//Hàm nhập 
	public void read(Scanner sc){
		do{
			System.out.print("\nNhap ngay: ");
			day = sc.nextInt();
			System.out.print("\nNhap thang: ");
			month = sc.nextInt();
			System.out.print("\nNhap nam: ");
			year = sc.nextInt();
			if(!hople())
				System.out.println("\nSai dinh dang, nhap lai");
		}while(!hople());
	}

	//Hàm tìm ngày hôm sau
	public Date tomorrow(){
		Date d = new Date(day,month,year);
		d.day+=1;
		if(!hople()){
			d.day = 1;
			month +=1;
			if(!hople()){
				month = 1;
				year += 1;
			}
		}
		return d;
	}

	//Hàm tìm ngày thứ n với n nhập từ bàn 
	public Date plus_n_Day(int n){
		Date d = new Date(day,month,year);
		for(int i=0;i<n;i++){
			d = d.tomorrow();
		}
		return d;
	}

	//Hàm in nhưng có kiểu trả 
	public String toString(){
		return (day+"/"+month+"/"+year);
	}

	//Hàm in
	public void print(){
		System.out.print(day+"/"+month+"/year");
	}

	//Hàm chính 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		Date use = new Date();

		use.read(sc);
		System.out.println("\nNgay thang nam vua nhap: "+use.toString());
		use = use.tomorrow();

		System.out.println("\nNgay duoc tang them 1: "+use.toString());

		System.out.print("\nNhap so ngay can cong: ");
		int n = sc.nextInt();
		use = use.plus_n_Day(n);
		
		System.out.println("\nNgay thang nam da cong them " + n + " ngay la: "+use.toString());

		System.out.print("\nDanh sach cua ban co bao nhieu ngay: ");
		n = sc.nextInt();

		Date ds[] = new Date[n];

		
		for(int i=0;i<n;i++){
			System.out.println("\nNhap thong tin ngay thu " + (i+1));
			ds[i] = new Date();
			ds[i].read(sc);
		}

		
		System.out.println("\nDanh sach vua nhap");
		for(int i=0;i<n;i++){
			System.out.println("\nds["+(i+1)+"]: "+ds[i].toString());
		}
		
	}
}
