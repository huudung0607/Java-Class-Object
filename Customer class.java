import com.sun.source.tree.Tree;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
class Customer{
    private String maKH,hoTen,diaChi,phone,email;
    Customer(){}
    public Customer(String maKH,String hoTen,String diaChi,String phone,String email){
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.phone = phone;
        this.email = email;
    }
    public void in(){
        System.out.print(maKH + " " + hoTen + " " + diaChi + " " + phone + " " + email);
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
}
public class Main {
    private static int mod = 1000000007;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Customer cs = new Customer(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
        cs.in();
    }
}
