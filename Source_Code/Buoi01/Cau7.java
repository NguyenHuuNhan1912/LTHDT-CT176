package Buoi01;
import java.util.Scanner;

public class Cau7{
 	
 	//Hàm nhập mảng các số nguyên
	public static void read_List(int[] arr, Scanner sc){
		for(int i=0;i<arr.length;i++){
			System.out.print("\nNhap so thu "+(i+1)+": ");
			arr[i] = Cau3.check_Exception(sc);
		}
	}

	//Hàm tìm giá trị x xuất hiện bao nhiêu lần trong mảng(x nhập từ bàn phím)
	public static int countX(int[] arr, int x){
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == x){
				count += 1;
			}
		}
		return count;
	}

	//Hàm đổi chỗ hai phần tử
	public static void swap(int[] arr, int i, int count){
		int temp = arr[i];
			arr[i] = arr[count];
			arr[count] = temp;
	}

	//Thuật toán sắp xếp chọn
	public static void selection_Sort(int[] arr){
		int i,j,count,min;
		for(i=0;i<arr.length-1;i++){
			min = arr[i];
			count = i;
			for(j=i+1;j<arr.length;j++){
				if(arr[j] < min ){
					min = arr[j];
					count = j;
				}
			}
			swap(arr,i,count);
		}
	}

	//Hàm in mảng các số nguyên
	public static void print_List(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
 	//Hàm 
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);

		System.out.print("\nDanh sach ban co bao nhieu so nguyen: ");
		int n = Cau3.check_Exception(sc);
		//Ta sử dụng lại hàm check_Exception của câu 3
		//Sử dụng được vì phạm vi truy cập là public
		//Nếu phạm vi truy cập là public nhưng khác gói thì chúng ta phải import vào

		int[] arr = new int[n];
		Cau7.read_List(arr,sc);

		System.out.print("\nNhap phan tu can tim kiem: ");
		int x = Cau3.check_Exception(sc);

		System.out.println("\nDanh sach co " + (Cau7.countX(arr,x)) + " so " + x);
		
		System.out.println("\nDanh sach da sap xep");
		Cau7.selection_Sort(arr);

		Cau7.print_List(arr);
	}
}