import java.util.Scanner;

public class CThu extends CNguoi{
	private int soao;
	private String vitri;
	private long sobanthang;
	private String muagiai;
	private String tenclb;

	public CThu(){
		super();
		soao = 19;
		vitri = new String();
		sobanthang = 19;
		muagiai = new String();
		tenclb = new String();
	}

	public CThu(CThu ct){
		super(ct);
		soao = ct.soao;
		vitri = new String(ct.vitri);
		sobanthang = ct.sobanthang;
		muagiai = new String(ct.muagiai);
		tenclb = new String(ct.tenclb);
	}

	public void read(){
		super.read();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap so ao cau thu: ");
		soao = Integer.parseInt(sc.nextLine());
		System.out.print("\nNhap vi tri thi dau: ");
		vitri = sc.nextLine();
		System.out.print("\nNhap so ban thang: ");
		sobanthang = Long.parseLong(sc.nextLine());
		System.out.print("\nNhap mua giai: ");
		muagiai = sc.nextLine();
		System.out.print("\nNhap ten cau lac bo: ");
		tenclb = sc.nextLine();
	}

	public void print(){
		super.print();
		System.out.println("\nSo ao: "+soao);
		System.out.println("\nVi tri: "+vitri);
		System.out.println("\nSo ban thang: "+sobanthang);
		System.out.println("\nMua giai: "+muagiai);
		System.out.println("\nTen cau lac bo: "+tenclb);
	}

	public long tinhLuong(){
		long luongcoban = 7000000;
		long luongtangthem=0;
		if(vitri.equals("Thu mon"))	luongtangthem = 3000000;
		else if(vitri.equals("Hau ve"))	luongtangthem = 4000000;
		else if(vitri.equals("Trung ve")) luongtangthem = 4500000;
		else if(vitri.equals("Tien ve")) luongtangthem = 5000000;
		else if(vitri.equals("Tien dao")) luongtangthem = 7000000;
		long luongthuong = sobanthang*500000;
		long tienluong_khong_thue = luongcoban + luongtangthem + luongthuong;
		long tienluong_chinh_thuc = tienluong_khong_thue - ((tienluong_khong_thue*10)/100);
		return tienluong_chinh_thuc;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nDanh sach ban co bao nhieu nguoi: ");
		int n = Integer.parseInt(sc.nextLine());
		CNguoi ds[] = new CNguoi[n];

		//Nhap danh sach
		char c;
		for(int i=0;i<ds.length;i++){
			System.out.println("\nNhap thong tin doi tuong thu "+(i+1));
			System.out.println("Nhap 1 -> Con nguoi");
			System.out.println("Nhap 2 -> Cau thu");
			System.out.print("Nhap lua chon cua ban: ");
			c = sc.nextLine().charAt(0);
			if(c=='1')	ds[i] = new CNguoi();
			else ds[i] = new CThu();
			ds[i].read();
		}

		//In danh sach
		for(int i=0;i<ds.length;i++){
			System.out.println("\nThong tin doi tuong thu "+(i+1));
			ds[i].print();
		}

		//In danh sach tien luong cac cau thu
		for(int i=0;i<ds.length;i++){
			if(ds[i].tinhLuong() != -1){
				System.out.println("\nTien luong cau thu "+ds[i].getFullName() + ": "+ds[i].tinhLuong());
			}
		}
	
		//Cau cuoi dang update
	}
}
