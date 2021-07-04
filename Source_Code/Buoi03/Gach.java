package Buoi03;
import Buoi02.Date;
import java.util.Scanner;

public class Gach{

	//Khai báo thuộc tính của hộp gạch
	private String maso;
	private String color;
	private int sl,chieudai,chieungang;
	private long giaban;
	private Date ngaysx;
	
	//Hàm xây dựng mặc nhiên(Default constructor)
	public Gach() {
		maso = new String();
		color = new String();
		ngaysx = new Date();
		sl=0;
		chieudai=0;
		chieungang=0;
		giaban=0;
	}

	//Hàm xây dựng sao chép(Coppy constructor)
	public Gach(Gach k) {
		maso = new String(k.maso);
		color = new String(k.color);
		ngaysx = new Date(k.ngaysx);
		sl=k.sl;
		chieudai=k.chieudai;
		chieungang = k.chieungang;
		giaban = k.giaban;
	}

	//Hàm nhập thông tin
	public void read(Scanner sc){
		System.out.print("\nNhap ma so cua hop gach: ");
		maso = sc.nextLine();
		System.out.print("\nNhap mau cua hop gach: ");
		color = sc.nextLine();
		System.out.println("\nNhap ngay san xuat cua hop gach");
		ngaysx.read(sc);
		System.out.print("\nNhap so luong vien gach trong hop gach: ");
		sl = sc.nextInt();
		System.out.print("\nNhap chieu dai vien gach: ");
		chieudai = sc.nextInt();
		System.out.print("\nNhap chieu ngang vien gach: ");
		chieungang = sc.nextInt();
		System.out.print("\nNhap gia ban cua hop gach: ");
		giaban = sc.nextLong();
		sc.nextLine();
	}

	//Hàm xuất thông tin
	public void print() {
		System.out.println("\nMa so: " + maso);
		System.out.println("\nMau: " + color);
		System.out.println("\nSo luong vien gach trong hop gach: " + sl);
		System.out.println("\nChieu dai cua 1 vien gach: " + chieudai);
		System.out.println("\nChieu chieu ngang cua 1 vien gach: " + chieungang);
		System.out.println("\nGia ban cua hop gach: " + giaban);
		System.out.println("\nNgay sx cua hop gach: " + ngaysx.toString());
	} 

	//Hàm tính giá bán lẻ
	public double giabanLe() {
		return (double)giaban/(sl*1.2);
	}

	//Hàm tính diện tích
	public int dienTich() {
		return chieudai*chieungang*sl;
	}

	//Hàm tính số lượng hợp
	public int soLuongHop(int D, int N) {
		int svn = N / chieungang;
		if (N % chieungang != 0) svn++;
		int svd = D / chieudai;
		if (D / chieudai != 0) svd++;
		int sv = svn * svd;
		int sohop = sv / sl;
		if (sv % sl != 0) sohop++;
		return sohop;
	}

	//Hàm min
	public double gachmin() {
		return (double)giaban/(chieudai*chieungang);
	}

	//Hàm lấy giá
	public long layGia() {
		return (long)giaban;
	}

	//Trả về chỉ số của phần tử có giá trị thấp nhất(chỉ số loại gạch lót nền thấp nhất)
	public static int return_chiso_min(Gach ds[]){
		double min = ds[0].gachmin();
		int k = 0;
		for(int i=1;i<ds.length;i++) {
			if(ds[i].gachmin()<min) {
				min = ds[i].gachmin();
				k = i;
			}
		}
		return k;
	}

	//Hàm tính chi phí 
	public static long chi_Phi(Gach ds[]){
		long min = Long.MAX_VALUE;
		for (int i=0; i<ds.length; i++) {
			long t = ds[i].soLuongHop(2000,500);
			ds[i].layGia();
			if (t < min)
				min = t;
		}
		return min;
	}

	//Hàm chính 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nDanh sach cua ban co bao nhieu loai gach: ");
		int n = Integer.parseInt(sc.nextLine());
		Gach ds[] = new Gach[n];

		//Nhập danh sách
		System.out.println("\nNhap thong tin cac hop gach co trong danh sach");
		for(int i=0;i<ds.length;i++){
			System.out.println("\nNhap thong tin hop gach thu "+(i+1));
			ds[i] = new Gach();
			ds[i].read(sc);
		}

		//In danh sách
		System.out.println("\nThong tin cac hop gach vua nhap");
		for(int i=0;i<ds.length;i++){
			System.out.println("\nThong tin hop gach thu "+(i+1));
			ds[i].print();
		}

		//Loại gạch có chi phí lót nền thấp nhất
		System.out.print("\nThong tin loai gach co chi phi nen lot thap nhat\n");
		ds[Gach.return_chiso_min(ds)].print();

		/*Tính ra chi phí mua gạch khi ta lót 1 diện tích có chiều ngang là 5m
		và chiều dài là 20m khi ta mua từng loại gạch trong danh sách trên*/
		System.out.print("\nSo tien it nhat cho 1 dien tich dai 20m va ngang 5m la: " + Gach.chi_Phi(ds));
	}
}