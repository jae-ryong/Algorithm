package java8.stream;

public class ClosureExamples {
    public static void main(String[] args) {
        int number = 100;

        System.out.println("Anonymous class");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable.run();

        System.out.println("Lambda");
        Runnable runnable2 = () -> System.out.println(number);
        runnable2.run();

        System.out.println("Method Lamda");
        testClosure("jaeryong",()-> System.out.print(number));
    }

    private static void testClosure(String name, Runnable runnable){
        System.out.print("Start " + name + ": ");
        runnable.run();
    }
}
