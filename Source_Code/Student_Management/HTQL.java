package Student_Management;
import Buoi02.*;
import java.util.Scanner;

public class HTQL {
	//Khai bao thuoc tinh
	private final int max = 100;
	private String fullname;
	private String mssv;
	private Date date;
	private String major;
	private int drl;
	private int shp;
	private String tenhp[],diemhp[];
	private int stc[];
	//Constructor 1
	public HTQL(){
		fullname = new String();
		mssv = new String();
		date = new Date();
		major = new String();
		drl = 0;
		shp = 0;
		tenhp =  new String[max];
		diemhp = new String[max];
		stc = new int[max];
	}
	//Constructor xay dung sao chep
	public HTQL(HTQL st){
		fullname = new String(st.fullname);
		mssv = new String(st.mssv);
		date = new Date(st.date);
		major = new String(st.major);
		drl = st.drl;
		shp = st.shp;
		tenhp =  new String[max];
		diemhp = new String[max];
		stc = new int[max];
		for(int i=0;i<shp;i++){
			tenhp[i] = new String(st.tenhp[i]);
			diemhp[i] = new String(st.diemhp[i]);
			stc[i] = st.stc[i];
		}
	}
	//Ham nhap thong tin ca nhan cua sinh vien
	public void readSV(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap ho va ten: ");
		fullname = sc.nextLine();
		System.out.print("\nNhap mssv: ");
		mssv = sc.nextLine();
		System.out.print("\nNhap Date\n");
		date.readDate();
		System.out.print("\nNhap chuyen nganh: ");
		major = sc.nextLine();
		System.out.print("\nNhap diem ren luyen: ");
		drl = Integer.parseInt(sc.nextLine());
	}
	public void readMark(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nSinh vien " + fullname + " hoc bao nhieu HP: ");
		shp = Integer.parseInt(sc.nextLine());
		for(int i=0;i<shp;i++){
			System.out.print("\nNhap ten hoc phan thu " + (i+1) + " : ");
			tenhp[i] = sc.nextLine();
			System.out.print("\nNhap diem chu cua hoc phan " + tenhp[i] + " : ");
			diemhp[i] = sc.nextLine();
			System.out.print("\nNhap STC cua hoc phan " + tenhp[i] + " : ");
			stc[i] = Integer.parseInt(sc.nextLine());
		}
	}
	public String getfullName(){
		return fullname;
	}
	public void printSV(){
		System.out.println("\nHo ten sinh vien: " + fullname);
		System.out.println("MSSV: " + mssv);
		System.out.println("Ngay thang nam sinh: " + date.toString());
		System.out.println("Chuyen nganh: " + major);
		System.out.println("Diem ren luyen: " + drl);
		System.out.println("Sinh vien " + fullname + " hoc " + shp + " hoc phan");
		for(int i=0;i<shp;i++){
			System.out.println("\nThong tin ve hoc phan thu " + (i+1));
			System.out.println("Ten hp: " + tenhp[i]);
			System.out.println("Diem: " + diemhp[i]);
			System.out.println("So tin chi: " + stc[i]);
		}
	}
	public void dangkithemHP(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao so luong hoc phan muon dang ky them: ");
		int n = Integer.parseInt(sc.nextLine());
		int k = shp;
		shp = shp + n;
		for (int i = k; i < shp; i++){
			System.out.print("Nhap hoc phan thu " + (i+1) + " can dang ki: ");
			tenhp[i] = sc.nextLine();
			System.out.print("\nNhap diem chu cua hoc phan " + tenhp[i] + " : ");
			diemhp[i] = sc.nextLine();
			System.out.print("\nNhap STC cua hoc phan " + tenhp[i] + " : ");
			stc[i] = Integer.parseInt(sc.nextLine());
		}
	}
	public String getName(){
		String getname = new String(fullname);
		getname = getname.trim();
		return getname.substring(getname.lastIndexOf(" ")+1);
	}
	public void deleteHP() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap ten hoc phan can xoa: ");
		String ten = new String();
		ten = sc.nextLine();
		int key=-1;
		for(int i=0;i<shp;i++) {
			if(tenhp[i].equals(ten)) {
				key=i;
				break;
			}
		}
		if(key!=-1) {
			for(int i=key;i<shp;i++) {
				tenhp[i] = tenhp[i+1];
				diemhp[i] = diemhp[i+1];
				stc[i] = stc[i+1];
			}
			shp-=1;
		}
	}
	public double AVG() {
		double total = 0;
		int count = 0;
		for(int i = 0;i<shp;i++) {
			count += stc[i];
			if(diemhp[i].equals("A"))	total = total + (4*stc[i]);
			else if(diemhp[i].equals("B+"))	total += (3.5*stc[i]);
			else if(diemhp[i].equals("B"))	total += 3*stc[i];
			else if(diemhp[i].equals("C+"))	total +=2.5*stc[i];
			else if(diemhp[i].equals("C"))	total +=2*stc[i];
			else if(diemhp[i].equals("D+"))	total +=1.5*stc[i];
			else if(diemhp[i].equals("D"))	total +=stc[i];
			else if(diemhp[i].equals("F"))	total +=0;
		}
		return (double)total/count;
	}
}
