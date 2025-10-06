import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
class Student{
    private String msv,hoTen,ngaySinh,lop;
    private double gpa;
    private int drl;

    Student(){}
    Student(String msv,String hoTen,String ngaySinh, String lop,double gpa, int drl){
        this.msv = msv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.gpa = gpa;
        this.drl = drl;
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
    public String getLop(){
        return lop;
    }
    public double getGpa(){
        return gpa;
    }
    public String getSortedName(){
        String[] v = hoTen.split("\\s+");
        String tenChinh = v[v.length - 1];
        for(int i = 0 ;i < v.length - 1;i++){
            tenChinh = tenChinh + " " + v[i];
        }
        return tenChinh;
    }
    public int getDrl(){
        return drl;
    }
    public void in(){
        System.out.printf("%s %s %s %s %.2f %d",msv,hoTen,ngaySinh,lop,gpa,drl);
    }
}
public class Main {
    private static int mod = 1000000007;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            Student s = new Student(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextInt());
            sc.nextLine();
            s.chuanHoaTen();s.chuanHoaNS();
            list.add(s);
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGpa() == o2.getGpa()){
                    return Integer.compare(o2.getDrl(),o1.getDrl());
                }
                return Double.compare(o2.getGpa(),o1.getGpa());
            }
        });
        for(var x : list){
            x.in();
            System.out.println();
        }
    }
}
