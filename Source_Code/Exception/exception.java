package Exception;
import java.util.Scanner;
public class exception{

	//Hàm xóa màn hình
	public static void clear(){
		try{
			if(System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		}catch(Exception ex) {}
	}

	//Xử lí ngoại lệ kiểu float
	public static float Number_Format_Float(){
		Scanner sc = new Scanner(System.in);
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
	
	//Xử lí ngoại lệ kiểu Integer 
	public static int Number_Format_Integer(){
		Scanner sc = new Scanner(System.in);
		String s;
		int n;
		do{
			s = sc.nextLine();
			try{n = Integer.parseInt(s);}
			catch(NumberFormatException e){
				n = Integer.MAX_VALUE;
				System.out.print("\nSai dinh dang, nhap lai: ");
			}
		}while(n==Integer.MAX_VALUE);
		return n;
	}
}