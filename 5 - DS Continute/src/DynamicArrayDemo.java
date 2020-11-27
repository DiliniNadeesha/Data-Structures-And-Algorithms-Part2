import java.security.spec.RSAOtherPrimeInfo;

public class DynamicArrayDemo {

    public static int a = 10;

    public static void main(String[] args) {
        System.out.println(a);
        something(a);
        somethingSomething(Paniya.name);
        System.out.println(Paniya.name);
    }

    public static void something(int a){
        System.out.println(a);
        a=20;
    }

    public static void somethingSomething(String name){
        name = "IJSE";
        System.out.println(a);
    }

}
