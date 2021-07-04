package Buoi01;
import java.util.Scanner;

public class Cau5 {

	//Hàm kiểm tra số nguyên tố
	public static boolean check_prime_Number(int n){
		if(n<2) return false;
		else{
			for(int i=2;i<=(int)Math.sqrt(n);i++){
				if(n%i==0){
					return false;
				}
			}
		}
		return true;
	}

	//Hàm đổi thập phân sang nhị phân
	public static void check_Binary(int n){
		int[] arr = new int[20];
		int n1=n,k,count=0,p=0;

		//Thuật toán tìm số nhị phân 
		do
		{
			k = n%2;
			arr[p]=k;
			p+=1;
			count+=1;
			n = n/2;
			k = n;

		}while(k!=0);

		//In số nhị phân theo thứ tự ngược lại(Mỗi phần tử mảng là 1 kí tự nhị phân)
		System.out.print("\nSo nguyen to "+n1+" da chuyen doi sang nhi phan: ");
		
		for(int i=count-1;i>=0;i--){
			System.out.print(arr[i]);
		}

	}
	
	//Hàm chính
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap vao 1 so nguyen de kiem tra: ");
		int n = Cau3.check_exception(sc);

		if(Cau5.check_prime_Number(n) == false)
			System.out.println("\nSo "+n+" khong phai la so nguyen to");
				else
					System.out.println("\nSo "+n+" la so nguyen to");

		if(Cau5.check_prime_Number(n))
			Cau5.check_Binary(n);
	}
}
