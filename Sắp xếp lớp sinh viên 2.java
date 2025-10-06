import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Student {
    private String msv, ten, ns, lop;
    private double gpa;

    public Student() {
    }

    public Student(String msv, String ten, String ns, String lop, double gpa) {
        this.msv = msv;
        this.ten = ten;
        this.ns = ns;
        this.lop = lop;
        this.gpa = gpa;
    }

    public void nhap(Scanner sc) {
        msv = sc.nextLine();
        ten = sc.nextLine();
        ns = sc.nextLine();
        lop = sc.nextLine();
        gpa = sc.nextDouble();
        sc.nextLine();
    }

    public void chuanhoaten() {
        String[] parts = ten.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (String temp : parts) {
            if (temp.length() > 0) {
                res.append(Character.toUpperCase(temp.charAt(0)));
                for (int i = 1; i < temp.length(); i++) {
                    res.append(Character.toLowerCase(temp.charAt(i)));
                }
                res.append(" ");
            }
        }
        ten = res.toString().trim();
    }

    public void chuanhoaNS() {
        if (ns.length() >= 2 && ns.charAt(1) == '/') {
            ns = "0" + ns;
        }
        if (ns.length() >= 5 && ns.charAt(4) == '/') {
            ns = ns.substring(0, 3) + "0" + ns.substring(3);
        }
    }

    public String getMSV() {
        return msv;
    }

    public String getNS() {
        String[] parts = ns.split("/");
        String ngay = parts[0];
        String thang = parts[1];
        String nam = parts[2];
        return nam + " " + thang + " " + ngay;
    }

    public void in() {
        System.out.printf("%s %s %s %s %.2f\n", msv, ten, ns, lop, gpa);
    }
}

public class Main {
    private static int mod = 1000000007;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(sc.nextLine());
        List<Student> danhsach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String msv = sc.nextLine();
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            String lop = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            Student sv = new Student(msv, ten, ns, lop, gpa);
            sv.chuanhoaNS();
            sv.chuanhoaten();
            danhsach.add(sv);
        }
        danhsach.sort((x, y) -> {
            String s1 = x.getNS();
            String s2 = y.getNS();
            int cmp = s1.compareTo(s2);
            if (cmp != 0) {
                return cmp;
            }
            return x.getMSV().compareTo(y.getMSV());
        });
        for (Student x : danhsach) {
            x.in();
        }
    }
}
