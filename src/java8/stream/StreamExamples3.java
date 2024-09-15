package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 3, 4, 5);

        System.out.println("collect(toList()) : " +
                numbers.stream()
                        .filter(i -> i>2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .collect(toList()));

        System.out.println("collect(toSet()) : " +
                numbers.stream()
                        .filter(i -> i>2)
                        .map(i -> i * 2)
                        .map(i -> "# " + i)
                        .collect(toSet()));

        System.out.println("collect(joining) : " +
                numbers.stream()
                        .filter(i -> i>2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ")));

        System.out.println("collect(joining2) : " +
                numbers.stream()
                        .filter(i -> i>2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ","[","]")));

        System.out.println("collect(joining3) : " +
                numbers.stream()
                        .filter(i -> i>2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(", ","[","]")));

        Integer integer3 = 3;
        System.out.println(
                Stream.of(1,2,3,4,5)
                        .filter(i -> i == integer3)
                        .findFirst()
        );

        
        Stream.of(1,2,3,4,5)
                .forEach(i -> System.out.println(i));


    }
}
