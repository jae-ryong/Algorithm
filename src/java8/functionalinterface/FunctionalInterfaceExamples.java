package java8.functionalinterface;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExamples {
    private void run4FunctionalInterfaceExamples() {
        System.out.println("---------Function---------");

        Function<String,Integer> toInt = new Function<String,Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };
        Integer number = toInt.apply("123");
        System.out.println(number);

        Function<String,Integer> toInt2 = value -> Integer.parseInt(value);
        Integer number2 = toInt2.apply("123");
        System.out.println(number2);

        final Function<Integer,Integer> identity = Function.identity();
        System.out.println(identity.apply(100));

        System.out.println("---------Consumer---------");

        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        print.accept("hello");

        Consumer<String> print2 = value -> System.out.println(value);
        print.accept("hello2");

        System.out.println("---------Predicate---------");
        Predicate<Integer> isPositive = i -> i > 0;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0 ,1 ,2,3, 4, 5);
        System.out.println("positive integer " + filter(numbers, isPositive));
        System.out.println("positive integer " + filter(numbers, i -> i > 0));

        System.out.println("---------Supplier---------");
        Supplier<String> supplier = () -> "Hello ";
        System.out.println(supplier.get() + "World");
        long start = System.currentTimeMillis();
        print(5,()-> getVeryExpensiveValue());
        print(-2,()-> getVeryExpensiveValue());
        print(1,()-> getVeryExpensiveValue());
        System.out.println("It took " + (System.currentTimeMillis() - start)/1000 + "s");
    }

    private static String getVeryExpensiveValue(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "JaeRyong";
    }

    private static void print(int number, Supplier<String> supplier) {
        if(number >= 0){
            System.out.println("The value is " + supplier.get());
        } else{
            System.out.println("Invalid");
        }
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for(T input : list){
            if(filter.test(input)){
                result.add(input);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        println(1,2,3,(i1,i2,i3)-> String.valueOf(i1 + i2 + i3));
        println("Area is ",12, 20,(message,length,width)-> String.valueOf(message + length * width));

        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrrency(new BigDecimal("120.00")));
    }

    private static <T1,T2, T3> void println(T1 t1 ,T2 t2 ,T3 t3,Function3<T1,T2,T3, String> function){
        System.out.println(function.apply(t1, t2, t3));
    }


}

@FunctionalInterface
interface Function3<T1,T2,T3,R> {
    R apply(T1 t1 ,T2 t2 ,T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency{
    String toCurrrency(BigDecimal value);
}