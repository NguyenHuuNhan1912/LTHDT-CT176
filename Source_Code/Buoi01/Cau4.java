package Buoi01;
import java.util.Scanner;
import java.lang.Math;

public class Cau4{

	//Hàm giải phương trình bậc 1 
	public static void PTB1(float a, float b){
		if(a==0){
			if(b==0)
				System.out.println("\nPhuong trinh co vo so nghiem");
					else
						System.out.println("\nPhuong trinh vo nghiem");
		}
		else System.out.println("\nPhuong trinh co 1 nghiem: " + (-b/a));
	}

	//Hàm giải phương trình bậc 2 
	public static void PTB2(float a, float b, float c){
		float denta = b*b - (4*a*c);
		if(a==0) 
			PTB1(b,c);
		else{
			if(denta > 0){
				System.out.println("\nPhuong trinh co 2 nghiem phan biet");
				System.out.println("\nX1: "+  ((-b - Math.sqrt(denta))/(2*a)) );
				System.out.println("\nX2: "+  ((-b + Math.sqrt(denta))/(2*a)) );
			}
			else if(denta < 0){
				System.out.println("\nPhuong trinh co nghiem kep: "+  (-b/(2*a)) );
			}
			else System.out.println("\nPhuong trinh vo nghiem");
		}

	}
	
	//Hàm chính
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("\nNhap cac tham so de giai phuong trinh bac 2");

		System.out.print("\nNhap a: ");
		int a = Cau3.check_Exception(sc);

		System.out.print("\nNhap b: ");
		int b = Cau3.check_Exception(sc);
		
		System.out.print("\nNhap c: ");
		int c = Cau3.check_Exception(sc);

		Cau4.PTB2(a,b,c);
	}
}