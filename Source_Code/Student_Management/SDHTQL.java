package Student_Management;
import java.util.Scanner;

public class SDHTQL {
	static Scanner sc;
	public static void clear(){
		try{
			if(System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		}catch(Exception ex) {}
	}
	public static void waitFor(){
            System.out.printf("\nAn phim N de tiep tuc chuong trinh\n");
            boolean kq = false;
            String entered = "";
            while(!kq){
                entered=sc.next();
                if((entered.equals("N"))||entered.equals("n"))
                    kq=true;
            }
      }
      public static void waitFor_endprogram(){
            System.out.printf("\nAn phim N de thoat chuong trinh\n");
            boolean kq = false;
            String entered = "";
            while(!kq){
                entered=sc.next();
                if((entered.equals("N"))||entered.equals("n"))
                    kq=true;
            }
      }
	public static void main(String[] args){
		sc = new Scanner(System.in);
		System.out.print("Danh sach cua ban co bao nhieu sinh vien: ");
		int n = sc.nextInt();
		int key = 0;
		HTQL ds[] = new HTQL[n];
		boolean readSuccess = false;
		clear();
		while(true){
			clear();
			System.out.println("_____________________________________________________");
			System.out.println("___          He thong quan ly sinh vien           ___");
			System.out.println("___    1. Nhap thong tin va diem so sinh vien     ___");                                 
			System.out.println("___    2. Xuat thong tin vua nhap                 ___");
			System.out.println("___    3. Dang ki them hoc phan                   ___");
			System.out.println("___    4. Xoa hoc phan                            ___");
			System.out.println("___    5. Diem trung binh theo tin chi            ___");
			System.out.println("___    6. Nhung sinh vien bi canh cao hoc vu      ___");
			System.out.println("___    7. Sinh vien co diem trung binh cao nhat   ___");
			System.out.println("___    8. Thoat he thong quan ly                  ___");
			System.out.println("_____________________________________________________");
			System.out.print("\nNhap su lua chon cua ban: ");
			key = sc.nextInt();
			switch(key){
				case 1:{
					clear();
					System.out.println("\nBan da chon chuc nang nhap thong tin va diem so sinh vien\n");
					for(int i=0;i<ds.length;i++){
						System.out.println("\nNhap thong tin va diem so sinh vien thu " + (i+1));
						ds[i] = new HTQL();
						ds[i].readSV();
						ds[i].readMark();
					}
					readSuccess = true;
					System.out.print("\nBan da nhap thanh cong thong tin va diem so sinh vien !\n");
					waitFor();
					break;
					
				}
				case 2:{
					clear();
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang xuat thong tin\n");
						for(int i=0;i<ds.length;i++){
							System.out.println("\nThong tin va diem so cua sinh vien " + ds[i].getfullName());
							ds[i].printSV();
						}
						readSuccess = true ;
						System.out.print("\nBan da xuat thanh cong thong tin va diem so cua sinh vien\n");
						waitFor();
						break;
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nHay nhap thong tin truoc khi xuat !\n");
						waitFor();
						break;
					}
				}
				case 3:{
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang dang ky them hoc phan\n");
						for(int i=0;i<ds.length;i++){
							System.out.println("\nVi tri thu " + (i+1) + ". " + ds[i].getfullName());
						}
						System.out.print("\nNhap vi tri cua sinh vien can dang ki them hoc phan: ");
						int k=sc.nextInt();
						ds[k-1].dangkithemHP();
						readSuccess = true;
						System.out.print("\nBan da dang ky them hoc phan thanh cong !\n");
						waitFor();
						break;
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nHay nhap thong tin truoc khi xuat !\n");
						waitFor();
						break;
					}
				}
				case 4:{
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang xoa hoc phan\n");
						for(int i=0;i<ds.length;i++){
							System.out.println("\nVi tri thu " + (i+1) + ". " + ds[i].getfullName());
						}
						System.out.print("\nNhap vi tri cua sinh vien can xoa hoc phan: ");
						int k=sc.nextInt();
						ds[k-1].deleteHP();
						readSuccess = true;
						System.out.print("\nBan da xoa hoc phan thanh cong !\n");
						waitFor();
						break;
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nHay nhap thong tin truoc khi xuat !\n");
						waitFor();
						break;
					}
				}
				case 5:{
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang tinh diem trung binh theo tin chi\n");
						System.out.print("\nDanh sach diem trung binh cua cac sinh vien\n");
						for(int i=0;i<ds.length;i++){
							System.out.println("Diem trung binh cua sinh vien " + ds[i].getfullName() + " : " + ds[i].AVG());
						}
						readSuccess = true;
						System.out.print("\nBan da tinh diem trung binh theo tin chi cua sinh vien thanh cong !\n");
						waitFor();
						break;
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nHay nhap thong tin truoc khi xuat !\n");
						waitFor();
						break;
					}
				}
				case 6:{
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang tim sinh vien bi canh cao hoc vu\n");
						System.out.print("\nDanh sach cac sinh vien bi canh cao hoc vu\n");
						for(int i=0;i<ds.length;i++){
							if(ds[i].AVG()<1)
							System.out.println("Sinh vien: " + ds[i].getfullName());	
						}
						readSuccess = true;
						System.out.print("\nBan da xuat thanh cong cac sinh vien bi canh cao hoc vu !\n");
						waitFor();
						break;
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nHay nhap thong tin truoc khi xuat !\n");
						waitFor();
						break;
					}
				}
				case 7:{
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang tim sinh vien co diem trung binh cao nhat\n");
						System.out.print("\nSinh vien co diem trung binh cao nhat\n");
						double max = ds[0].AVG();
						int k = 0;
						for(int i= 1;i<ds.length;i++){
							if(ds[i].AVG() > max){
								max = ds[i].AVG();
								k = i;
							}
						}
						System.out.print("\nTen sinh vien: " + ds[k].getfullName());
						System.out.print("\nDiem trung binh: " + ds[k].AVG());
						readSuccess = true;
						System.out.print("\nBan da xuat thanh cong sinh vien co DTB cao nhat !\n");
						waitFor();
						break;
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nHay nhap thong tin truoc khi xuat !\n");
						waitFor();
						break;
					}
				}
				case 8:{
					if(readSuccess){
						System.out.print("\nBan da chon chuc nang thoat chuong trinh\n");
						waitFor_endprogram();
						System.exit(0);
					}
					else{
						System.out.print("\nBan chua nhap thong tin va diem so sinh vien !\n");
						System.out.print("\nNeu ban muon thoat hay nhap 1 !\n");
						waitFor();
						break;
					}
				}
				default:
					System.out.println("\nKhong co chuc nang so" + (key));
			}
		}
	}
}
/*https://tracnghiem.net/cntt/500-cau-hoi-trac-nghiem-quan-tri-co-so-du-lieu-73.html*/