import com.sun.source.tree.Tree;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
class Student{
    private String msv,hoTen,ngaySinh,lop;
    private double gpa;
    Student(){}
    public Student(String msv,String hoTen,String ngaySinh,String lop,double gpa){
        this.msv = msv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.gpa = gpa;
    }
    public void chuanHoaTen(){
        String []arr = hoTen.trim().toLowerCase().split("\\s+");
        String res = "";
        for(var x : arr){
            res += Character.toUpperCase(x.charAt(0));
            for(int j = 1;j < x.length();j++){
                res += Character.toLowerCase(x.charAt(j));
            }
            res += " ";
        }
        hoTen = res.trim();
    }
    public void chuanHoaNS(){
        if (ngaySinh.length() >= 2 && ngaySinh.charAt(1) == '/') {
            ngaySinh = "0" + ngaySinh;
        }
        if (ngaySinh.length() >= 5 && ngaySinh.charAt(4) == '/') {
            ngaySinh = ngaySinh.substring(0, 3) + "0" + ngaySinh.substring(3);
        }
    }
    public void in(){
        System.out.printf("%s %s %s %s %.2f",msv,hoTen,ngaySinh,lop,gpa);
    }
}
public class Main {
    private static int mod = 1000000007;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Student s = new Student(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextDouble());
        s.in();
    }
}
