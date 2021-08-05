package Buoi02;
import java.util.Scanner;

public class PhanSo{
	private int tuso,mauso;
	//Hàm xây dựng mặc nhiên không tham số
	public PhanSo(){
		tuso = 0;
		mauso = 0;
	}

	//Hàm xây dựng có 2 tham số 
	public PhanSo(int a, int b){
		tuso = a;
		mauso = b;
	}

	//Hàm xây dựng sao chép
	public PhanSo(PhanSo k){
		tuso = k.tuso;
		mauso = k.mauso;
	}

	//Hàm nhập phân số
	public void read(Scanner sc){
		System.out.print("\nNhap tu so: ");
		tuso = sc.nextInt();
		System.out.print("\nNhap mau so: ");
		mauso = sc.nextInt();
	}

	//Hàm in phân số
	public void print(){
		System.out.println(tuso+"/"+mauso);
	}

	//Hàm in phân số có kiểu trả về (Kiểu String)
	 public String toString(){
            String s = Integer.toString(tuSo);
            if(tuSo==0) return "0";
              else if(mauSo==1) return s; 
                 else if(tuSo==mauSo) return "1";
                    else if(tuSo*mauSo<0) return((-tuSo)+"/"+Math.abs(mauSo));
                       else return(Math.abs(tuSo)+"/"+Math.abs(mauSo));
        }
	//Hàm tìm ước chung lớn nhất
	public int gcd(int a, int b){
		int temp;
		while(b!=0){
			temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}

	//Hàm rút gọn phân số
	public PhanSo rutGon(){
		PhanSo z = new PhanSo(tuso,mauso);
		int UCLN = z.gcd(tuso,mauso);
		z.tuso = z.tuso / UCLN;
		z.mauso = z.mauso / UCLN;
		return z;
	}

	//Hàm cộng 2 phân số có 2 cách tương ứng 2 hàm (còn nhiều cách khác nhưng 2 cách trình bày bên dưới phổ biến nhất)
	public PhanSo congPS(PhanSo a, PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = a.tuso * b.mauso + a.mauso*b.tuso;
		k.mauso = a.mauso*b.mauso;
		return k.rutGon();
	}
	public PhanSo congPS(PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = tuso * b.mauso + mauso*b.tuso;
		k.mauso = mauso*b.mauso;
		return k.rutGon();
	}

	//Hàm nhân 2 phân số
	public PhanSo nhanPS(PhanSo a, PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = a.tuso * b.tuso;
		k.mauso = a.mauso * b.mauso;
		return k.rutGon();
	}
	public PhanSo nhanPS(PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = tuso*b.tuso;
		k.mauso = mauso*b.mauso;
		return k.rutGon();
	}

	//Hàm trừ  phân số
	public PhanSo truPS(PhanSo a, PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = a.tuso * b.mauso - a.mauso*b.tuso;
		k.mauso = a.mauso*b.mauso;
		return k.rutGon();
	}
	public PhanSo truPS(PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = tuso * b.mauso - mauso*b.tuso;
		k.mauso = mauso*b.mauso;
		return k.rutGon();
	}
	//Hàm chia 2 phân số
	public PhanSo chiaPS(PhanSo a, PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = a.tuso * b.mauso;
		k.mauso = a.mauso * b.tuso;
		return k.rutGon();
	}
	public PhanSo chiaPS(PhanSo b){
		PhanSo k = new PhanSo();
		k.tuso = tuso * b.mauso;
		k.mauso = mauso * b.tuso;
		return k.rutGon();
	}

	//Hàm nghịch đảo phân số cũng có 2 hàm (Lưu ý sử dụng hàm nào cũng được chọn 1 trong 2)
	public PhanSo nghichDao(PhanSo a){
		PhanSo k = new PhanSo();
		k.tuso = a.mauso;
		k.mauso = a.tuso;
		return k.rutGon();
	}
	public PhanSo nghichDao(){
		PhanSo k = new PhanSo(mauso,tuso);
		return k.rutGon();
	}

	//Hàm tính giá trị của phân số
	public float giatriPS(){
		return (float)tuso/mauso;
	}

	//Hàm lấy tử số
	public int getTS(){
		return tuso;
	}

	//Hàm lấy mẫu số
	public int getMS(){
		return mauso;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PhanSo a = new PhanSo();
		PhanSo b = new PhanSo();
		PhanSo c = new PhanSo(19,12);
		PhanSo d = new PhanSo(c);
		PhanSo kq = new PhanSo();

		System.out.println("Nhap phan so a");
		a.read(sc);

		System.out.println("\nNhap phan so b");
		b.read(sc);

		System.out.println("\nPhan so a = " + a.toString());
		System.out.println("\nPhan so b = " + b.toString());
		System.out.println("\nPhan so duoc gan gia tri ban dau c = " + c.toString());
		System.out.println("\nPhan so vua coppy tu phan so c, d = " + d.toString());


		System.out.println("\n- Phan so nghich dao cua a la: " + a.nghichDao().toString());		

		System.out.println("\n- Gia tri phan so a: " + a.giatriPS());

		System.out.println("\n- Tong hai phan so: " + a.congPS(b).toString());
		System.out.println("\n- Hieu hai phan so: " + a.truPS(b).toString());
		System.out.println("\n- Tich hai phan so: " + a.nhanPS(b).toString());
		System.out.println("\n- Thuong hai phan so: " + a.chiaPS(b).toString());

		// kq = kq.congPS(a,b);
		// System.out.println("\n- Tong hai phan so: " + kq.toString());
		// kq = kq.truPS(a,b);
		// System.out.println("\n- Hieu hai phan so: " + kq.toString());
		// kq = kq.nhanPS(a,b);
		// System.out.println("\n- Tich hai phan so: " + kq.toString());
		// kq = kq.chiaPS(a,b);
		// System.out.println("\n- Thuong hai phan so: " + kq.toString());


		System.out.print("\nDanh sach cua ban co bao nhieu phan so: ");
		int n = sc.nextInt();

		PhanSo ds[] = new PhanSo[n];

		//Nhập danh sách
		System.out.println("\nNhap thong tin cac phan so");
		for(int i=0;i<ds.length;i++){
			System.out.println("\nNhap thong tin phan so thu " + (i+1));
			ds[i] = new PhanSo();
			ds[i].read(sc);
		}

		//In danh sách
		System.out.println("\nThong tin cac phan so");
		for(int i=0;i<n;i++){
			System.out.println("\nds["+(i+1)+"]: " + ds[i].toString());
		}

		//Tính tổng các tử số của danh sách
		int total = 0;
		for(int i=0;i<ds.length;i++){
			total += ds[i].getTS();
		}	
		
		System.out.println("\nTong tu so cua danh sach tren la: " + total);
	}
}
