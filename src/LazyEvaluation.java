import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluation {

    public record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(10, 11, 12, 13, 14);

        // streams are lazy in execution
        // executet only when terminal/final execution

        Stream<Integer> filteredIntegerStream = integerStream.filter(i -> {
            System.out.println("Filtering integer: " + i);
            return i % 2 == 0;
        });

        // line 39 stream is executed at line 45 filteredIntegerStream.count()
        System.out.println("Count = " + filteredIntegerStream.count());
    }
}
