package Buoi01;
import java.util.Scanner;

public class Cau6{

	//Hàm tách tên
	public static String get_Name(String fullname){

		String name = new String(fullname);

		name = name.trim();

		return name.substring(name.lastIndexOf(" ")+1);

	}
	public static void main(String[] args){
		
		Scanner sc  = new Scanner(System.in);

		System.out.print("\nNhap ho va ten: ");

		String fullname = sc.nextLine();

		System.out.println("\nTen da tach: " + Cau6.get_Name(fullname));
		
	}
}
/*

------->_Note_<--------

	1. Hàm trim
	  - Hàm trim có cú pháp <Name_String>.trim()
	  - Hàm trim có tác dụng xóa khoảng trắng ở đầu và cuối chuỗi

  2. Hàm lastIndexOf
      - Hàm lastIndexOf có cú pháp <Name_String>.lastIndexOf(<character>) 
      - Hàm lastIndexOf có tác dụng trả về vị trí có kí tự(character) xuất hiện cuối cùng trong chuỗi
	
	3. Hàm substring
			- Hàm substring có cú pháp <Name_String>.substring(<value>)
			- Hàm substring có tác dụng trả về chuỗi bắt đầu tự vị trí value

------->_End_<--------	

*/