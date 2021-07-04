package Buoi03;
import java.util.Scanner;
import Buoi02.Diem;

public class DoanThang{

	//Khai báo thuộc tính của đoạn thẳng
	private Diem first,last;

	//Phương thức xây dựng mặc nhiên(Default constructor)
	public DoanThang(){
		first = new Diem();
		last = new Diem();
	}

	//Phương thức xây dựng có 2 điểm a và b
	public DoanThang(Diem a, Diem b){
		first = new Diem(a);
		last = new Diem(b);
	}

	//Phương thức xây dựng 4 tham số
	public DoanThang(int a, int b, int c, int d){
		first = new Diem(a,b);
		last = new Diem(c,d);
	}

	//Phương thức xây dựng sao chép(Coppy constructor)
	public DoanThang(DoanThang dt){
		first = new Diem(dt.first);
		last = new Diem(dt.last);
	}

	//Hàm lấy thông tin điểm đầu của đoạn thẳng
	public Diem laydiem_First(){
		return first;
	}

	//Hàm lấy thông tin điểm cuối của đoạn thẳng
	public Diem laydiem_Last(){
		return last;
	}

	//Hàm nhập
	public void read(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNhap toa do diem dau cua doan thang");
		first.read();
		System.out.println("\nNhap toa do diem cuoi cua doan thang");
		last.read();
	}

	//Hàm in
	public String toString(){
		return ("[ " +first+","+last+" ]");
	}

	//Hàm in có kiểu trả về
	public void tinhTien(int dx, int dy){
		first.tinhTien(dx,dy);
		last.tinhTien(dx,dy);
	}

	//Hàm tính trung điểm
	public Diem trungDiem(){
		Diem I = new Diem((first.getX()+last.getX())/2,(first.getY()+last.getY())/2);
		return I;
	}

	//Hàm tính độ dài
	public float doDai(){
		return first.khoachCach(last);
	}

	//Hàm tính góc
	public double goc(){
		double canhhuyen = Math.abs(last.getY()-first.getY()); 
		double canhgocvuong = (double)doDai();
		double kq = (double)Math.asin(canhhuyen/canhgocvuong);
		return (double)kq*(180/(double)Math.PI);
	}

	//Hàm chính
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		DoanThang d1 = new DoanThang();
		System.out.println("\nNhap toa do cua doan thang");
		d1.read();

		Diem a = new Diem(19,12);
		Diem b = new Diem(10,10);
		DoanThang d2 = new DoanThang(a,b);

		int x=6,y=3,z=1,t=1;
		DoanThang d3 = new DoanThang(x,y,z,t);

		DoanThang d4 = new DoanThang(d3);

		//d1,d2,d3,d4 lần lượt là 4 constructor đã khởi tạo trên class DoanThang	
		System.out.println("\nToa do diem d1 = " + d1.toString());
		System.out.println("\nToan do diem d2 = " + d2.toString());
		System.out.println("\nToan do diem d3 = " + d3.toString());
		System.out.println("\nToan do diem d4 = " + d4.toString());

		//Tịnh tiến đoạn thẳng d1 đi 1 độ dời (1,1)
		d1.tinhTien(1,1);
		System.out.println("\nDoan thang d1 sau khi da tinh tien new d1 = " + d1.toString());

		//Trung điểm của đoạn thẳng d1
		System.out.println("\nTrung diem cua doan thang d1 = " + d1.trungDiem().toString());

		//Độ dài của đoạn thẳng d1
		System.out.println("\nDo dai cua doan thang d1 = " + d1.doDai());

		//Góc của đoạn thẳng d1 và trục hoành
		System.out.println("\nGoc: " + d1.goc());

		System.out.print("\nDanh sach cua ban co bao nhieu doan thang: ");
		int n = sc.nextInt();

		DoanThang ds[] = new DoanThang[n];

		//Nhập danh sách
		System.out.println("\nNhap thong tin cac doan thang");
		for(int i=0;i<n;i++){
			System.out.println("\nNhap thong tin doan thang thu " + (i+1));
			ds[i] = new DoanThang();
			ds[i].read();
		}

		//In danh sách
		System.out.println("\nDanh sach thong tin cac doan thang");
		for(int i=0;i<n;i++){
			System.out.println("\nds["+(i+1)+"]: " + ds[i].toString());
		}

		//Lấy thông tin điểm đầu của đoạn thẳng d1
		System.out.println("Tung do: " + d1.laydiem_First().getX());
	}
}