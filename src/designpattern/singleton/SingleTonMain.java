package designpattern.singleton;

public class SingleTonMain {
    public static void main(String[] args) {
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();

        System.out.println(singleTon1.hashCode());
        System.out.println(singleTon2.hashCode());
        System.out.println(singleTon1 == singleTon2);
    }
}
