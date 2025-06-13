import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreams {

    public record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "Audi", "A5", 1990),
                new Car("sedan", "Mercedes", "E class", 2500),
                new Car("hatchback", "Skoda", "Octavia", 1600),
                new Car("hatchback", "Toyota", "HRV", 1450));

        
        //streams api can schedule tasks for execution in parralel
        //parrallelStream().sequential removes the parralel execution and .parrallel enables it back
        cars.parallelStream()
            .sequential()
            .parallel()
            .forEach(e -> System.out.println("asd"));
    }
}