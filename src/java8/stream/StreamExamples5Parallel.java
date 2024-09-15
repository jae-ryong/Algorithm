package java8.stream;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples5Parallel {
    public static void main(String[] args) {
        final long start =System.currentTimeMillis();
        Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .map(i->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i;
                })
                .forEach(i-> System.out.println(i));
        System.out.println(System.currentTimeMillis()-start);
        System.out.println("===================================");
        final long start2 =System.currentTimeMillis();
        Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                .parallelStream()
                .map(i->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i;
                })
                .forEach(i-> System.out.println(i));
        System.out.println(System.currentTimeMillis()-start2);
    }
}
