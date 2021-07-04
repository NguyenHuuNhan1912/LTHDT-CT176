package Buoi02;
import java.util.Scanner;
import java.lang.Math;

public class Diem {

	//Khai báo thuộc tính
	private int x,y;

	//Phương thức xây dựng mặc nhiên(Default constructor)
	public Diem(){
		x=0;
		y=0;
	}

	//Phương thức xây dựng có 2 tham số
	public Diem(int a, int b){
		x=a;
		y=b;
	}

	//Phương thức xây dựng sao chép(Coppy constructor)
	public Diem(Diem k){
		x=k.x;
		y=k.y;
	}

	//Hàm nhập
	public void read(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap tung do x: ");
		x = sc.nextInt();
		System.out.print("\nNhap hoanh do y: ");
		y = sc.nextInt();
	}

	//Hàm in
	public void print(){
		System.out.println("("+x+","+y+")");
	}

	//Hàm in có kiểu trả về 
	public String toString(){
		return ("("+x+","+y+")");
	}

	//Hàm tịnh tiến thêm 1 đơn vị 
	public void tinhTien(int dx, int dy){
		x += dx;
		y += dy;
	}

	//Hàm lấy giá trị tung độ x 
	public int getX(){
		return x;
	}

	//Hàm lấy giá trị hoành độ y 
	public int getY(){
		return y;
	}

	//Hàm tính khoảng cách từ điểm B đến gốc tọa độ O
	public float khoachCach(){
		return (float)Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	}

	//Hàm tính khoảng cách từ điểm A đến điểm B
	public float khoachCach(Diem A){
		return (float)Math.sqrt(Math.pow(x-A.x,2)+Math.pow(y-A.y,2));	
	}

	//Hàm 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Diem A = new Diem(19,12);
		System.out.println("\nDiem A vua duoc khoi tao A = " + A.toString());

		Diem B = new Diem();
		System.out.println("\nNhap diem B");
		B.read();
		System.out.println("\nDiem B vua nhap B = "+B.toString());

		Diem C = new Diem(B);
		System.out.println("\nDiem C vua sao chep tu B: C = "+C.toString());

		Diem D = new Diem(-B.getX(),-B.getY());
		System.out.println("\nDiem D doi xung voi C: D = "+D.toString());

		System.out.println("\nKhoang cach tu diem B den tam O: " + B.khoachCach());
		System.out.println("\nKhoang cach tu diem A den diem B:" +B.khoachCach(A));

		System.out.print("\nDanh sach cua ban co bao nhieu diem: ");
		int n = sc.nextInt();
		
		Diem ds[] = new Diem[n];

		System.out.println("\nNhap thong tin cac diem trong danh sach");
		for(int i=0;i<n;i++){
			System.out.println("\nNhap thong tin diem thu " + (i+1));
			ds[i] = new Diem();
			ds[i].read();
		}

		System.out.println("\nThong tin cac diem trong danh sach");
		for(int i=0;i<n;i++){
			System.out.println("\nThong tin diem thu " + (i+1));
			System.out.println("\nds["+(i+1)+"]: "+ds[i]);
		}

		int sumX=0;
		for(int i=0;i<n;i++){
			sumX += ds[i].getX();
		}
		
		System.out.println("\nTong tung do cac diem trong danh sach: " + sumX);
	}
	
}
