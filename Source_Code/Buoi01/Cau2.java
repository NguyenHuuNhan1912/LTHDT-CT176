package Buoi01;
import java.util.Scanner;

public class Cau2{

	//Hàm kiểm tra ngoại lệ
	public static float check_Exception(Scanner sc){
		String s;
		float n;
		do
		{
			s = sc.nextLine();
			try{n = Float.parseFloat(s);}
			catch(NumberFormatException e){
				n = Float.MAX_VALUE;
				//Gán cho n bằng giá trị lớn nhất của kiểu số thực(kiểu float).
				System.out.print("\nSai dinh dang, nhap lai: ");
			}
		}while(n==Float.MAX_VALUE);
		return n;
	}

	//Hàm nhập mảng các số (Hàm tĩnh)
	public static void Read_List(float[] arr, Scanner sc){
		for(int i=0;i<arr.length;i++){
			System.out.print("\nNhap so thu "+(i+1)+": ");
			arr[i] = check_Exception(sc);
		}
	}

	//Hàm in mảng các số thực(Hàm tĩnh)
	public static void Print_List(float[] arr, Scanner sc){
		for(int i=0;i<arr.length;i++){
			System.out.println("arr["+(i+1)+"]: "+arr[i]);
		}
	}

	//Hàm tìm số lớn nhất trong mảng
	public static float MAX(float[] arr){
		float max = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}

	//Hàm tìm số nhỏ nhất trong mảng(Hàm tĩnh)
	public static float MIN(float[] arr){
		float min = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min) min = arr[i];
		}
		return min;
	}

	//Hàm tìm số nhỏ nhất trong mảng(Hàm tĩnh)
	public static float SUM(float arr[]){
		float total = 0;
		for(int i=0;i<arr.length;i++){
			total += arr[i];
		}
		return total;
	}
	
	//Hàm chính 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("\nDanh sach ban co bao nhieu so thuc: ");
		int n = Integer.parseInt(sc.nextLine());

		float[] arr = new float[n];
		System.out.println("\nNhap danh sach cac so thuc");	
		Cau2.Read_List(arr,sc);

		System.out.println("\nDanh sach cac so thuc vua nhap");
		Cau2.Print_List(arr,sc);
		
		System.out.println("\nSo lon nhat trong danh sach: " + Cau2.MAX(arr));
		System.out.println("\nSo be nhat trong danh sach: " + Cau2.MIN(arr));
		System.out.println("\nTong cac so trong danh sach: " + Cau2.SUM(arr));
	}
}