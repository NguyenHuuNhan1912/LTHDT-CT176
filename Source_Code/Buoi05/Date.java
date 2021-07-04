package Buoi05;
import java.util.Scanner;

public class Date {

    //Khai báo thuộc tính
    private int day,month,year;

    //Default constructor 
    public Date(){
        day = 1;
        month = 1;
        year = 2001;
    }

    //Coppy constructor
    public Date(Date d){
        day = d.day;
        month = d.month;
        year = d.year;
    }

    //Constructor 3 tham số
    public Date(int a, int b, int c){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Hàm nhập 
    public void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay: ");
        day = sc.nextInt();
        System.out.print("Nhap thang: ");
        month = sc.nextInt();
        System.out.print("Nhap nam: ");
        year = sc.nextInt();
    }

    //Hàm in 
    public void print(){
        System.out.print(day+"/"+month+"/"+year);
    }

    //Hàm in có kiểu trả về 
    public String toString(){
        return (day+"/"+month+"/"+year);
    }
    
}
